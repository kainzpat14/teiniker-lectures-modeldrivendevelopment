package at.fhj.mdd.ss2020.dsl.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MSlide {
	private String header;
	private List<MElement> elements = new ArrayList<>();

	public MSlide(String header) {
		super();
		this.header = header;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public List<MElement> getElements() {
		return elements;
	}

	public void setElements(List<MElement> elements) {
		this.elements = elements;
	}

}
