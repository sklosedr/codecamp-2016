package com.nextlevel.codecamp2016.registerService.controller;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

import com.nextlevel.codecamp.model.register.Register;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class RegisterControllerTest {

	@Ignore
	@Test
	public void testRegistrationCall() throws RestClientException, URISyntaxException {
		Register register = new Register();
		ResponseEntity<String> response = new RegisterController().submitRegistration(register);
		assertEquals("Saved Dog with Id=null <br> Saved User with Id=null", response.getBody());
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}



}
