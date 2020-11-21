package org.se.lab.frontend;

import org.se.lab.frontend.dto.UserDTO;

public interface IUserWrapper {
	UserDTO register(String username, String password, String passwordVerification);

	UserDTO login(String username, String password);

	boolean isLoggedIn();
}
