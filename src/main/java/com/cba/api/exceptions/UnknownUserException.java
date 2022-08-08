package com.cba.api.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Exception to catch unknow user accessing the API.
 *
 * @author Satheesh K
 * @version 1.0
 * @since 2022-06-17
 */

@ControllerAdvice
public class UnknownUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnknownUserException() {
		super();
	}

	public UnknownUserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnknownUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownUserException(String message) {
		super(message);
	}

	public UnknownUserException(Throwable cause) {
		super(cause);
	}

}