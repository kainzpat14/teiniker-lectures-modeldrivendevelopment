package at.fhj.mdd.ss2020.dsl;

import at.fhj.mdd.ss2020.dsl.metamodel.MListElement;
import at.fhj.mdd.ss2020.dsl.metamodel.MListEntry;
import at.fhj.mdd.ss2020.dsl.metamodel.MPresentation;

public class ListBuilder {
	private SlideBuilder parent;
	private MListElement list;

	public ListBuilder(SlideBuilder parent, MListElement list) {
		this.parent = parent;
		this.list = list;
	}

	public ListBuilder entry(String text) {
		list.getEntries().add(new MListEntry(text));
		return this;
	}

	public SlideBuilder text(String text) {
		return parent.text(text);
	}

	public SlideBuilder picture(String pictureUrl) {
		return parent.picture(pictureUrl);
	}

	public ListBuilder list() {
		return parent.list();
	}

	public SlideBuilder slide(String header) {
		return parent.slide(header);
	}

	public MPresentation toPresentation() {
		return parent.toPresentation();
	}

}
