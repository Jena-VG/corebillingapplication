package com.cba.api.services;

import com.cba.api.exceptions.UnknownUserException;

/**
 * Service class to implement security for the API calls
 * 
 * @author raghavendharc
 *
 */
public interface CoreBillingSecurityServices {

	/**
	 * Service method to generate and get token for authorization of the API Calls.
	 * 
	 * @param clientId  - Holds the client id shared to the calling program
	 * @param clientKey - Holds the client key shared to the calling program
	 * @return generated Token
	 */
	String getToken(String clientId, String clientKey) throws UnknownUserException;

}
