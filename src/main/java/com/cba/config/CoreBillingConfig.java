package com.cba.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

/**
* Configuration class
*
* @author  manikandan.rajendran
* @version 1.0
* @since   2022-06-17 
*/
@Configuration
public class CoreBillingConfig implements WebApplicationInitializer{

	
	@Value("${spring.profiles.active}")
	private String name;
	
	 
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("spring.profiles.active", "dev");		
	}
	

}

