package org.se.lab.generator;

import java.io.PrintWriter;

import org.se.lab.metamodel.MAlgorithm;
import org.se.lab.metamodel.MConditionalStep;
import org.se.lab.metamodel.MExecuteStep;

public class AlgorithmGenerator extends AbstractAlgorithmVisitor {
	private String interfaceName;
	private String className;
	private PrintWriter writer;
	private GeneratorUtil util = new GeneratorUtil();
	private int depth = 0;

	public AlgorithmGenerator(String interfaceName, String className) {
		this.interfaceName = interfaceName;
		this.className = className;
	}

	@Override
	public void visit(MAlgorithm algorithm) {
		writer = util.generateFile(className + ".java");
		writer.println("public class " + className + " {");
		writer.println("\tpublic void runAlgorithm(" + interfaceName + " delegate) {");
		depth = 2;
		super.visit(algorithm);
		writer.println("\t}");
		writer.println("}");
		writer.close();
	}

	private void printDepth() {
		for (int i = 0; i < depth; i++) {
			writer.print("\t");
		}
	}

	@Override
	public void visit(MConditionalStep step) {
		printDepth();
		writer.println("if(delegate." + step.getMethodName() + "()) {");
		depth++;
		visit(step.getTrueStep());
		depth--;
		printDepth();
		writer.println("}");
		if (step.getFalseStep() != null) {
			printDepth();
			writer.println("else {");
			depth++;
			visit(step.getFalseStep());
			depth--;
			printDepth();
			writer.println("}");
		}
	}

	@Override
	public void visit(MExecuteStep step) {
		printDepth();
		writer.println("delegate." + step.getMethodName() + "();");
		super.visit(step);
	}

}
