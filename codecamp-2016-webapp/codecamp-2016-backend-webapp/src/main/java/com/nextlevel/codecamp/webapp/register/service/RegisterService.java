package com.nextlevel.codecamp.webapp.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nextlevel.codecamp.model.register.Register;
import com.nextlevel.codecamp.webapp.register.client.RegisterClient;

@Service
public class RegisterService {

	@Autowired
	private RegisterClient registerClient;

	public ResponseEntity<String> register(Register register) {
		return registerClient.register(register);
	}

}
