package com.nextlevel.codecamp.webapp.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nextlevel.codecamp.model.register.Register;
import com.nextlevel.codecamp.webapp.register.client.RegisterClient;

@Service
public class RegisterService {

	@Autowired
	private RegisterClient registerClient;

	public String register(Register register) {
		try {
			ResponseEntity<String> response = registerClient.register(register);
			System.out.println(response.toString());
			// TODO check return value
			return HttpStatus.CREATED.toString();
		} catch (RuntimeException e) {
			// TODO log
			return HttpStatus.INTERNAL_SERVER_ERROR.toString();
		}
	}

}
