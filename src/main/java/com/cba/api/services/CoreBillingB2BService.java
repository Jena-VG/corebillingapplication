package com.cba.api.services;

import java.util.List;

import com.cba.api.dto.CertificateGenerationDTO;
import com.cba.api.dto.CustomerDTO;
import com.cba.api.dto.InvoiceGenerationDTO;
import com.cba.api.dto.SubscriptionDTO;
import com.cba.api.dto.SubscriptionParamsDTO;
import com.cba.entity.PackageType;
import com.cba.entity.Subscription;

/**
 * All Service related to Customer renewing the subscription from mobile App.
 * 
 * @author Subash Kumar T
 *
 */
public interface CoreBillingB2BService {

	/**
	 * Method to return all active package types to display as options to choose for
	 * renewal
	 * 
	 * @return The List of Package Type objects.
	 */
	public List<PackageType> listAllPackages();

	/**
	 * API to fetch the customer details either from CCS or other master data
	 * application based on the VIN number.
	 * 
	 * @param vinNumber Customer VIN number
	 * @return The customer details
	 */
	public CustomerDTO getCustomerDetails(String vinNumber);

	/**
	 * API to list all the subscriptions renewed by the give customer VIN number
	 * 
	 * @param vinNumber Customer VIN number
	 * @return The list of all subscription renewals for the given customer VIN
	 *         number
	 */
	public List<SubscriptionDTO> getSubscriptionsByVin(String vinNumber);

	/**
	 * Method to fetch package type details such as package price, GST and RSA
	 * amount for the given package type code.
	 * 
	 * @param packageTypeCode The package type code for which the details to be
	 *                        fetched
	 * @return Details of the package type
	 */
	public List<PackageType> getPackageTypeByCode(String packageTypeCode);

	/**
	 * API method to save subscription renewed from mobile application
	 * 
	 * <b>Step 1 </b> - Using VIN get the customer details & Validate against CCS application
	 * <b>Step 2 </b> - Check if the customer details are already available in the core-billing DB else insert user and customer
	 * <b>Step 3 </b> - Using package type code, get package type details
	 * <b>Step 4 </b> - Calculate all GST and Total amount and prepare data for subscription table
	 * <b>Step 5 </b> - Get payment details from Razor pay
	 * <b>Step 6 </b> - Call GST portal if the customer has GST number and insert into the local GST table
	 * <b>Step 7 </b> - Update subscription table to DB
	 * <b>Step 6 </b> - insert into SAP interface table
	 * 
	 * @param input Input parameters to renew the subscription
	 */
	public Subscription saveSubscription(SubscriptionParamsDTO input)  throws Exception;

	/**
	 * Method to fetch the subscription details based on the certificate number.
	 * 
	 * @param certificateNbr The certificate number for whihc the subscription to be
	 *                       fetched
	 * @return Subscription details
	 * @throws Exception Occurs when there is any issue in fetching the details
	 */
	public Subscription getSubscriptionByCertificateNbr(String certificateNbr) throws Exception;

	/**
	 * Method to fetch the certificate details to be printed based on the given
	 * certificate number
	 * 
	 * @param certificateNbr The certificate number for which the subscription
	 *                       details to be fetched
	 * @return The Subscription details
	 * @throws Exception Occurs when there is any exception while fetching the
	 *                   details
	 */
	public CertificateGenerationDTO getCertificateDTO(String certificateNbr) throws Exception;

	/**
	 * Method to fetch the invoice details to be printed based on the given
	 * certificate number
	 * 
	 * @param certificateNbr The certificate number for which the invoice details to
	 *                       be fetched
	 * @return The Subscription details
	 * @throws Exception Occurs when there is any exception while fetching the
	 *                   details
	 */
	public InvoiceGenerationDTO getInvoiceDTO(String certificateNbr) throws Exception;
	
	
 

}
