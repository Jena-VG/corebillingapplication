package com.cba.api.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cba.api.exceptions.UnknownUserException;
import com.cba.api.repository.UsersRepository;
import com.cba.api.services.CoreBillingSecurityServices;
import com.cba.api.utils.JwtUtil;
import com.cba.entity.Users;

/**
 * {@link com.cba.api.services.CoreBillingSecurityServices}
 * 
 * @author raghavendharc
 */
@Service("coreBillingSecurityServices")
public class CoreBillingSecurityServicesImpl implements  CoreBillingSecurityServices, UserDetailsService   {


	@Autowired
    UsersRepository usersRepository;
	
	@Autowired
    JwtUtil jwtUtil;
	
	/**
	 * {@link com.cba.api.services.CoreBillingSecurityServices.getToken}
	 */
	@Override
	public String getToken(String clientId, String clientKey) throws UnknownUserException {
		List<Users> UserDetails = usersRepository.findByClientIdAndClientSecretKey(clientId, clientKey);
		String token = "";

		if (UserDetails.size() != 0) {

			String login = UserDetails.get(0).getLogin();
			token = jwtUtil.generateToken(login);
		} else {
			throw new UnknownUserException("User Unknown");
		}
		return token;
	}
	
	/**
	 * Overloaded method to fetch the user by login
	 */
	// @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> user = usersRepository.findById(1L);
		return new org.springframework.security.core.userdetails.User(user.get().getUserName(),
				user.get().getClientSecretKey(), new ArrayList<>());

	}
	

}
