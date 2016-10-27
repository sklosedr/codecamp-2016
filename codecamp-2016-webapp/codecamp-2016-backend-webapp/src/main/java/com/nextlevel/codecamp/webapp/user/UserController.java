package com.nextlevel.codecamp.webapp.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextlevel.codecamp.model.user.DogUser;
import com.nextlevel.codecamp.webapp.security.SecurityUtils;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping
	public DogUser getUser() {
		return SecurityUtils.getCurrentUser();
	}

}
