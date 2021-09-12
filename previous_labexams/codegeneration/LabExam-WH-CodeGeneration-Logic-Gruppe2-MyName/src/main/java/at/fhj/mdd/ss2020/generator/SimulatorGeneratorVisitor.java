package at.fhj.mdd.ss2020.generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import at.fhj.mdd.ss2020.metamodel.MModel;

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

	// TODO: Implement end

}
