package com.cba.b2c.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.cba.api.dto.CertificateGenerationDTO;
import com.cba.api.dto.CustomerDTO;
import com.cba.api.dto.InvoiceGenerationDTO;
import com.cba.api.dto.ReportResultDTO;
import com.cba.api.dto.ReportSearchCriteriaDTO;
import com.cba.api.dto.SubscriptionDTO;
import com.cba.api.dto.SubscriptionParamsDTO;
import com.cba.api.exceptions.PackageCodeNotFound;
import com.cba.api.helper.CoreBillingAPIHelper;
import com.cba.api.services.CoreBillingB2BService;
import com.cba.api.services.CoreBillingReportService;
import com.cba.api.services.EmailService;
import com.cba.api.services.PdfService;
import com.cba.api.utils.EmailDetails;
import com.cba.entity.PackageType;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/corebilling/b2c")
@RestController
public class CoreBillingSubscriptionController {

	/*
	 * Autowired Service for Core billing related functions
	 */
	@Autowired
	CoreBillingB2BService coreBillingB2BServices;

	
	@Autowired
	CoreBillingReportService reportServices;
	
	
	@Autowired
	EmailService emailService;

	@Autowired
	private PdfService pdfService;

	CoreBillingAPIHelper helper = new CoreBillingAPIHelper();

	/**
	 * API to list all the active packages configured in Core Billing
	 * 
	 * 
	 * @return response List of active packages configured in Core Billing
	 */
	@GetMapping(value = "/getpackages")
	public List<PackageType> listAllPackages() throws PackageCodeNotFound {
		return (coreBillingB2BServices.listAllPackages());
	}

	/**
	 * This needs to be integrated to some other system and fetch the customer
	 * details TODO we need to implement the integration after discussion with
	 * Customer
	 * 
	 * @param vinNumber
	 * @return
	 */
	@RequestMapping(value = "/getcustomerdetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO getCustomerDetails(@RequestBody SubscriptionParamsDTO input) {
		return coreBillingB2BServices.getCustomerDetails(input.getVinNumber());
	}

	/**
	 * @author
	 * @param vinNumber
	 * @return
	 */
	@RequestMapping(value = "/getsubscriptionsbyvin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SubscriptionDTO> getSubscriptionsByVin(@RequestBody SubscriptionParamsDTO input) {
		System.out.println("VINNN -->" + input.getVinNumber());
		return coreBillingB2BServices.getSubscriptionsByVin(input.getVinNumber());
	}

	/**
	 * Method to get the package type details by given package type code
	 * 
	 * @param packageTypeCode The package type code for which the details to be
	 *                        retrieved
	 * @return The Package Type details
	 */
	@RequestMapping(value = "/getpackagetypebycode", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PackageType> getPackageTypeByCode(@RequestBody SubscriptionParamsDTO input) {
		return coreBillingB2BServices.getPackageTypeByCode(input.getPackageTypeCode());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/savesubscription", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveSubscription(@RequestBody SubscriptionParamsDTO input) {
		try {
			 coreBillingB2BServices.saveSubscription(input);
			return ResponseEntity.ok().body("Success");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(" Error occured while saving the subscription");
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/downloadcertificate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> downloadCertificate(@RequestBody SubscriptionParamsDTO input) {

		try {
			CertificateGenerationDTO certificateDTO = coreBillingB2BServices
					.getCertificateDTO(input.getCertificateNumber());

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
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(" Error occured while generating the certificate");
		}
		return null;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/downloadinvoice", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> downloadInvoice(@RequestBody SubscriptionParamsDTO input) {
		System.out.println("Inside" + input.getCertificateNumber());
		try {
			InvoiceGenerationDTO invoiceDTO = coreBillingB2BServices.getInvoiceDTO(input.getCertificateNumber());
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
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" Error occured while generating the invoice");
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
		FileInputStream fin = new FileInputStream(file);
		byte[] arr = new byte[(int) file.length()];

		try {
			fin.read(arr);
			fin.close();
			return arr;
		} finally {
			fin.close();
		}
	}

	@GetMapping("/sendemail")
	public ResponseEntity<String> sendEmail(@RequestHeader HttpHeaders header) {

		try {
			List<String> emails = header.get("email");
			EmailDetails details = new EmailDetails();
			details.setRecipientEmail(emails.get(0));
			details.setRecipientName("Balaji Desikan");
			details.setSubject(" Congradulations !!");
			details.setRefNumber("CUP007223437343");
			emailService.sendEmail(details);
			return ResponseEntity.ok().body("Success");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/getSubscriptionRenewalReport", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReportResultDTO>> getSubscriptionRenewalReport(ReportSearchCriteriaDTO reportSearchCriteriaDTO){
        try {
            return ResponseEntity.ok().body(reportServices.getSubscriptionRenewalReport(reportSearchCriteriaDTO));
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/getTotalCollectionsReport", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReportResultDTO>> getTotalCollectionsReport(ReportSearchCriteriaDTO reportSearchCriteriaDTO){
        try {
            return ResponseEntity.ok().body(reportServices.getTotalCollectionsReport(reportSearchCriteriaDTO));
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        
    }

}
