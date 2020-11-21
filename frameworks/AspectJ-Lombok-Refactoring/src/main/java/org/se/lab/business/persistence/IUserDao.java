package org.se.lab.business.persistence;

import org.se.lab.business.model.User;

public interface IUserDao {
	User createUser(String username, String password);

	User getUserByUsername(String username);
}
