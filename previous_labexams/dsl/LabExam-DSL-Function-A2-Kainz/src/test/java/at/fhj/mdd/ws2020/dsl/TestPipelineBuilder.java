package at.fhj.mdd.ws2020.dsl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import at.fhj.mdd.ws2020.dsl.metamodel.MPipeline;

public class TestPipelineBuilder {
	@Test
	public void testPipelineBuilder() {
		// @formatter:off
		MPipeline pipeline = new PipelineBuilder()
				.function("input")
				.function("square")
					.parameter("base")
				.function("add")
					.parameter("summand1")
					.parameter("summand2")
				.function("sqrt")
					.parameter("square")
				.end("sqrt")
					.input("add")
						.input("square")
							.input("input").done()
							.done()
						.input("square")
							.input("input").done()
							.done()
						.done()
					.done()
				.toPipeline();
		// @formatter:on

		assertGraph(pipeline);
	}

	private <T> void assertGraph(T game) {
		String graph = new ModelToObjectDiagram().toDiagram(game);

		System.out.println(graph);

		String expected = readExpectedFile();
		Assert.assertEquals(normalize(expected), normalize(graph));
	}

	private String normalize(String source) {
		return source.trim().replace("\r", "");
	}

	private String readExpectedFile() {
		try {
			return new String(Files
					.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("expected.puml").toURI())));
		} catch (IOException | URISyntaxException e) {
			throw new RuntimeException("Error reading expected file", e);
		}
	}
}
