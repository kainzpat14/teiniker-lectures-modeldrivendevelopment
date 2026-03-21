package org.se.lab;

import org.se.lab.metamodel.MType;

@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class TypedBuilder<T extends TypedBuilder> {

	protected MType type;

	public T asVoid() {
		type = new MType("void");
		return (T) this;
	}

	public T asInt() {
		type = new MType("int");
		return (T) this;
	}

	public T asBoolean() {
		type = new MType("boolean");
		return (T) this;
	}
}
