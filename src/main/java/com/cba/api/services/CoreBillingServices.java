package com.cba.api.services;

import java.util.List;

import com.cba.api.dto.CustomerDealerDTO;
import com.cba.api.dto.GSTParamsDTO;
import com.cba.entity.PackageType;

/**
 * API list for DMS to call
 *
 * @author manikandan.rajendran
 * @version 1.0
 * @since 2022-06-17
 */

public interface CoreBillingServices {

	/**
	 * This method will be called from DMS once the Subscription renewal is
	 * completed to push the data to core billing and update the same
	 * 
	 * @param customerDealerdto
	 * @return
	 * @throws Exception
	 */
	public String save(CustomerDealerDTO customerDealerdto) throws Exception;

	/**
	 * This method is used to list all active packages configured in core billing
	 * system
	 * 
	 * @return List of active packages
	 */
	public List<PackageType> listAllPackages();

	/**
	 * This method is used to update the IRN number and QR Code generated from GST
	 * portal for the customers who have a registered QR Code
	 * 
	 * @param gstParamDTO
	 */
	public void updateIRNandQRCode(GSTParamsDTO gstParamDTO);
	
	
}
