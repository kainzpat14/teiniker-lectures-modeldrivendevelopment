package org.se.lab;

import org.junit.Test;
import org.se.lab.application.MemoryUserApi;
import org.se.lab.application.UserWrapper;

public class AspectJTest {
	@Test
	public void testCreateUser() {
		UserWrapper wrapper = new UserWrapper(new MemoryUserApi());
		wrapper.createUser("max", "password", "password");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPasswordMismatch() {
		UserWrapper wrapper = new UserWrapper(new MemoryUserApi());
		wrapper.createUser("max", "password", "mypassword");
	}
}
