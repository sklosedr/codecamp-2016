package com.nextlevel.codecamp.webapp.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nextlevel.codecamp.model.user.DogUser;
import com.nextlevel.codecamp.model.user.UserRole;

public class SecurityUtils {
	private static final ObjectMapper mapper = new ObjectMapper();

	private SecurityUtils() {
	}

	public static DogUser getCurrentUser() {
		return getCurrentUser(SecurityContextHolder.getContext().getAuthentication());
	}

	public static DogUser getCurrentUser(Authentication authentication) {
		if (authentication == null) {
			return null;
		}

		UserDetails principal = (UserDetails) authentication.getPrincipal();
		Collection<? extends GrantedAuthority> authorities = principal.getAuthorities();

		UserRole userRole = null;
		if (CollectionUtils.isNotEmpty(authorities)) {
			GrantedAuthority authority = new ArrayList<>(authorities).get(0);
			userRole = UserRole.valueOf(authority.getAuthority());
		}

		return new DogUser(principal.getUsername(), userRole);
	}

	public static void sendResponse(HttpServletResponse response, int status, Object object) throws IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(mapper.writeValueAsString(object));
		response.setStatus(status);
		writer.flush();
		writer.close();
	}
}