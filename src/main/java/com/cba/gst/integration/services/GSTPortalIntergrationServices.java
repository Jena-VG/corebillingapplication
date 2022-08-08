package com.cba.gst.integration.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cba.api.dto.CustomerDTO;
import com.cba.entity.Subscription;
import com.cba.gst.integration.dto.Buyerdtl;
import com.cba.gst.integration.dto.Docdtl;
import com.cba.gst.integration.dto.Expdtl;
import com.cba.gst.integration.dto.GSTIntegrationDTO;
import com.cba.gst.integration.dto.Itemdtl;
import com.cba.gst.integration.dto.Sellerdtl;
import com.cba.gst.integration.dto.Trandtl;
import com.cba.gst.integration.dto.Valdtl;
import com.cba.gst.integration.response.Error;
import com.cba.gst.integration.response.GSTResponse;
import com.cba.gst.integration.response.Irn;
import com.cba.gst.integration.utils.GSTPortalDataValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * GST Portal Integration service to push data from Corebilling B2B
 * subscription.
 * 
 * @author Balaji Desikan
 *
 */
@Service
public class GSTPortalIntergrationServices {

	public static final Logger logger = LoggerFactory.getLogger(GSTPortalIntergrationServices.class);

	@Value("${gst.generate.token.url}")
	private String generateTokenUrl;

	@Value("${gst.generate.irn.url}")
	private String generateIRNUrl;

	@Value("${gst.cancel.irn.url}")
	private String cancelIRNUrl;

	@Value("${gst.username}")
	private String userName;

	@Value("${gst.password}")
	private String password;

	@Value("${gst.gstn}")
	private String gstn;

	@Value("${gst.client.code}")
	private String clientCode;

	private static final int TIMEOUT_IN_SECONDS = 100;
	
	@Autowired
	private GSTPortalDataValidator validator;

	/**
	 * This method is used to connect to the GST portal abd generate the
	 * authentication token that needs to be sent in the subsequent calls.
	 * 
	 * @return Base 64 Encrypted Auth Token
	 */
	public String getAuthTokenForInvoice() {

		String url = generateTokenUrl;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("username", userName);
		headers.set("password", password);

		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		HttpEntity<?> reqEntity = new HttpEntity<>(headers);
		ResponseEntity<String> authRes = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, reqEntity,
				String.class);
		String resArr = authRes.getBody().split(",")[0].split(":")[1];
		String resArr1 = resArr.substring(1, resArr.length() - 1);
		logger.info("Token -->" + resArr1);
		return resArr1;
	}

	/**
	 * Method to generate the IRN number and QR code for the invoice if the customer
	 * has GST number attached.
	 * 
	 * @param reqData The Necessary parameters that is required to send data to GST
	 *                portal
	 * @return Generated GST portal response
	 * @throws Exception Throws Exception if there is any issue in posting the data
	 *                   to GST portal
	 */
	public ResponseEntity<GSTResponse> getIRNForInvoice(GSTIntegrationDTO reqData) throws Exception {
		logger.info("getIRNForInvoice...");

		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
		String token = "Bearer " + getAuthTokenForInvoice();
		logger.info("url : " + generateIRNUrl);
		HttpHeaders headers = new HttpHeaders();

		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		headers.set("clientcode", clientCode);
		headers.set("gstin", gstn);

		ObjectMapper mapper = new ObjectMapper();

		try {
			String json = mapper.writeValueAsString(reqData);
			logger.info("mapper.writeValueAsString(reqData) : " + json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		HttpEntity<?> reqEntity = new HttpEntity<>(reqData, headers);
		ResponseEntity<GSTResponse> irnRes = restTemplate.postForEntity(generateIRNUrl, reqEntity, GSTResponse.class);
		logger.info("end of irnRes  : " + irnRes.toString());
		return irnRes;
	}
	
	/**
	 * Helper method to prepare the necessary data and call the GST portal for
	 * subscription renewals
	 * 
	 * @param subscription {@link com.cba.entity.Subscription}
	 * @param customerDTO  {@link com.cba.api.dto.CustomerDTO}
	 * @throws Exception Exception Throws Exception if there is any issue in posting
	 *                   the data to GST portal
	 */

	public void generateIRNAndQRCode(Subscription subscription, CustomerDTO customerDTO) throws Exception {
		GSTIntegrationDTO eInvoice = new GSTIntegrationDTO();
		boolean sezCustomer = "Y".equals(customerDTO.getIsSez()) ? true : false;
		eInvoice.setSelf_gstin(gstn);
		eInvoice.setIrnreq("Y");

		prepareTransactionDetails(eInvoice, customerDTO);
		prepareDocumentDetails(eInvoice, subscription);
		prepareSellerDetails(eInvoice);
		prepareBuyerDetails(eInvoice, customerDTO);

		if (sezCustomer) {
			Expdtl export = new Expdtl();
			export.setExpcat("SEZ");
			export.setWthpay("Y");
			export.setCntcode("IN");
			export.setForcur("INR");
			eInvoice.setExpdtl(export);
		}

		prepareItemDetails(eInvoice, subscription);
		prepareTaxDetails(eInvoice, subscription);
		ArrayList<String> errors = new ArrayList<String>();
		errors = validator.validateEinvoice(eInvoice, errors);
		if(errors.size() > 0) {
			String error = errors.stream().collect(Collectors.joining(","));
			throw new Exception (error);
		}
		ResponseEntity<GSTResponse> response = getIRNForInvoice(eInvoice);
		parseResponse(response, subscription);

	}

	/**
	 * Helper method to parse the response received from the GST portal
	 * 
	 * @param response     {@link com.cba.gst.integration.response.GSTResponse}
	 * @param subscription {@link com.cba.entity.Subscription}
	 * @throws Exception Throws if there is any issues in parsing the response
	 */
	private void parseResponse(ResponseEntity<GSTResponse> response, Subscription subscription) throws Exception {
		GSTResponse gstResponse = response.getBody();
		String respStatus = gstResponse.getStatus();
		if ("0".equals(respStatus)) {
			String errors = gstResponse.getError().stream().map(e -> e.getError_desc())
					.collect(Collectors.joining(","));
			logger.info(" EinvoiceError : " + errors);
			throw new Exception(errors);

		} else if ("1".equals(respStatus)) {
			Irn irn = gstResponse.getData().getIrn();
			String irnStatus = irn.getStatus();
			logger.info("irnStatus 1 : " + irnStatus);
			if ("1".equals(irnStatus)) {
				String irnNbr = irn.getData().getIrn();
				String qrCode = irn.getData().getSigned_qrcode();
				String ackNbr = irn.getData().getAck_no();
				String ackDt = irn.getData().getAck_dt();

				subscription.setIrnNbr(irnNbr);
				subscription.setQrCode(qrCode);
				subscription.setAckNbr(ackNbr);
				subscription.setAckDt(ackDt);
			} else if ("0".equals(irnStatus)) {
				List<Error> errorList = irn.getError();
				String errors = errorList.stream().map(e -> e.getError_desc()).collect(Collectors.joining(","));
				logger.info(" EinvoiceError : " + irnStatus);
				throw new Exception(errors);
			}
		}
	}

	/**
	 * Helper method to prepare the Transaction details section of the GST input
	 * JSON
	 * 
	 * @param eInvoice    Necessary GST parameters to be parsed and prepared
	 * @param customerDTO {@link com.cba.api.dto.CustomerDTO}
	 */
	private void prepareTransactionDetails(GSTIntegrationDTO eInvoice, CustomerDTO customerDTO) {
		boolean sezCustomer = "Y".equals(customerDTO.getIsSez()) ? true : false;
		Trandtl trandtl = new Trandtl();
		if (sezCustomer) {
			trandtl.setTrancatg("EXP");
			trandtl.setReversecharge("N");
			trandtl.setTransactionmode("REG");
		} else {
			trandtl.setTrancatg("B2B");
			trandtl.setReversecharge("N");
			trandtl.setTransactionmode("REG");
		}
		trandtl.setIgstonintra("N");
		trandtl.setEcom_gstin("");
		eInvoice.setTrandtl(trandtl);

	}

	/**
	 * Helper method to prepare the Document details section of the GST input JSON
	 * 
	 * @param eInvoice     Necessary GST parameters to be parsed and prepared
	 * @param subscription {@link com.cba.entity.Subscription}
	 */
	private void prepareDocumentDetails(GSTIntegrationDTO eInvoice, Subscription subscription) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Docdtl docdtl = new Docdtl();
		docdtl.setDocument_type("INV");
		docdtl.setDocno(subscription.getCertificateNbr());
		docdtl.setDocdt(formatter.format(subscription.getCreatedDate())); /// doc date string format dd/mm/yyyy
		eInvoice.setDocdtl(docdtl);
	}

	/**
	 * Helper method to prepare the Seller(KIN) details section of the GST input JSON
	 * @param eInvoice Necessary GST parameters to be parsed and prepared
	 */
	private void prepareSellerDetails(GSTIntegrationDTO eInvoice) {
		Sellerdtl supplierdtl = new Sellerdtl();
		supplierdtl.setSupplier_gstin("37AAGCK5972Q6ZG");
		supplierdtl.setSupplier_lglnm("KIA MOTORS INDIA PRIVATE LIMITED");
		supplierdtl.setSupplier_trdnm("KIA MOTORS INDIA PRIVATE LIMITED");
		supplierdtl.setSupplier_bno(" ");
		supplierdtl.setSupplier_bnm("NH-44, SY.NO.151-2, ERRAMANCHI VILLAGE, PENUKONDA (M)");
		supplierdtl.setSupplier_flno(" ");
		supplierdtl.setSupplier_loc("ANDHRA PRADESH");
		supplierdtl.setSupplier_dst("ANANTPUR");
		supplierdtl.setSupplier_pin("515164");
		supplierdtl.setSupplier_state("37");
		supplierdtl.setSupplier_email("RAMPRASADGUNDETI@KIAINDIA.NET");
		eInvoice.setSupplierdtl(supplierdtl);
	}

	/**
	 * Helper method to prepare the Buyer (Customer) details section of the GST
	 * input JSON
	 * 
	 * @param eInvoice    Necessary GST parameters to be parsed and prepared
	 * @param customerDTO {@link com.cba.api.dto.CustomerDTO}
	 */
	private void prepareBuyerDetails(GSTIntegrationDTO eInvoice, CustomerDTO customerDTO) {
		Buyerdtl buyerdtl = new Buyerdtl();
		buyerdtl.setCust_cd(customerDTO.getCustomerNbr());
		buyerdtl.setBuyer_gstin(customerDTO.getGstNbr());
		buyerdtl.setBuyer_lglnm(customerDTO.getName());
		buyerdtl.setBuyer_trdnm(customerDTO.getName());
		buyerdtl.setBuyer_bno(" ");
		buyerdtl.setBuyer_bnm(customerDTO.getAddressLine1() + customerDTO.getAddressLine2());
		buyerdtl.setBuyer_flno(customerDTO.getCityCode());
		buyerdtl.setBuyer_loc(customerDTO.getState());
		buyerdtl.setBuyer_dst(customerDTO.getDistrict());
		buyerdtl.setBuyer_pin(customerDTO.getPincode());
		buyerdtl.setBuyer_state(customerDTO.getSacCode());
		buyerdtl.setBuyer_email(customerDTO.getEmail());
		eInvoice.setBuyerdtl(buyerdtl);
	}

	/**
	 * Helper method to prepare the Item details section of the GST
	 * input JSON
	 * @param eInvoice Necessary GST parameters to be parsed and prepared
	 * @param subscription {@link com.cba.entity.Subscription}
	 */
	private void prepareItemDetails(GSTIntegrationDTO eInvoice, Subscription subscription) {
		List<Itemdtl> itemList = new ArrayList<Itemdtl>();
		Itemdtl itemdtls = new Itemdtl();
		itemdtls.setPrdnm(subscription.getCertificateNbr());
		itemdtls.setPrddesc(subscription.getProgramType());
		itemdtls.setHsncd("998729");
		itemdtls.setBarcde(null);
		itemdtls.setQty(1);
		itemdtls.setFreeqty(0.00);
		itemdtls.setUqc("CTN");
		itemdtls.setUnitrate(subscription.getTotalAmount());
		itemdtls.setGrossamt(subscription.getTotalAmount());
		itemdtls.setDiscount(subscription.getCgst() + subscription.getIgst() + subscription.getSgst()
				+ subscription.getRsacgst() + subscription.getRsaigst() + subscription.getRsasgst());
		itemdtls.setOthchrg(0);
		itemdtls.setAssamt(subscription.getPkgPrice() + subscription.getRsaAmount());
		itemdtls.setTaxability("TAX");
		double cgst = subscription.getCgst() + subscription.getRsacgst();
		if (cgst > 0)
			itemdtls.setCgstrt(9);
		itemdtls.setCgstamt(cgst);
		double sgst = subscription.getSgst() + subscription.getRsasgst();
		if (sgst > 0)
			itemdtls.setSgstrt(9);
		itemdtls.setSgstamt(sgst);
		itemdtls.setCessrt(0);
		double igst = subscription.getIgst() + subscription.getRsaigst();
		if (igst > 0)
			itemdtls.setIgstrt(18);
		itemdtls.setIgstamt(igst);
		itemdtls.setStatecess(0);
		itemdtls.setCessamt(0);
		itemdtls.setCessnonadval(0);
		itemdtls.setStatecessrt(0);
		itemdtls.setStatecessamt(0);
		itemdtls.setTotitemval(subscription.getTotalAmount());
		itemList.add(itemdtls);
		eInvoice.setItemdtls(itemList);
	}

	/**
	 * Helper method to prepare the Tax details section of the GST
	 * input JSON
	 * @param eInvoice Necessary GST parameters to be parsed and prepared
	 * @param subscription {@link com.cba.entity.Subscription}
	 */
	private void prepareTaxDetails(GSTIntegrationDTO eInvoice, Subscription subscription) {
		Valdtl valdtl = new Valdtl();
		double cgst = subscription.getCgst() + subscription.getRsacgst();
		double sgst = subscription.getSgst() + subscription.getRsasgst();
		double igst = subscription.getIgst() + subscription.getRsaigst();
		valdtl.setTtlassval(subscription.getPkgPrice() + subscription.getRsaAmount());
		valdtl.setCgstval(cgst);
		valdtl.setSgstval(sgst);
		valdtl.setIgstval(igst);
		valdtl.setCesval(0);
		valdtl.setStcesval(0);
		valdtl.setCesnonadval(0);
		valdtl.setDiscval(0);
		valdtl.setOthchrg(0);
		valdtl.setTotinvval(subscription.getTotalAmount());
		eInvoice.setValdtl(valdtl);
	}

 
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		int timeout = 1000 * TIMEOUT_IN_SECONDS;
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(timeout);
		return clientHttpRequestFactory;
	}

 
}
