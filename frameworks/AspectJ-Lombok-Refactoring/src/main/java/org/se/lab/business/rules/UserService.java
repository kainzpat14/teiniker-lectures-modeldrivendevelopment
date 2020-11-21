package org.se.lab.business.rules;

import org.se.lab.business.model.User;
import org.se.lab.business.persistence.IUserDao;

public class UserService implements IUserService {

	private IUserDao dao;

	public UserService(IUserDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public User register(String username, String password) {
		return dao.createUser(username, password);
	}

	@Override
	public User login(String username, String password) {
		User user = dao.getUserByUsername(username);
		boolean success = user != null && user.getPassword().contentEquals(password);
		return success ? user : null;
	}

}
