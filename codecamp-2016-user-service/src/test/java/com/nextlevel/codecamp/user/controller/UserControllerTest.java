package com.nextlevel.codecamp.user.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nextlevel.codecamp.user.UserServiceMain;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=UserServiceMain.class)
@AutoConfigureMockMvc
public class UserControllerTest {

//	@Autowired
//	private MockMvc mvc;

	@Test
	public void getHello() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk())
//				.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}
}