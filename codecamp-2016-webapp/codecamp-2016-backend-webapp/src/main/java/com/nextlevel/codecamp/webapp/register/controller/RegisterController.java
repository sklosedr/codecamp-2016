package com.nextlevel.codecamp.webapp.register.controller;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nextlevel.codecamp.model.register.Register;
import com.nextlevel.codecamp.webapp.register.service.RegisterService;

@RestController
public class RegisterController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private RegisterService registerService;

	@PostMapping(path = "/api/register", produces = "application/json")
	public ResponseEntity<String> register(@RequestBody Register register, HttpServletResponse response) {
		try {
			return registerService.register(register);
		} catch (RuntimeException e) {
			LOGGER.error("Exception during registering: ",  e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(convertExceptionMessageToJson(e));
		}
	}

	private String convertExceptionMessageToJson(Exception e) {
		return new JSONObject().put("error", e.getMessage()).toString();
	}

}