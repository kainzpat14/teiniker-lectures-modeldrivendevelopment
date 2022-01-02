package org.se.lab;

import java.nio.file.Paths;

import org.junit.Test;
import org.se.lab.metamodel.MEntity;

public class TestGroovyEntityGenerator {
	@Test
	public void testGenerate() {
		// @formatter:off
		MEntity entity = new EntityBuilder()
				.name("student")
				.property("firstname").asString()
				.property("lastname").asString()
				.property("matnr").asInt().isId()
				.toEntity();
		// @formatter:on

		new GroovyEntityGenerator().generate(entity, Paths.get("src/test/resources/Student.java"));
	}
}
