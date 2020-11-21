package org.se.lab.generator;

import java.io.PrintWriter;

import org.se.lab.metamodel.MAlgorithm;

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
		// TODO: implement
		writer.close();
	}

}
