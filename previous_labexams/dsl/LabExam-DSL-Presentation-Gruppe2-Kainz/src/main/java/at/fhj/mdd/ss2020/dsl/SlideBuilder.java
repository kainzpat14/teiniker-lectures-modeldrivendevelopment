package at.fhj.mdd.ss2020.dsl;

import at.fhj.mdd.ss2020.dsl.metamodel.MListElement;
import at.fhj.mdd.ss2020.dsl.metamodel.MPictureElement;
import at.fhj.mdd.ss2020.dsl.metamodel.MPresentation;
import at.fhj.mdd.ss2020.dsl.metamodel.MSlide;
import at.fhj.mdd.ss2020.dsl.metamodel.MTextElement;

public class SlideBuilder {
	private PresentationBuilder parent;
	private MSlide slide;

	public SlideBuilder(PresentationBuilder parent, MSlide slide) {
		this.parent = parent;
		this.slide = slide;
	}

	public SlideBuilder text(String text) {
		slide.getElements().add(new MTextElement(text));
		return this;
	}

	public SlideBuilder picture(String pictureUrl) {
		slide.getElements().add(new MPictureElement(pictureUrl));
		return this;
	}

	public ListBuilder list() {
		MListElement list = new MListElement();
		slide.getElements().add(list);
		return new ListBuilder(this, list);
	}

	public SlideBuilder slide(String header) {
		return parent.slide(header);
	}

	public MPresentation toPresentation() {
		return parent.toPresentation();
	}

}
