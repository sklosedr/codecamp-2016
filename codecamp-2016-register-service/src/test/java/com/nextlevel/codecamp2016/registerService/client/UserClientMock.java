package com.nextlevel.codecamp2016.registerService.client;

import com.nextlevel.codecamp.model.user.DogUser;

public class UserClientMock implements UserClient {

	@Override
	public DogUser addUser(DogUser user) {
		user.setId(0L);
		return user;
	}

}
