package com.cba.api.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * Exception Translator to translate the exception status to proper exception
 * message and appropriate Status code.
 * 
 * @author Balaji Desikan
 *
 */
@RestControllerAdvice
public class CoreBillingAPIExceptionTranslator {

	/**
	 * Handler method to translate the token expired exception to appropriate error
	 * status code.
	 * 
	 * @param ex      Exception object
	 * @param request - Refer
	 *                {@link org.springframework.web.context.request.WebRequest}
	 * @return Translated Response Entity
	 */
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(ExpiredJwtException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public final ResponseEntity<Map> handleTokenExpiredError(Exception ex, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.UNAUTHORIZED; // 401
		Map<String, Object> data = new HashMap<>();
		data.put("timestamp", new Date());
		data.put("code", httpStatus.value());
		data.put("status", httpStatus.name());
		data.put("message", "Invalid Token, Token Expired");

		return new ResponseEntity<Map>(data, httpStatus);
	}

	/**
	 * Handler method to translate the UnAuthorized access exception to appropriate
	 * error status code.
	 * 
	 * @param ex      Exception object
	 * @param request - Refer
	 *                {@link org.springframework.web.context.request.WebRequest}
	 * @return Translated Response Entity
	 */
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(UnAuthorizedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public final ResponseEntity<Map> handleUnAuthorizedError(Exception ex, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.UNAUTHORIZED; // 401
		System.out.println("Calling");
		Map<String, Object> data = new HashMap<>();
		data.put("timestamp", new Date());
		data.put("code", httpStatus.value());
		data.put("status", httpStatus.name());
		data.put("message", "Access Restricted, UnAuthorized Access");

		return new ResponseEntity<Map>(data, httpStatus);
	}

	/**
	 * Handler method to translate generic exception to appropriate error status
	 * code.
	 * 
	 * @param ex      Exception object
	 * @param request - Refer
	 *                {@link org.springframework.web.context.request.WebRequest}
	 * @return Translated Response Entity
	 */
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public final ResponseEntity<Map> handleGeneralError(Exception ex, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST; // 400
		System.out.println("Calling");
		Map<String, Object> data = new HashMap<>();
		data.put("timestamp", new Date());
		data.put("code", httpStatus.value());
		data.put("status", httpStatus.name());
		data.put("message", "Unknown Error, Please try after sometime");
		ex.printStackTrace();
		return new ResponseEntity<Map>(data, httpStatus);
	}
	
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(Error.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public final ResponseEntity<Map> handleNotFoundError(Exception ex, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST; // 400
		System.out.println("Calling");
		Map<String, Object> data = new HashMap<>();
		data.put("timestamp", new Date());
		data.put("code", httpStatus.value());
		data.put("status", httpStatus.name());
		data.put("message", "Unknown Error, Please try after sometime");
		ex.printStackTrace();
		return new ResponseEntity<Map>(data, httpStatus);
	}
}
