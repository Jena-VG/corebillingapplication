package com.cba.api.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cba.api.constants.CoreBillingConstants;
import com.cba.api.dto.CertificateGenerationDTO;
import com.cba.api.dto.CustomerDealerDTO;
import com.cba.api.dto.GSTParamsDTO;
import com.cba.api.dto.InvoiceGenerationDTO;
import com.cba.api.exceptions.PackageCodeNotFound;
import com.cba.api.exceptions.UnknownUserException;
import com.cba.api.services.ConnectCarServices;
import com.cba.api.services.CoreBillingSecurityServices;
import com.cba.api.services.CoreBillingServices;
import com.cba.api.services.PdfService;
import com.cba.entity.PackageType;
import com.lowagie.text.DocumentException;

/**
 * Main API for all core billing operations. This acts as a fornt controller for
 * all API integrations between DMS and COrebilling
 *
 * @author manikandan.rajendran
 * @version 1.0
 * @since 2022-06-17
 */
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/corebilling/api")
@RestController
public class CoreBillingAPIController {

	/*
	 * Autowiered Service for Core billing related functions
	 */
	@Autowired
	CoreBillingServices coreBillingServices;

	/*
	 * Autowiered service for calling CCS related API
	 */
	@Autowired
	ConnectCarServices cCCAPIServices;

	@Autowired
	private PdfService pdfService;

	/*
	 * Security related functions
	 */
	@Autowired
	@Qualifier("coreBillingSecurityServices")
	CoreBillingSecurityServices coreBillingSecurityServices;

	private final Logger LOGGER = LoggerFactory.getLogger(CoreBillingAPIController.class);

	/**
	 * Entry API for udpating all the subscription renewals that happens in DMS to
	 * Core Billing
	 * 
	 * @param customerDealerdto - Data transfer object that is used to carry the
	 *                          JSON data received from DMS
	 * @return response status
	 */
	@RequestMapping(method = RequestMethod.OPTIONS, value = "/savesubscription", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveSubscription(@RequestBody CustomerDealerDTO customerDealerdto) {
		LOGGER.info("Inside savesubscription of CoreBillingController");
		try {
			coreBillingServices.save(customerDealerdto);
			return ResponseEntity.status(HttpStatus.OK).body("Success");
		} catch (Exception e) { 
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
		}

	}

	/**
	 * API to validate whether the given VIN number is enabled with connected car
	 * services or not
	 * 
	 * @param header - Contains the VIN and other security details
	 * @return response status - Full-Enrollment – Customer can use application.
	 *         Customer do provisioning in App. In-Vehicle – Customer can’t use
	 *         application. Customer do provisioning in vehicle. Shell – Customer
	 *         can use CCS service. Ready to use CCS Service. Basic – Customer can’t
	 *         use CCS service. insufficient data.
	 */
	@GetMapping("/validatevin")
	public ResponseEntity<String> validateVIN(@RequestHeader HttpHeaders header) {

		try {
			List<String> vinNum = header.get("VIN");
			ResponseEntity<String> responseFromCCS = cCCAPIServices.validateVINNumber(vinNum.get(0));
			if (responseFromCCS.getStatusCode() != HttpStatus.OK) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
			} else {
				return ResponseEntity.status(HttpStatus.OK).body("Success");
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
		}
	}

	/**
	 * API to list all the active packages configured in Core Billing
	 * 
	 * 
	 * @return response List of active packages configured in Core Billing
	 */
	@GetMapping(value = "/getpackages")
	public List<PackageType> listAllPackages() throws PackageCodeNotFound {
		return (coreBillingServices.listAllPackages());
	}

	/**
	 * Security methods to get the authorization tokens
	 * 
	 * @param header Security parameters to validate the user
	 * @return Generated Token
	 */
	@GetMapping(value = "/gettoken")
	public ResponseEntity<String> getToken(@RequestHeader HttpHeaders header) {
		String clientId = (header.get(CoreBillingConstants.CLIENT_ID) != null
				&& !header.get(CoreBillingConstants.CLIENT_ID).isEmpty())
						? header.get(CoreBillingConstants.CLIENT_ID).get(0)
						: "";
		String clientKey = (header.get(CoreBillingConstants.CLIENT_SECRET_KEY) != null
				&& !header.get(CoreBillingConstants.CLIENT_SECRET_KEY).isEmpty())
						? header.get(CoreBillingConstants.CLIENT_SECRET_KEY).get(0)
						: "";
		if (!(clientId.length() == 0 || clientId == null || clientKey.length() == 0 || clientKey == null)) {
			try {
				String status = coreBillingSecurityServices.getToken(clientId, clientKey);
				return ResponseEntity.status(HttpStatus.OK).body(status);

			} catch (UnknownUserException unknown) {
				ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not an Authorized user");
			}
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not an Authorized user");
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not an Authorized user");
	}

	/**
	 * This method is used to generate and download the ccs subscription certificate
	 * based on the details passed from DMS
	 * 
	 * @param certificateDTO - Data transfer object containing the required
	 *                       information to be printed on the certificate. Refer
	 *                       {@link com.cba.api.dto.CertificateGenerationDTO}
	 * @return JSON formatted pdf file generated for the certificate
	 */
	@RequestMapping(method = RequestMethod.OPTIONS, value = "/downloadcertificate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> downloadCertificate(@RequestBody CertificateGenerationDTO certificateDTO) {
		System.out.println(certificateDTO);
		try {
			Path file = Paths.get(pdfService.generatePdf(certificateDTO).getAbsolutePath());
			if (Files.exists(file)) {
				HttpHeaders headers = new HttpHeaders();
				File fileObj = file.toFile();
				byte[] byteArray = readFile(fileObj);
				JSONObject json = new JSONObject();
				json.put("file", Base64.getEncoder().encodeToString(byteArray));
				System.out.println(json.toString());
				return ResponseEntity.ok().headers(headers).body(json.toString());
			}
		} catch (DocumentException | IOException ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(" Error occured while generating the certificate");
		}
		return null;

	}

	/**
	 * Local method to read the file contents form the File object
	 * 
	 * @param file The generated file from where the contents to be read
	 * @return - Byte array of the contents read from the file
	 * @throws IOException Occurs when there is any exception while reading the
	 *                     contents from the file
	 */
	private byte[] readFile(File file) throws IOException {
	    FileInputStream fin = new FileInputStream (file);
	    byte[] arr = new byte[(int)file.length()];

	    try {
	    	fin.read(arr);
	    	fin.close();
	    	return arr;
	    } finally {
	    	fin.close();
	    }
	}
	
	
	/**
	 * This method is used to generate and download the invoice copy based on the
	 * details passed from DMS
	 * 
	 * @param invoiceDTO- Data transfer object containing the required information
	 *                    to be printed on the certificate. Refer
	 *                    {@link com.cba.api.dto.InvoiceGenerationDTO}
	 * @return JSON formatted pdf file generated for the invoice
	 */
	@RequestMapping(method = RequestMethod.OPTIONS, value = "/downloadinvoice", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> downloadInvoice(@RequestBody InvoiceGenerationDTO invoiceDTO) {
		try {
			Path file = Paths.get(pdfService.generateInvoice(invoiceDTO).getAbsolutePath());
			if (Files.exists(file)) {
				HttpHeaders headers = new HttpHeaders();
				File fileObj = file.toFile();
				byte[] byteArray = readFile(fileObj);
				JSONObject json = new JSONObject();
				json.put("file", Base64.getEncoder().encodeToString(byteArray));
				System.out.println(json.toString());
				return ResponseEntity.ok().headers(headers).body(json.toString());
			}
		} catch (DocumentException | IOException ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(" Error occured while generating the invoice");
		}
		return null;
	}
	
	/**
	 * This method is used for update the IRN and QR code from DMS application
	 * 
	 * @param gstParamsDTO - DTO is used for get request body values of IRN and QR code 
	 * @return - It returns the response code
	 * @throws Exception - If there are any errors occurred in update the IRN and QR code 
	 */
	@RequestMapping(method = RequestMethod.OPTIONS, value = "/updateIRNandQRCode", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateIRNandQRCode(@RequestBody GSTParamsDTO gstParamsDTO) throws Exception{

		LOGGER.info("Inside savesubscription of CoreBillingController");
		try {
			coreBillingServices.updateIRNandQRCode(gstParamsDTO);
			return ResponseEntity.status(HttpStatus.OK).body("Success");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
		}

	}
	
	
	
	
	
	
	
	
}
