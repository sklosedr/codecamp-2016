package com.nextlevel.codecamp.user.controller;

import org.springframework.web.bind.annotation.RestController;

import com.nextlevel.codecamp.model.user.DogUser;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicToolBarUI.DockingListener;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

	@RestController
	public class UserController {
		private List<DogUser> allUsers = new ArrayList<DogUser>();
	    @RequestMapping("/")
	    public String index() {
	        return "Greetings from Spring Boot!";
	    }
	    
	    @RequestMapping("/users")
	    public List<DogUser> getAllUsers() {
	    	
	    	return allUsers;
	    }
	    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
	    public DogUser post(@RequestBody DogUser dogUser){
	    	allUsers.add(dogUser);
	    	return dogUser;
	    }
	}
