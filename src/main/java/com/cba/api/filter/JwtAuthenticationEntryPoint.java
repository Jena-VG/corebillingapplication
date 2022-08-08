package com.cba.api.filter;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.cba.api.exceptions.UnAuthorizedException;


/**
 * 
 * Entry point to validate Authentication for the API's
 * 
 * @author Raghavendhra C
 *
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    private static final long serialVersionUID = -7858869558953243875L;
    private final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);
    @Autowired
	@Qualifier("handlerExceptionResolver")
	private HandlerExceptionResolver resolver;
    
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
    	LOGGER.info(" Calling Enrty Point");
        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    	resolver.resolveException(request, response, null, new UnAuthorizedException(" Unauthorized Access"));
    }
}