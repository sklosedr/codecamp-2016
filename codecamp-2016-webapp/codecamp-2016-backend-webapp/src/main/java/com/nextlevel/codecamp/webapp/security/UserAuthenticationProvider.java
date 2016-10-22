package com.nextlevel.codecamp.webapp.security;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.nextlevel.codecamp.model.user.DogUser;
import com.nextlevel.codecamp.webapp.user.client.UserClient;

@Component("userAuthenticationProvider")
public class UserAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	private final Logger log = LoggerFactory.getLogger(UserAuthenticationProvider.class);

	@Inject
	private UserClient userClient;
	
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		log.debug("Authenticating {}", username);
		String lowercaseLogin = username.toLowerCase(Locale.ENGLISH);
		
		DogUser user = userClient.findOneByLogin(lowercaseLogin, authentication.getCredentials().toString());
		if(user != null) {
			List<GrantedAuthority> grantedAuthorities = Arrays
					.asList(new SimpleGrantedAuthority(user.getUserRole().toString()));
			return new User(lowercaseLogin, user.getPassword(), grantedAuthorities);
		} else {
			UsernameNotFoundException ex = new UsernameNotFoundException("User " + lowercaseLogin + " was not found");
			log.warn("Authenticating failed: {}", ex.getMessage());
			throw ex;
		}
	}

	@Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
	}
}
