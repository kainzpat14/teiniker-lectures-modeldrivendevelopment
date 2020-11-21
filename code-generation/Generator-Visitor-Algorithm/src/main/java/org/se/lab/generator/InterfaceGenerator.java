package org.se.lab.generator;

import java.io.PrintWriter;

import org.se.lab.metamodel.MAlgorithm;
import org.se.lab.metamodel.MConditionalStep;
import org.se.lab.metamodel.MExecuteStep;

public class InterfaceGenerator extends AbstractAlgorithmVisitor {
	private String interfaceName;
	private PrintWriter writer;
	private GeneratorUtil util = new GeneratorUtil();

	public InterfaceGenerator(String interfaceName) {
		super();
		this.interfaceName = interfaceName;
	}

	@Override
	public void visit(MAlgorithm algorithm) {
		writer = util.generateFile(interfaceName + ".java");
		writer.println("public interface " + interfaceName + " {");

		super.visit(algorithm);

		writer.println("}");
		writer.close();
	}

	@Override
	public void visit(MConditionalStep step) {
		writer.println("\tboolean " + step.getMethodName() + "();");
		super.visit(step);
	}

	@Override
	public void visit(MExecuteStep step) {
		writer.println("\tvoid " + step.getMethodName() + "();");
		super.visit(step);
	}

}
