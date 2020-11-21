package org.se.lab.generator;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.se.lab.metamodel.MAlgorithm;

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
		StringWriter blockStringWriter = new StringWriter();
		StringWriter methodStringWriter = new StringWriter();
		blockWriter = new PrintWriter(blockStringWriter);
		methodWriter = new PrintWriter(methodStringWriter);
		// TODO: implement
		writer.close();
	}

}
