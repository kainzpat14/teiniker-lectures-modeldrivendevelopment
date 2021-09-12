package at.fhj.mdd.ss2020.generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import at.fhj.mdd.ss2020.metamodel.MAnd;
import at.fhj.mdd.ss2020.metamodel.MCircuit;
import at.fhj.mdd.ss2020.metamodel.MCircuitReuse;
import at.fhj.mdd.ss2020.metamodel.MCurrentSource;
import at.fhj.mdd.ss2020.metamodel.MInput;
import at.fhj.mdd.ss2020.metamodel.MModel;
import at.fhj.mdd.ss2020.metamodel.MNot;
import at.fhj.mdd.ss2020.metamodel.MOr;

public class SimulatorGeneratorVisitor extends AbstractModelVisitor {

	private PrintWriter writer;

	@Override
	public void visit(MModel model) {
		try {
			writer = new PrintWriter(
					Files.newBufferedWriter(Paths.get("src/gen/java/at/fhj/mdd/ss2020/CircuitSimulator.java")));
			writer.println("package at.fhj.mdd.ss2020;");
			writer.println();
			writer.println("public class CircuitSimulator {");
			super.visit(model);
			writer.println("}");
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	// TODO: Implement start
	@Override
	public void visit(MCircuit circuit) {
		writer.print("\tpublic boolean " + circuit.getName() + "(");
		boolean first = true;
		for (MInput input : circuit.getInputs()) {
			if (!first) {
				writer.print(", ");
			}
			first = false;
			writer.print("boolean ");
			visit(input);
		}
		writer.println(") {");
		writer.print("\t\treturn ");
		super.visit(circuit);
		writer.println(";");
		writer.println("\t}");
	}

	@Override
	public void visit(MInput input) {
		writer.print(input.getName());
	}

	@Override
	public void visit(MNot not) {
		writer.print("!(");
		super.visit(not);
		writer.print(")");
	}

	@Override
	public void visit(MAnd and) {
		writer.print("(");
		visit(and.getSource1());
		writer.print(")&&(");
		visit(and.getSource2());
		writer.print(")");
	}

	@Override
	public void visit(MOr or) {
		writer.print("(");
		visit(or.getSource1());
		writer.print(")||(");
		visit(or.getSource2());
		writer.print(")");
	}

	@Override
	public void visit(MCircuitReuse reuse) {
		writer.print(reuse.getCircuit().getName() + "(");
		boolean first = true;
		for (MCurrentSource input : reuse.getInputs()) {
			if (!first) {
				writer.print(", ");
			}
			first = false;
			visit(input);
		}
		writer.print(")");
	}
	// TODO: Implement end

}
