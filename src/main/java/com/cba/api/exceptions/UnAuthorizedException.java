package com.cba.api.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Exception to catch UnAuthorized access to  the API.
 *
 * @author Satheesh K
 * @version 1.0
 * @since 2022-06-17
 */

@ControllerAdvice
public class UnAuthorizedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnAuthorizedException() {
		super();
	}

	public UnAuthorizedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnAuthorizedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnAuthorizedException(String message) {
		super(message);
	}

	public UnAuthorizedException(Throwable cause) {
		super(cause);
	}

}