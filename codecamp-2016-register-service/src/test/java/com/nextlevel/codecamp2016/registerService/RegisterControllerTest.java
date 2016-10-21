package com.nextlevel.codecamp2016.registerService;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.nextlevel.codecamp.model.register.Register;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class RegisterControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Before
	public void mockDogsAndUsers() {
		RestTemplate restTemplate = RegisterController.restTemplate;
		MockRestServiceServer server = MockRestServiceServer.bindTo(restTemplate).build();
		mockDogs(server);
		mockUsers(server);
	}

	private void mockDogs(MockRestServiceServer server) {
		server.expect(ExpectedCount.manyTimes(), requestTo("http://localhost:8084/dogs"))
		 .andRespond(withSuccess("{ }", MediaType.APPLICATION_JSON));
	}
	
	private void mockUsers(MockRestServiceServer server) {
		server.expect(ExpectedCount.manyTimes(), requestTo("http://localhost:8083/users"))
		 .andRespond(withSuccess("{ }", MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void testRegistrationCall() throws RestClientException, URISyntaxException {
        Register register = new Register();
        String response = restTemplate.postForObject("/registration", register, String.class);
        assertEquals("success", response);
	}

}
