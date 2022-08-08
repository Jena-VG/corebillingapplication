package com.cba.api.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Global Error Controller
 * 
 * @author Balaji Desikan
 *
 */
 
@Controller
public class CoreBillingErrorController implements ErrorController {
	
	 private final String ERROR_PATH = "/error";
	 
	 

	/**
	 * Error Handling method to white list errors.
	 * 
	 * @param request
	 * @return The template name to be shown for the given type of error
	 */
	@RequestMapping(ERROR_PATH)
	public String handleError(HttpServletRequest request, HttpServletResponse  response)  {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	    
	        if(statusCode == HttpStatus.NO_CONTENT.value()) {
	        	response.setStatus(401);
	            return "error_401";
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	        	response.setStatus(400);
	            return "error_401"; 
	        }
	        else  {
	        	response.setStatus(400);
	        }
	    }else {
	    	response.setStatus(400);
	    }
	    return "error";
	}
}
