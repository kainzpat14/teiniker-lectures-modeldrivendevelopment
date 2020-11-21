package org.se.lab.application;

import java.util.ArrayList;
import java.util.List;

import org.se.lab.concerns.API;

@API
public class MemoryUserApi implements IUserApi {

	private List<User> users = new ArrayList<>();

	@Override
	public User createUser(String username, String password) {
		User user = new User(username, password);
		users.add(user);
		return user;
	}

}
