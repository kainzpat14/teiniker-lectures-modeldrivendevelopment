package org.se.lab.frontend;

import org.se.lab.business.model.User;

public interface ISession {
	void setUser(User user);

	User getUser();
}
