package com.nextlevel.codecamp.model.register;

import com.nextlevel.codecamp.model.user.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Register {
	
	private Long id;
	private String username;
	private String password;
	private UserRole userRole;
	private String name;
	private String favoriteToy;
	private String description;
	private boolean goodDog;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFavoriteToy() {
		return favoriteToy;
	}
	public void setFavoriteToy(String favoriteToy) {
		this.favoriteToy = favoriteToy;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isGoodDog() {
		return goodDog;
	}
	public void setGoodDog(boolean goodDog) {
		this.goodDog = goodDog;
	}

}
