package at.fhj.mdd.ss2020.dsl.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MPresentation {
	private List<MSlide> slides = new ArrayList<>();

	public List<MSlide> getSlides() {
		return slides;
	}

	public void setSlides(List<MSlide> slides) {
		this.slides = slides;
	}

}
