// This file has been generated automatically at Sat Jan 24 11:06:31 CET 2026
// Don't modify it manually!

package org.se.lab;

import javax.persistence.EntityManager;

abstract class UserDAOImplBase
	extends DAOImplTemplate<User>
	implements UserDAO
{
	public UserDAOImplBase(EntityManager em)
	{
		super(em);
	}

	@Override
	protected Class<User> getEntityClass()
	{
		return User.class;
	}

	@Override
	public User createUser(String firstname,String lastname,String username,String password)
	{
		User e = new User();
		e.setFirstname(firstname);
		e.setLastname(lastname);
		e.setUsername(username);
		e.setPassword(password);
		insert(e);
		return e;
	}
}
