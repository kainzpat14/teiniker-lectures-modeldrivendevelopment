package org.se.lab;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ConsoleLoginTest {
	@Test
	public void testLogin() {
		Injector injector = Guice.createInjector(new DIModule());
		Service service = injector.getInstance(Service.class);
		service.doSomethingSecure();
	}
}
