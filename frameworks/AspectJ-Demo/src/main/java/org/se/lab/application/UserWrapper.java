package org.se.lab.application;

import org.se.lab.concerns.Wrapper;

@Wrapper
public class UserWrapper {
	private IUserApi api;

	public UserWrapper(IUserApi api) {
		this.api = api;
	}

	public UserDTO createUser(String username, String password, String passwordVerification) {
		if (!password.contentEquals(passwordVerification)) {
			throw new IllegalArgumentException("Passwords do not match");
		}
		return new UserDTO(api.createUser(username, password));
	}

}
