package com.nextlevel.codecamp2016.registerService.controller;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.nextlevel.codecamp.model.register.Register;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class RegisterControllerTest {
	
	@Autowired
	RegisterController registerController;

	@Test
	public void testRegistrationCall() throws RestClientException, URISyntaxException {
		Register register = new Register();
		ResponseEntity<String> response = registerController.submitRegistration(register);
		Object actual = new JSONObject(response.getBody()).get("response");
		assertEquals("Saved Dog with Id=0 <br> Saved DogUser with Id=0", actual);
	}



}
