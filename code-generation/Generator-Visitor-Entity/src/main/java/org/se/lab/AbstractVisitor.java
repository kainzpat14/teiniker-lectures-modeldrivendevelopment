package org.se.lab;

import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MString;
import org.se.lab.metamodel.MType;

public abstract class AbstractVisitor implements Visitor {
	@Override
	public String visitMType(MType type) {
		if (type instanceof MInteger) {
			return visitMInteger((MInteger) type);
		} else if (type instanceof MString) {
			return visitMString((MString) type);
		} else {
			throw new IllegalArgumentException("unknown MType:" + type);
		}
	}
}
