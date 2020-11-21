package org.se.lab.persistence;

import java.util.ArrayList;
import java.util.List;

import org.se.lab.business.model.User;
import org.se.lab.business.persistence.IUserDao;

public class MemoryUserDao implements IUserDao {
	private List<User> users = new ArrayList<>();

	@Override
	public User createUser(String username, String password) {
		validateUserNotExists(username);
		User user = new User(username, password);
		users.add(user);
		return user;
	}

	private void validateUserNotExists(String username) {
		if (users.stream().anyMatch(user -> user.getUsername().contentEquals(username))) {
			throw new IllegalArgumentException("User with name " + username + " already exists");
		}
	}

	@Override
	public User getUserByUsername(String username) {
		return users.stream().filter(user -> user.getUsername().contentEquals(username)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("User with name " + username + " does not exist"));
	}

}
