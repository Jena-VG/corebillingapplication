package com.cba.api.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.cba.api.constants.CoreBillingConstants;
import com.cba.api.services.impl.CoreBillingSecurityServicesImpl;
import com.cba.api.utils.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * Filter to be called for each request, to validate and authenticate the
 * services
 * 
 * @author Sateesh K
 *
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	@Autowired
	private CoreBillingSecurityServicesImpl jwtUserDetailsService;
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	@Qualifier("handlerExceptionResolver")
	private HandlerExceptionResolver resolver;

	private final Logger LOGGER = LoggerFactory.getLogger(JwtRequestFilter.class);
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		String jwtToken = null;

		String header = request.getHeader(CoreBillingConstants.HEADER_AUTH);
		 
		if (header == null || !header.startsWith(CoreBillingConstants.HEADER_BEARER)) {
			LOGGER.info(" Inside IF condition for no Bearer");
			chain.doFilter(request, response);

		} else {
			
			try {
				LOGGER.info("Else part ");
				jwtToken = header.substring(7);
				UsernamePasswordAuthenticationToken authentication = getAuthentication(request, jwtToken);
				SecurityContextHolder.getContext().setAuthentication(authentication);
				chain.doFilter(request, response);
			} catch (ExpiredJwtException exception) {
				exception.printStackTrace();
				resolver.resolveException(request, response, null, exception);
			}catch(Exception exc)
			{
				exc.printStackTrace();
				resolver.resolveException(request, response, null, exc);
			}
		}

	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request, String jwtToken) {
		String token = request.getHeader(CoreBillingConstants.HEADER_AUTH);
		if (token != null) {

			token = token.replace(CoreBillingConstants.HEADER_BEARER, "");
			LOGGER.info(" Token gfot" + token);
			String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
				// if token is valid configure Spring Security to manually set
				// authentication
				LOGGER.info(" Before valid token");
				if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
					LOGGER.info( "Valid token");
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					return usernamePasswordAuthenticationToken;
				}

				return null;
			}
		}

		return null;

	}
}