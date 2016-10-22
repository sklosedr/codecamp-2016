package com.nextlevel.codecamp2016.registerService;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

@Service
@Primary
public class MockRestTemplateFactory implements IRestTemplateFactory {
	
	private static RestTemplate restTemplate;
	
	public RestTemplate getRestTemplate() {
		if (restTemplate == null) {
			restTemplate = new RestTemplate();
			MockRestServiceServer server = MockRestServiceServer.bindTo(restTemplate).build();
			mockDogs(server);
			mockUsers(server);
		}
		return restTemplate;
	}
	
	private void mockDogs(MockRestServiceServer server) {
		server.expect(requestTo("http://localhost:8084/dogs"))
				.andRespond(withSuccess("{ }", MediaType.APPLICATION_JSON));
	}

	private void mockUsers(MockRestServiceServer server) {
		server.expect(requestTo("http://localhost:8083/addUser"))
				.andRespond(withSuccess("{ }", MediaType.APPLICATION_JSON));
	}

}
