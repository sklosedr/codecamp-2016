package com.nextlevel.codecamp2016.registerService.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nextlevel.codecamp.model.dog.Dog;
import com.nextlevel.codecamp.model.register.Register;
import com.nextlevel.codecamp.model.user.DogUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RegisterServiceTest {

	@Autowired
	private RegisterService registerService;

	@Test
	public void testAddDog() {
		Dog dog = new Dog();
		String response = registerService.addDog(dog);
		assertThat(response, startsWith("Saved Dog"));
	}

	@Test
	public void testAddUser() {
		DogUser user = new DogUser();
		String response = registerService.addUser(user);
		assertThat(response, startsWith("Saved DogUser"));
	}

	@Test
	public void testconvertToDog() {
		Register reg = testRegister();
		Dog dog = registerService.convertToDog(reg);
		assertThat(dog.getName(), is("Luna"));
		// TODO
	}

	@Test
	public void testconvertToUser() {
		Register reg = testRegister();
		DogUser user = registerService.convertToUser(reg);
		assertThat(user.getUsername(), is("luna"));
		// TODO
	}

	private static Register testRegister() {
		Register register = new Register();
		// register.setId(null);
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
