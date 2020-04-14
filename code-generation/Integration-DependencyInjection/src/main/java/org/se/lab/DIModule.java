package org.se.lab;

import com.google.inject.AbstractModule;

public class DIModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ILogin.class).to(ConsoleLogin.class);
	}

}
