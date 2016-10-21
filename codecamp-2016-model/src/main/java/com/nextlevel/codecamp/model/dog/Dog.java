package com.nextlevel.codecamp.model.dog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dog {
	
	@Id
	@GeneratedValue
	private Long id;
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
