package com.nextlevel.codecamp2016.registerService.controller;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

import com.google.inject.Inject;
import com.nextlevel.codecamp.model.register.Register;
import com.nextlevel.codecamp2016.registerService.client.DogClient;
import com.nextlevel.codecamp2016.registerService.client.UserClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RegisterControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	private DogClient dogClient;
	
	@Inject 
	private DogMockup dogMockup;

	private UserClient userClient;
	
	@Inject
	private UserMockup userMockup;

    @Before
    public void setUp(){
//       this.dogClient = new DogClient(dogMockup);
//       this.dogClient = new UserClient(userMockup);
    }
    
    @Ignore
	@Test
	public void testRegistrationCall() throws RestClientException, URISyntaxException {
		Register register = new Register();
		String response = restTemplate.postForObject("/registration", register, String.class);
		assertEquals("Saved Dog with Id=null <br> Saved User with Id=null", response);
	}



}
