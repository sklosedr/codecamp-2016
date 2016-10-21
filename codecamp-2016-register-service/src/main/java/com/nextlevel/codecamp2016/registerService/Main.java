package com.nextlevel.codecamp2016.registerService;


import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.nextlevel.codecamp.model.dog.Dog;
import com.nextlevel.codecamp.model.register.Register;

@SpringBootApplication
public class Main {
	
	public static void main(String[] args) throws RestClientException, URISyntaxException {
		SpringApplication.run(Main.class, args);
		
        RestTemplate restTemplate = new RestTemplate();
        Register register = mockRegister();
        String response = restTemplate.postForObject(new URI("http://localhost:8080/registration"), register, String.class);
        System.out.println(response);
	}
	
	private static Dog mockDog() {
		return null; // TODO
	}

	private static Register mockRegister() {
		Register register = new Register();
		register.setId(1L);
		register.setUsername("luna");
		register.setName("Luna");
		register.setPassword("password");
		//register.setUserRole(userRole);
		register.setDescription("Gewinnt jeden Bellkampf.");
		register.setGoodDog(true);
		register.setFavoriteToy("Beissknaeul");
		return register;
	}

}
