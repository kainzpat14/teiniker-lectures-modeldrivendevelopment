package org.se.lab;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

public class XMLBuilderTest {
	@Test
	public void testXML() throws IOException, URISyntaxException {
		//@formatter:off
		MDocument document = new XMLBuilder("students")
			.element("student")
				.attribute("name","John Doe")
				.attribute("startingYear","2019")
				.element("grades")
					.element("grade")
						.attribute("lecture","MDD")
						.attribute("grade","2")
						.done()
					.element("grade")
						.attribute("lecture","PSE")
						.attribute("grade","1")
						.done()
					.done()
				.done()
			.element("student")
				.attribute("name","Jane Doe")
				.attribute("startingYear","2019")
				.element("grades")
					.element("grade")
						.attribute("lecture","MDD")
						.attribute("grade","1")
						.done()
					.element("grade")
						.attribute("lecture","PSE")
						.attribute("grade","1")
						.done()
					.done()
				.done()
			.build();
		//@formatter:on	
		String uml = new ModelToObjectDiagram().toDiagram(document).replace("\r", "");
		System.out.println(uml);
		assertGraph(uml);

	}

	private void assertGraph(String uml) throws IOException, URISyntaxException {
		String expected = new String(Files
				.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("expectedModel.uml").toURI())))
						.replace("\r", "");
		Assert.assertEquals(expected, uml);
	}
}
