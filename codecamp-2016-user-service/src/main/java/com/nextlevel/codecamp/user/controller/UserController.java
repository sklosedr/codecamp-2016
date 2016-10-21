package com.nextlevel.codecamp.user.controller;

import org.springframework.web.bind.annotation.RestController;

import com.nextlevel.codecamp.model.user.DogUser;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicToolBarUI.DockingListener;

import org.springframework.web.bind.annotation.RequestMapping;

	@RestController
	public class UserController {

	    @RequestMapping("/")
	    public String index() {
	        return "Greetings from Spring Boot!";
	    }
	    
	    @RequestMapping("/users")
	    public List<DogUser> getAllUsers() {
	    	DogUser user1 = new DogUser();
	    	user1.setUsername("Eugen");
	    	return new ArrayList<DogUser>();
	    }

	}
