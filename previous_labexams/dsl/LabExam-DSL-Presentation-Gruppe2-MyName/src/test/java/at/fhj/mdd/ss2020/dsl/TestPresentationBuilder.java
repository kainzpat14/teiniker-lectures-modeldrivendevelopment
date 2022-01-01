package at.fhj.mdd.ss2020.dsl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import at.fhj.mdd.ss2020.dsl.metamodel.MListElement;
import at.fhj.mdd.ss2020.dsl.metamodel.MListEntry;
import at.fhj.mdd.ss2020.dsl.metamodel.MPictureElement;
import at.fhj.mdd.ss2020.dsl.metamodel.MPresentation;
import at.fhj.mdd.ss2020.dsl.metamodel.MSlide;
import at.fhj.mdd.ss2020.dsl.metamodel.MTextElement;

public class TestPresentationBuilder {

	private static final String COPYLEFT_IMAGE = "https://cdn.pixabay.com/photo/2017/02/21/10/04/symbol-2085312_1280.png";

	@Test
	public void testBuilder() {
		// @formatter:off
		MPresentation presentation = new PresentationBuilder()
				.slide("Introduction")
					.text("Welcome to this LabExam")
				.slide("TODO")
					.text("In this LabExam you will have to: ")
					.list()
						.entry("Create an internal DSL using a builder")
						.entry("Use the object graph to figure out where your mistakes lie")
						.entry("Test your implementation using this test class")
				.slide("Good luck!")
					.picture(COPYLEFT_IMAGE)
			.toPresentation();
		// @formatter:on

		assertGraph(presentation);
	}

	@Test
	public void testObjectGraph() {
		MPresentation presentation = new MPresentation();

		MSlide intro = new MSlide("Introduction");
		intro.getElements().add(new MTextElement("Welcome to this LabExam"));

		MSlide todo = new MSlide("TODO");
		todo.getElements().add(new MTextElement("In this LabExam you will have to: "));
		MListElement list = new MListElement();
		list.getEntries().add(new MListEntry("Create an internal DSL using a builder"));
		list.getEntries().add(new MListEntry("Use the object graph to figure out where your mistakes lie"));
		list.getEntries().add(new MListEntry("Test your implementation using this test class"));
		todo.getElements().add(list);

		MSlide end = new MSlide("Good luck!");
		end.getElements().add(new MPictureElement(COPYLEFT_IMAGE));

		presentation.getSlides().add(intro);
		presentation.getSlides().add(todo);
		presentation.getSlides().add(end);

		assertGraph(presentation);
	}

	private void assertGraph(MPresentation presentation) {
		String graph = new ModelToObjectDiagram().toDiagram(presentation);

		System.out.println(graph);

		String expected = readExpectedFile();
		Assert.assertEquals(expected, graph);
	}

	private String readExpectedFile() {
		try {
			return new String(Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("expected.puml").toURI())));
		} catch (IOException | URISyntaxException e) {
			throw new RuntimeException("Error reading expected file", e);
		}
	}
}
