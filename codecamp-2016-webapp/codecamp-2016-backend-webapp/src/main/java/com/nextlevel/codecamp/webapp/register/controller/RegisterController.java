package com.nextlevel.codecamp.webapp.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Register register(@RequestBody Register register) {
		return registerService.register(register);
	}

}
