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
		long start = System.currentTimeMillis();
		User user = dao.createUser(username, password);
		System.out.println("register() took " + (System.currentTimeMillis() - start) + "ms");
		return user;
	}

	@Override
	public User login(String username, String password) {
		long start = System.currentTimeMillis();
		User user = dao.getUserByUsername(username);
		boolean success = user != null && user.getPassword().contentEquals(password);
		System.out.println("login() took " + (System.currentTimeMillis() - start) + "ms");
		return success ? user : null;
	}

}
