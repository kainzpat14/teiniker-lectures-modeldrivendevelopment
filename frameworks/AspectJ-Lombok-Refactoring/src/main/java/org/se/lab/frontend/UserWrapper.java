package org.se.lab.frontend;

import org.se.lab.business.model.User;
import org.se.lab.business.rules.IUserService;
import org.se.lab.frontend.dto.UserDTO;

import lombok.NonNull;

public class UserWrapper implements IUserWrapper {

	private ISession session;
	private IUserService userService;

	public UserWrapper(ISession session, IUserService userService) {
		this.session = session;
		this.userService = userService;
	}

	@Override
	public UserDTO register(@NonNull String username, @NonNull String password, @NonNull String passwordVerification) {
		if (!password.contentEquals(passwordVerification)) {
			throw new IllegalArgumentException("Passwords do not match");
		}
		User user = userService.register(username, password);
		return new UserDTO(user.getUsername());
	}

	@Override
	public UserDTO login(@NonNull String username, @NonNull String password) {
		User user = userService.login(username, password);
		if (user == null) {
			return null;
		}
		session.setUser(user);
		return new UserDTO(user.getUsername());
	}

	@Override
	public boolean isLoggedIn() {
		return session.getUser() != null;
	}

}
