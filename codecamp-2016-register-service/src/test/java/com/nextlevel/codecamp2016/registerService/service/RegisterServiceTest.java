package com.nextlevel.codecamp2016.registerService.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nextlevel.codecamp.model.dog.Dog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RegisterServiceTest {

	@Autowired
	private RegisterService registerService;

	@Test
	public void testAddDog() {
		Dog dog = new Dog();
		String response = registerService.addDog(dog);
		assertThat(response, is(""));
	}

}
