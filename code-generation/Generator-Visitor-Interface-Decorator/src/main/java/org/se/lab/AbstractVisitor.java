package org.se.lab;

import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MOperation;
import org.se.lab.metamodel.MPackage;
import org.se.lab.metamodel.MParameter;
import org.se.lab.metamodel.MType;

public class AbstractVisitor implements Visitor {

	@Override
	public void visit(MPackage pkg) {
		for (MInterface iface : pkg.getInterfaces()) {
			visit(iface);
		}
	}

	@Override
	public void visit(MInterface iface) {
		for (MOperation operation : iface.getOperations()) {
			visit(operation);
		}
	}

	@Override
	public void visit(MOperation operation) {
		visit(operation.getType());
		for (MParameter parameter : operation.getParameters()) {
			visit(parameter);
		}
	}

	@Override
	public void visit(MParameter parameter) {
		visit(parameter.getType());
	}

	@Override
	public void visit(MType type) {
		// do nothing
	}

}
