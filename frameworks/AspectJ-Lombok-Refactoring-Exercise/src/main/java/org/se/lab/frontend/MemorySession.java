package org.se.lab.frontend;

import org.se.lab.business.model.User;

public class MemorySession implements ISession {

	private User user;

	@Override
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getUser() {
		return user;
	}

}
