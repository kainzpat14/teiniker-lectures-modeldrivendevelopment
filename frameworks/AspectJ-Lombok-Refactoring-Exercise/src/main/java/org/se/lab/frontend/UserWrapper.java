package org.se.lab.frontend;

import org.se.lab.business.model.User;
import org.se.lab.business.rules.IUserService;
import org.se.lab.frontend.dto.UserDTO;

public class UserWrapper implements IUserWrapper {

	private ISession session;
	private IUserService userService;

	public UserWrapper(ISession session, IUserService userService) {
		this.session = session;
		this.userService = userService;
	}

	@Override
	public UserDTO register(String username, String password, String passwordVerification) {
		String method = "register(" + username + "," + password + "," + passwordVerification + ")";
		System.out.println(method + " started");
		try {
			if (username == null) {
				throw new IllegalArgumentException("Username must not be null");
			}
			if (password == null) {
				throw new IllegalArgumentException("Password must not be null");
			}
			if (passwordVerification == null) {
				throw new IllegalArgumentException("PasswordVerification must not be null");
			}
			if (!password.contentEquals(passwordVerification)) {
				throw new IllegalArgumentException("Passwords do not match");
			}
			User user = userService.register(username, password);
			UserDTO dto = new UserDTO(user.getUsername());
			System.out.println(method + " resulted in " + dto);
			return dto;
		} catch (Throwable t) {
			System.out.println(method + " failed with ");
			t.printStackTrace();
			throw new IllegalArgumentException(t.getMessage());
		}
	}

	@Override
	public UserDTO login(String username, String password) {
		String method = "login(" + username + "," + password + ")";
		System.out.println(method + " started");
		try {
			if (username == null) {
				throw new IllegalArgumentException("Username must not be null");
			}
			if (password == null) {
				throw new IllegalArgumentException("Password must not be null");
			}

			User user = userService.login(username, password);
			if (user == null) {
				return null;
			}
			session.setUser(user);
			UserDTO dto = new UserDTO(user.getUsername());
			System.out.println(method + " resulted in " + dto);
			return dto;
		} catch (Throwable t) {
			System.out.println(method + " failed with ");
			t.printStackTrace();
			throw new IllegalArgumentException(t.getMessage());
		}
	}

	@Override
	public boolean isLoggedIn() {
		String method = "isLoggedIn()";
		System.out.println(method + " started");
		try {
			boolean loggedIn = session.getUser() != null;
			System.out.println(method + " resulted in " + loggedIn);
			return loggedIn;
		} catch (Throwable t) {
			System.out.println(method + " failed with ");
			t.printStackTrace();
			throw new IllegalArgumentException(t.getMessage());
		}
	}

}
