package com.nextlevel.codecamp2016.registerService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nextlevel.codecamp.model.dog.Dog;
import com.nextlevel.codecamp.model.register.Register;
import com.nextlevel.codecamp.model.user.DogUser;
import com.nextlevel.codecamp.model.user.UserRole;

@RestController
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	// only testing
	@GetMapping("/registration")
	public String registrationGet(Model model) {
		model.addAttribute("register", new Register());
		return "registration";
	}

	@PostMapping("/registration")
	public String submitRegistration(@RequestBody Register register) {
		Dog dog = registerService.convertToDog(register);
		String addDog = registerService.addDog(dog);
		DogUser user = registerService.convertToUser(register);
		String addUser = registerService.addUser(user);
		return addDog + " <br> " + addUser;
	}

	// only testing
	@GetMapping("/test")
	public String test(Model model) {
		new TestSubmitRegistration().test();
		return "test executed";
	}

	// only testing
	@RequestMapping(value = "/getRegistrations", method = RequestMethod.GET)
	public List<Register> getRegistrations() {
		List<Register> list = new ArrayList<>();
		Register reg = new Register();
		reg.setId(1l);
		reg.setUsername("some_dog");
		reg.setPassword("test");
		reg.setUserRole(UserRole.USER);
		list.add(reg);
		return list;
	}
}
