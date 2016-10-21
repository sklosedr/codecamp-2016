package com.nextlevel.codecamp2016.registerService;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.nextlevel.codecamp.model.register.Register;

public class TestSubmitRegistration {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public void test() {
		RestTemplate restTemplate = new RestTemplate();
		Register register = mockRegister();
		try {
			String response = restTemplate.postForObject(new URI("http://localhost:8082/registration"), register,
					String.class);
			logger.info(response);
		} catch (RestClientException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	private static Register mockRegister() {
		Register register = new Register();
		register.setId(1L);
		register.setUsername("luna");
		register.setName("Luna");
		register.setPassword("password");
		// register.setUserRole(userRole);
		register.setDescription("Gewinnt jeden Bellkampf.");
		register.setGoodDog(true);
		register.setFavoriteToy("Beissknaeul");
		return register;
	}
}
