package at.fhj.mdd.ss2020.dsl;

import at.fhj.mdd.ss2020.dsl.metamodel.MPresentation;
import at.fhj.mdd.ss2020.dsl.metamodel.MSlide;

public class PresentationBuilder {
	private MPresentation presentation = new MPresentation();

	public SlideBuilder slide(String header) {
		MSlide slide = new MSlide(header);
		presentation.getSlides().add(slide);
		return new SlideBuilder(this, slide);
	}

	public MPresentation toPresentation() {
		return presentation;
	}
}
