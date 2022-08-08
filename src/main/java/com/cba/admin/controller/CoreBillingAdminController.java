package com.cba.admin.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cba.api.dto.PackageTypeDTO;
import com.cba.api.dto.UserDTO;
import com.cba.api.exceptions.PackageCodeNotFound;
import com.cba.api.exceptions.UnknownUserException;
import com.cba.api.services.CoreBillingAdminService;
import com.cba.entity.PackageType;
import com.cba.entity.Subscription;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/corebilling/admin")
@RestController
public class CoreBillingAdminController {

	/*
	 * Autowired Service for Core billing related functions
	 */
	@Autowired
	CoreBillingAdminService coreBillingAdminServices;

	private final Logger LOGGER = LoggerFactory.getLogger(CoreBillingAdminController.class);

	/**
	 * This method is used for login validation
	 * 
	 * @param userDto - DTO is used for get request body values of login info
	 * @return - It returns whether the user is authenticate or not
	 * @throws UnknownUserException - If there are any errors occurred in
	 *                              authenticate user
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/authenticate")
	public ResponseEntity<String> authenticate(@Valid @RequestBody UserDTO userDto) {
		try {
			String status = coreBillingAdminServices.authenticate(userDto);
			return ResponseEntity.status(HttpStatus.OK).body(status);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" Invalid User");
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
		return (coreBillingAdminServices.fetchPackages());
	}

	

	/**
	 * This method is used for create and add the packages
	 * 
	 * @param packageTypeDTO - DTO is used for get request body values of add
	 *                       packages
	 * @return - It return responses code and status
	 * @throws Exception - If there are any errors occurred in add packages
	 */
	@RequestMapping(value = "/addpackagetype", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addPackageType(@Valid @RequestBody PackageTypeDTO packageTypeDTO) {
		try {
			String status = coreBillingAdminServices.addPackageType(packageTypeDTO);
			return ResponseEntity.status(HttpStatus.OK).body(status);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Exception in add New Subscription Package" + e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
		}
	}

	/**
	 * This method is used for edit and update the packages
	 * 
	 * @param packageTypeDTO - DTO is used for get request body values of edit
	 *                       packages
	 * @return - It return responses code and status
	 * @throws Exception - If there are any errors occurred in edit packages
	 */
	@RequestMapping(value = "/editpackagetype", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> editPackageType(@Valid @RequestBody PackageTypeDTO packageTypeDTO){
		LOGGER.info("into editSubscriptionPackage:" + packageTypeDTO);
		String status = null;
		try {

			status = coreBillingAdminServices.editPackageType(packageTypeDTO);
			return ResponseEntity.status(HttpStatus.OK).body(status);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Exception in Edit Subscription Package" + e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
		}

	}

	
	/**
	 * This method is used for fetch the list of subscriptions
	 * 
	 * @param subscriptionDTO parameter for list out the conditions
	 * @return list of subscriptions
	 * @throws Exception - If there are any errors occurred in get subscriptions
	 */
	@GetMapping(value = "/getallsubscriptions")
	public List<Subscription> listAllSubscriptions() throws Exception {
		return (coreBillingAdminServices.listAllSubscriptions());
	}
}
