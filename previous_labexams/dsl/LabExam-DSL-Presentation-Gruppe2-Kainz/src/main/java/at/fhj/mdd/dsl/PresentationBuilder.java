package at.fhj.mdd.dsl;

import at.fhj.mdd.dsl.metamodel.MPresentation;
import at.fhj.mdd.dsl.metamodel.MSlide;

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
