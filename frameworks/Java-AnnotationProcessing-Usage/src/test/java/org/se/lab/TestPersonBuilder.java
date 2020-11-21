package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class TestPersonBuilder {
	@Test
	public void testPersonBuilder() {
		PersonBuilder builder = new PersonBuilder();
		Person person = builder.firstname("Max").lastname("Mustermann").build();
		Assert.assertEquals("Max", person.getFirstname());
		Assert.assertEquals("Mustermann", person.getLastname());
	}
}
