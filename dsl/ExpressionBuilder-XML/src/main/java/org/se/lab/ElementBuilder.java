package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class ElementBuilder {
	private String name;
	private List<ElementBuilder> children = new ArrayList<ElementBuilder>();
	private ElementBuilder parent;
	private List<MAttribute> attributes = new ArrayList<MAttribute>();

	public ElementBuilder(String name, ElementBuilder parent) {
		this.name = name;
		this.parent = parent;
	}

	public ElementBuilder element(String name) {
		ElementBuilder child = new ElementBuilder(name, this);
		children.add(child);
		return child;
	}

	public ElementBuilder attribute(String name, String value) {
		attributes.add(new MAttribute(name, value));
		return this;
	}

	public MDocument build() {
		return this.parent.build();
	}

	public MNode toElement() {
		MNode element = new MNode(name);
		element.setAttributes(attributes);
		for (ElementBuilder child : children) {
			element.getChildren().add(child.toElement());
		}
		return element;
	}

	public ElementBuilder done() {
		return parent;
	}
}
