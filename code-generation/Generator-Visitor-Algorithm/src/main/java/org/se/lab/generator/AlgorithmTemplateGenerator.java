package org.se.lab.generator;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.se.lab.metamodel.MAlgorithm;
import org.se.lab.metamodel.MConditionalStep;
import org.se.lab.metamodel.MExecuteStep;

public class AlgorithmTemplateGenerator extends AbstractAlgorithmVisitor {
	private String className;
	private PrintWriter methodWriter;
	private PrintWriter blockWriter;
	private GeneratorUtil util = new GeneratorUtil();
	private int depth = 0;

	public AlgorithmTemplateGenerator(String className) {
		this.className = className;
	}

	@Override
	public void visit(MAlgorithm algorithm) {
		PrintWriter writer = util.generateFile(className + ".java");
		writer.println("public abstract class " + className + " {");

		StringWriter blockStringWriter = new StringWriter();
		StringWriter methodStringWriter = new StringWriter();
		blockWriter = new PrintWriter(blockStringWriter);
		methodWriter = new PrintWriter(methodStringWriter);
		depth = 2;
		super.visit(algorithm);
		blockWriter.close();
		methodWriter.close();

		writer.println("\tpublic void runAlgorithm() {");
		writer.print(blockStringWriter.toString());
		writer.println("\t}");
		writer.println();
		writer.print(methodStringWriter.toString());
		writer.println("}");
		writer.close();
	}

	private void printDepth() {
		for (int i = 0; i < depth; i++) {
			blockWriter.print("\t");
		}
	}

	@Override
	public void visit(MConditionalStep step) {
		methodWriter.println("\tprotected abstract boolean " + step.getMethodName() + "();");

		printDepth();
		blockWriter.println("if(" + step.getMethodName() + "()) {");
		depth++;
		visit(step.getTrueStep());
		depth--;
		printDepth();
		blockWriter.println("}");
		if (step.getFalseStep() != null) {
			printDepth();
			blockWriter.println("else {");
			depth++;
			visit(step.getFalseStep());
			depth--;
			printDepth();
			blockWriter.println("}");
		}
	}

	@Override
	public void visit(MExecuteStep step) {
		methodWriter.println("\tprotected abstract void " + step.getMethodName() + "();");

		printDepth();
		blockWriter.println(step.getMethodName() + "();");
		super.visit(step);
	}
}
