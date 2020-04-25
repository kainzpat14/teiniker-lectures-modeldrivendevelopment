package org.se.lab;

import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MString;

public class CStructGenerator extends AbstractVisitor {

	@Override
	public String visitMInteger(MInteger arg) {
		return "int";
	}

	@Override
	public String visitMString(MString arg) {
		return "char*";
	}

	@Override
	public String visitMProperty(MProperty property) {
		String cType = visitMType(property.getType());
		String name = property.getName();

		StringBuilder code = new StringBuilder();
		code.append(cType).append(" ").append(name).append(";");
		return code.toString();
	}

	@Override
	public String visitMEntity(MEntity entity) {
		String name = entity.getName();

		StringBuilder code = new StringBuilder();
		code.append("typedef struct {\n");
		for (MProperty p : entity.getProperties()) {
			code.append("    ").append(visitMProperty(p)).append("\n");
		}
		code.append("} ").append(name).append(";");
		return code.toString();
	}
}
