package org.se.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.se.lab.generator.AlgorithmGenerator;
import org.se.lab.generator.AlgorithmTemplateGenerator;
import org.se.lab.generator.InterfaceGenerator;
import org.se.lab.metamodel.MAlgorithm;
import org.se.lab.metamodel.MConditionalStep;
import org.se.lab.metamodel.MExecuteStep;

public class TestAlgorithmGenerator {

	@Test
	public void testGeneratePhoneAlgorithmInterface() {
		InterfaceGenerator generator = new InterfaceGenerator("IPhoneAlgorithm");
		generator.visit(createPhoneAlgorithm());

		assertFileMatchesResource("IPhoneAlgorithm.java", "IPhoneAlgorithm.java");
	}

	@Test
	public void testGeneratePhoneAlgorithm() {
		AlgorithmGenerator generator = new AlgorithmGenerator("IPhoneAlgorithm", "PhoneAlgorithm");
		generator.visit(createPhoneAlgorithm());

		assertFileMatchesResource("PhoneAlgorithm.java", "PhoneAlgorithm.java");
	}

	@Test
	public void testGeneratePhoneTemplate() {
		AlgorithmTemplateGenerator generator = new AlgorithmTemplateGenerator("PhoneAlgorithmTemplate");
		generator.visit(createPhoneAlgorithm());

		assertFileMatchesResource("PhoneAlgorithmTemplate.java", "PhoneAlgorithmTemplate.java");
	}

	@Test
	public void testGenerateClusterAlgorithmInterface() {
		InterfaceGenerator generator = new InterfaceGenerator("IClusterAlgorithm");
		generator.visit(createClusterAlgorithm());

		assertFileMatchesResource("IClusterAlgorithm.java", "IClusterAlgorithm.java");
	}

	@Test
	public void testGenerateClusterAlgorithm() {
		AlgorithmGenerator generator = new AlgorithmGenerator("IClusterAlgorithm", "ClusterAlgorithm");
		generator.visit(createClusterAlgorithm());

		assertFileMatchesResource("ClusterAlgorithm.java", "ClusterAlgorithm.java");
	}

	@Test
	public void testGenerateClusterTemplate() {
		AlgorithmTemplateGenerator generator = new AlgorithmTemplateGenerator("ClusterAlgorithmTemplate");
		generator.visit(createClusterAlgorithm());

		assertFileMatchesResource("ClusterAlgorithmTemplate.java", "ClusterAlgorithmTemplate.java");
	}

	public MAlgorithm createClusterAlgorithm() {
		MConditionalStep node1Available = new MConditionalStep("isNode1Available");
		MExecuteStep dispatchToNode1 = new MExecuteStep("dispatchToNode1");
		MConditionalStep node2Available = new MConditionalStep("isNode2Available");
		MExecuteStep dispatchToNode2 = new MExecuteStep("dispatchToNode2");
		MExecuteStep sendError503 = new MExecuteStep("sendError503");

		node1Available.setTrueStep(dispatchToNode1);
		node1Available.setFalseStep(node2Available);
		node2Available.setTrueStep(dispatchToNode2);
		node2Available.setFalseStep(sendError503);

		return new MAlgorithm(node1Available);
	}

	public MAlgorithm createPhoneAlgorithm() {
		MExecuteStep announceNumbers = new MExecuteStep("announceNumbers");
		MExecuteStep takeNumber1 = new MExecuteStep("takeNumber");
		MConditionalStep checkNumberAgainst1 = new MConditionalStep("enteredNumber1");
		MExecuteStep connectToDoctor = new MExecuteStep("connectToDoctor");
		MConditionalStep checkNumberAgainst2 = new MConditionalStep("enteredNumber2");
		MExecuteStep connectToAdministration = new MExecuteStep("connectToAdministration");
		MExecuteStep disconnect = new MExecuteStep("disconnect");

		announceNumbers.setNextStep(takeNumber1);
		takeNumber1.setNextStep(checkNumberAgainst1);
		checkNumberAgainst1.setTrueStep(connectToDoctor);
		checkNumberAgainst1.setFalseStep(checkNumberAgainst2);
		checkNumberAgainst2.setTrueStep(connectToAdministration);
		checkNumberAgainst2.setFalseStep(disconnect);

		return new MAlgorithm(announceNumbers);
	}

	private void assertFileMatchesResource(String actualFilename, String expectedResourceName) {
		try {
			Path genBasePath = Paths.get("src/gen/java/org/se/lab");
			String actual = normalize(Files.readString(genBasePath.resolve(actualFilename)));
			String expected = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader()
					.getResourceAsStream("expected/org/se/lab/" + expectedResourceName))).lines().parallel()
							.collect(Collectors.joining("\n"))
					+ "\n";
			Assert.assertEquals(expected, actual);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	private String normalize(String stringWithLineEndings) {
		return stringWithLineEndings.replace("\r", "\n");
	}
}
