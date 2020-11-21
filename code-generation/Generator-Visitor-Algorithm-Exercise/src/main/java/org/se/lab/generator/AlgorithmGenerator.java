package org.se.lab.generator;

import java.io.PrintWriter;

import org.se.lab.metamodel.MAlgorithm;

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
		// TODO: implement
		writer.close();
	}

}
