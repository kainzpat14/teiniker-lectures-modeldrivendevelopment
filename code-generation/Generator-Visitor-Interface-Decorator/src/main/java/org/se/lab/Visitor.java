package org.se.lab;

import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MOperation;
import org.se.lab.metamodel.MPackage;
import org.se.lab.metamodel.MParameter;
import org.se.lab.metamodel.MType;

public interface Visitor {
	void visit(MInterface iface);

	void visit(MOperation operation);

	void visit(MPackage pkg);

	void visit(MParameter parameter);

	void visit(MType type);

	@Override
	String toString();

}
