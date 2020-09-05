package at.fhj.mdd.ss2020.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import at.fhj.mdd.ss2020.TelegramsBuilder;
import at.fhj.mdd.ss2020.metamodel.MTelegrams;

public class TestGenerator {

	@Test
	public void testGenerator() {
		// @formatter:off
		MTelegrams telegrams = new TelegramsBuilder()
				.inOutTelegram("Alive", "ALIVE")
				.outTelegram("Transport", "TRANSPORT")
					.stringField("barcode", "BARCODE")
					.intField("target", "TARGET")
				.toTelegrams();
		// @formatter:on
		try {
			Path actual = Files.createTempDirectory("generated_").toAbsolutePath();
			System.out.println("Generating to " + actual.toString());
			new TelegramClassGenerator("at.fhj.mdd.ss2020", actual.toString()).visit(telegrams);

			Path expected = Files.createTempDirectory("expected_").toAbsolutePath();
			ResourceDirectoryUtil.copyContentOfResourcesRecursively(
					this.getClass().getClassLoader().getResource("expected"), expected.toFile());
			assertTreeEquals(expected, actual);
		} catch (IOException ex) {
			throw new RuntimeException("Error generating", ex);
		}
	}

	private void assertTreeEquals(Path expected, Path actual) {
		try {
			Set<Path> actualChildren = Files.list(actual).collect(Collectors.toSet());
			for (Path child : Files.list(expected).collect(Collectors.toSet())) {
				Path expectedPath = Paths.get(actual.toString(), child.getFileName().toString());
				Assert.assertTrue("Expected " + expectedPath + " to exist", actualChildren.contains(expectedPath));
				if (Files.isDirectory(child)) {
					Assert.assertTrue("Expected " + expectedPath + " to be a directory",
							Files.isDirectory(expectedPath));
					assertTreeEquals(child, expectedPath);
				} else {
					Assert.assertTrue("Expected " + expectedPath + " to be a file", Files.isRegularFile(expectedPath));
					assertFileEquals(child, expectedPath);
				}
				actualChildren.remove(expectedPath);
			}
			Assert.assertTrue(actual + " has more elements than " + expected, actualChildren.isEmpty());
		} catch (IOException ex) {
			throw new RuntimeException("Error asserting", ex);
		}
	}

	private void assertFileEquals(Path expected, Path actual) {
		try {
			String expectedContent = new String(Files.readAllBytes(expected));
			String actualContent = new String(Files.readAllBytes(actual));
			Assert.assertEquals(expectedContent, actualContent.replace("\r", ""));
		} catch (IOException ex) {
			throw new RuntimeException("Error asserting file equalness", ex);
		}
	}
}
