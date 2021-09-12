package at.fhj.mdd.ws2020.dsl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import at.fhj.mdd.ws2020.dsl.metamodel.MGame;

public class TestGameBuilder {
	@Test
	public void testGameBuilder() {
		// @formatter:off
		MGame game = new GameBuilder()
				.quest("Rescue the princess", "The princess has been locked into a tower, rescue her!")
					.gather(1, "Key")
						.shortDescription("Find the key!")
						.description("The key to the tower must be here somewhere, we need to find it")
					.kill(1, "Ghost")
						.shortDescription("Kill the ghost")
						.description("The ghost is between you and the princess, slay it!")
				.quest("Take the princess home", "The princess is anxious to get home, help her get there")
					.protect(1, "Princess")
						.shortDescription("Protect the princess")
						.description("The way home is dangerous, protect the princess on your way home")
				.toGame();
		// @formatter:on

		assertGraph(game);
	}

	private void assertGraph(MGame game) {
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
					.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("expected.uml").toURI())));
		} catch (IOException | URISyntaxException e) {
			throw new RuntimeException("Error reading expected file", e);
		}
	}
}
