package com.nextlevel.codecamp.webapp.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SecurityUtils {
	private static final ObjectMapper mapper = new ObjectMapper();

	private SecurityUtils() {
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
