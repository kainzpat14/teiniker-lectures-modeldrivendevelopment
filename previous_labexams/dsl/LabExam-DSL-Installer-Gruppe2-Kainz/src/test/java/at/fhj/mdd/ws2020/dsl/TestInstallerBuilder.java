package at.fhj.mdd.ws2020.dsl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import at.fhj.mdd.ws2020.dsl.metamodel.MInstaller;

public class TestInstallerBuilder {
	@Test
	public void testInstallerBuilder() {
		// @formatter:off
		MInstaller installer = new InstallerBuilder()
				.preSetup()
					.print("Welcome to the installation","We are installing your cool product now!")
					.execute("prepSystem.sh")
				.setup()
					.mkdir("/opt/myapplication")
						.cleanup().execute("cleanupAppDir.sh")
					.copy("binary", "/opt/myapplication/binary")
						.cleanup().execute("cleanupAppDir.sh")
				.cleanup()
					.execute("cleanTempFiles.sh")
					.print("Done!", "Installation complete")
				.toInstaller();
		// @formatter:on

		assertGraph(installer);
	}

	private void assertGraph(MInstaller installer) {
		String graph = new ModelToObjectDiagram().toDiagram(installer);

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
