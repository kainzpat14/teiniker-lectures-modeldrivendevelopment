package org.se.lab;

public class XMLBuilder extends ElementBuilder {

	public XMLBuilder(String name) {
		super(name, null);
	}

	@Override
	public MDocument build() {
		return new MDocument(this.toElement());
	}

}
