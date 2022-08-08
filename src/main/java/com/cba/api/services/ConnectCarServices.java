package com.cba.api.services;

import org.springframework.http.ResponseEntity;

/**
 * Service to integrate the ccs API calls
 *
 * @author manikandan.rajendran
 * @version 1.0
 * @since 2022-06-17
 */

public interface ConnectCarServices {

	/**
	 * Service method to integrate CCS API for validating the VIN Number
	 * 
	 * @param vinNum - The VIN number that needs to be checked if it is enabled with
	 *               CC subscription
	 * @return Response received from the CCS API
	 */
	ResponseEntity<String> validateVINNumber(String vinNum) throws Exception;

	/**
	 * Service method to update the renewed subscription date to the CCS System
	 * 
	 * @param vinNum   The VIN number for which the subscription end date to be
	 *                 updated
	 * @param duartion - Duration to update
	 * @return - String response of the API calls
	 */
	String updateSubscriptionDate(String vinNum, int duartion) throws Exception;
}
