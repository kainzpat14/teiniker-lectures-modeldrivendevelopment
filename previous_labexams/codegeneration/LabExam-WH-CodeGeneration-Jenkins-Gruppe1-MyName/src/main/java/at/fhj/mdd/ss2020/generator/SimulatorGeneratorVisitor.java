package at.fhj.mdd.ss2020.generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import at.fhj.mdd.ss2020.metamodel.MJob;

public class SimulatorGeneratorVisitor extends AbstractJobVisitor {

	private PrintWriter writer;

	@Override
	public void visit(MJob job) {
		try {
			writer = new PrintWriter(Files.newBufferedWriter(
					Paths.get("src/gen/java/at/fhj/mdd/ss2020/" + job.getName() + "Simulator.java")));
			writer.println("package at.fhj.mdd.ss2020;");
			writer.println();
			writer.println("import java.util.Arrays;");
			writer.println("import at.fhj.mdd.ss2020.simulator.IJobSimulation;");
			writer.println("import at.fhj.mdd.ss2020.simulator.JenkinsSimulator;");
			writer.println();
			writer.println("public class " + job.getName() + "Simulator implements IJobSimulation {");
			writer.println();
			writer.println("\t@Override");
			writer.println("\tpublic void simulate(JenkinsSimulator simulator) {");
			// TODO: implement start
			// TODO: implement end
			writer.println("\t\t\ttry {");
			writer.println("\t\t\t\tThread.sleep(100);");
			writer.println("\t\t\t} catch (InterruptedException e) { /* ignored */ }");
			writer.println("\t\t}");
			writer.println();
			writer.println("\t\tif (prebuild(simulator)) {");
			writer.println("\t\t\tbuild(simulator);");
			writer.println("\t\t}");
			writer.println();
			writer.println("\t\tpostbuild(simulator);");
			writer.println("\t}");
			writer.println();
			writer.println("\tpublic boolean prebuild(JenkinsSimulator simulator) {");
			// TODO: implement start
			// TODO: implement end
			writer.println("\t\treturn true;");
			writer.println("\t}");
			writer.println();
			writer.println("\tpublic boolean build(JenkinsSimulator simulator) {");
			// TODO: implement start
			// TODO: implement end
			writer.println("\t\treturn true;");
			writer.println("\t}");
			writer.println();
			writer.println("\tpublic boolean postbuild(JenkinsSimulator simulator) {");
			// TODO: implement start
			// TODO: implement end
			writer.println("\t\treturn true;");
			writer.println("\t}");
			writer.println();
			writer.println("}");
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// TODO: implement start

	// TODO: Implement stop

}
