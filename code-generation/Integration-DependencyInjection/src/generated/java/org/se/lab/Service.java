package org.se.lab;

import com.google.inject.Inject;

public class Service {
	@Inject
	private ILogin login;

	public void doSomethingSecure() {
		login.execute();
		System.out.println("Some secure functionality");
	}
}
