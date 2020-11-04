package org.se.lab;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;
import org.se.lab.metamodel.MStateMachine;

public class StateMachineBuilderTest {
	@Test
	public void testBuilder() {
		// @formatter:off
		MStateMachine machine = new StateMachineBuilder() 
				.initial("OFF")
					.transitionTo("ON").upon("switchOn()").via("currentOn()")
				.state("ON")
					.transitionTo("OFF").upon("switchOff()").via("currentOff()")
					.transitionToEnd().upon("burnOut()").via("currentOff()")
				.toMachine();
		// @formatter:on

		assertGraph(machine);
	}

	private void assertGraph(MStateMachine machine) {
		String graph = new ModelToObjectDiagram().toDiagram(machine);

		System.out.println(graph);

		String expected = readExpectedFile();
		Assert.assertEquals(normalize(expected), normalize(graph));
	}

	private String normalize(String original) {
		return original.replaceAll("\r", "");
	}

	private String readExpectedFile() {
		try {
			return new String(Files
					.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("expected.uml").toURI())));
		} catch (IOException | URISyntaxException e) {
			throw new RuntimeException("Error reading expected file", e);
		}
	}
}
