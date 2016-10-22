package com.nextlevel.codecamp.webapp.register.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nextlevel.codecamp.model.register.Register;
import com.nextlevel.codecamp.webapp.register.service.RegisterService;

@RestController
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path = "/register", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> register(@RequestBody Register register, HttpServletResponse response) {
		try {
			return registerService.register(register);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(convertExceptionMessageToJson(e));
		}
	}

	private String convertExceptionMessageToJson(Exception e) {
		String message = "";
		if (e != null && e.getMessage() != null) {
			message = e.getMessage();
		}
		return "{\"error\":\"" + message.replaceAll("\"", "'") + "\"}";
	}

}
