package com.nextlevel.codecamp.webapp.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * Spring Security success handler, specialized for Ajax requests.
 */
@Component
public class AjaxAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
        //response.setStatus(HttpServletResponse.SC_OK);
        // This is actually not an error, but an OK message. It is sent to avoid redirects.
        //response.sendError(HttpServletResponse.SC_OK);
		SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK, authentication.getPrincipal());
	}
}
