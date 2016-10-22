package com.nextlevel.codecamp.webapp.security;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class JsonUserNameAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String body = null;
		try {
			body = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
			Map<String, Object> parseMap = new JacksonJsonParser().parseMap(body);
			String username = StringUtils.defaultIfEmpty((String) parseMap.get("username"), "");
			String password = StringUtils.defaultIfEmpty((String) parseMap.get("password"), "");
			return this.getAuthenticationManager()
					.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (JsonParseException | JsonMappingException ex) {
			throw new BadCredentialsException("Cannot parse following body: " + body, ex);
		} catch (IOException ex) {
			throw new InternalAuthenticationServiceException("Cannot read request body", ex);
		}
	}
}
