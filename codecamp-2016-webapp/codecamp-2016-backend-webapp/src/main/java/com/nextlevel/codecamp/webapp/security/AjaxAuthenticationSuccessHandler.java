package com.nextlevel.codecamp.webapp.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.nextlevel.codecamp.model.user.DogUser;
import com.nextlevel.codecamp.model.user.UserRole;

/**
 * Spring Security success handler, specialized for Ajax requests.
 */
@Component
public class AjaxAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		User principal = (User) authentication.getPrincipal();
		Collection<GrantedAuthority> authorities = principal.getAuthorities();
		
		UserRole userRole = null;
		if (CollectionUtils.isNotEmpty(authorities)) {
			GrantedAuthority authority = new ArrayList<>(authorities).get(0);
			userRole = UserRole.valueOf(authority.getAuthority());
		}
		DogUser dogUser = new DogUser(principal.getUsername(), userRole);
		
		SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK, dogUser);
	}
}
