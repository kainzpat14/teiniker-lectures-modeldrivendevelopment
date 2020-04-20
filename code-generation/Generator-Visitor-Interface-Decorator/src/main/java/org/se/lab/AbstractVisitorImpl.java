package org.se.lab;

import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MOperation;
import org.se.lab.metamodel.MPackage;
import org.se.lab.metamodel.MParameter;
import org.se.lab.metamodel.MType;

public abstract class AbstractVisitorImpl extends AbstractVisitor {

	private StringBuilder sb = new StringBuilder();

	@Override
	public void visit(MType mType) {
		getSB().append(mType.getName());
	}

	@Override
	public void visit(MPackage mPackage) {
		getSB().append("package ");
		getSB().append(mPackage.getName());
		getSB().append(";\n\n");
		for (MInterface mInterface : mPackage.getInterfaces()) {
			visit(mInterface);
		}
	}

	@Override
	public void visit(MParameter mParameter) {
		visit(mParameter, true);
	}

	protected void visit(MParameter mParameter, boolean visitType) {
		if (visitType) {
			visit(mParameter.getType());
			getSB().append(" ");
		}
		getSB().append(mParameter.getName());
	}

	protected void visitSimpleOperation(MOperation mOperation) {
		visitSimpleOperation(mOperation, true);
	}

	protected void visitSimpleOperation(MOperation mOperation, boolean visitType) {
		if (visitType) {
			visit(mOperation.getType());
			getSB().append(" ");
		}
		getSB().append(mOperation.getName());
		getSB().append("(");
		for (int i = 0; i < mOperation.getParameters().size(); i++) {
			visit(mOperation.getParameters().get(i), visitType);
			if (i < mOperation.getParameters().size() - 1) {
				getSB().append(", ");
			}
		}
		getSB().append(")");
	}

	@Override
	public String toString() {
		String code = this.sb.toString();
		this.sb = new StringBuilder();
		return code;
	}

	protected StringBuilder getSB() {
		return this.sb;
	}

}
