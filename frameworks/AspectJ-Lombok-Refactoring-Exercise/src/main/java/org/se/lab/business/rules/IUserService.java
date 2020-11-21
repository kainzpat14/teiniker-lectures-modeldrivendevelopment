package org.se.lab.business.rules;

import org.se.lab.business.model.User;

public interface IUserService {
	User register(String username, String password);

	User login(String username, String password);

}
