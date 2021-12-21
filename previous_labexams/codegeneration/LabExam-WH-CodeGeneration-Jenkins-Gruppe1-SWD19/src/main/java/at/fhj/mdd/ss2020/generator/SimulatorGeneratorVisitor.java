package at.fhj.mdd.ss2020.generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import at.fhj.mdd.ss2020.metamodel.*;

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

			visit(job.getTrigger());

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

			visitPreBuildTasks(job);

			// TODO: implement end
			writer.println("\t\treturn true;");
			writer.println("\t}");
			writer.println();
			writer.println("\tpublic boolean build(JenkinsSimulator simulator) {");
			// TODO: implement start

			visitBuildTasks(job);

			// TODO: implement end
			writer.println("\t\treturn true;");
			writer.println("\t}");
			writer.println();
			writer.println("\tpublic boolean postbuild(JenkinsSimulator simulator) {");
			// TODO: implement start

			visitPostBuildTasks(job);

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

	@Override
	public void visit(MTrigger trigger) {
		writer.print("\t\twhile (!simulator.");

		super.visit(trigger);

		writer.println(")) {");
	}

	@Override
	public void visit(MVersioningTrigger trigger) {
		writer.printf("isVersionUpdated(\"%s\"", trigger.getUrl());
	}

	@Override
	public void visit(MCronTrigger trigger) {
		writer.printf("isCronReached(\"%s\"", trigger.getCronExpression());
	}

	@Override
	public void visit(MJobTrigger trigger) {
		writer.printf("isJobExecuted(\"%s\"", trigger.getJob().getName());
	}

	@Override
	public void visit(MTask task) {
		writer.printf("\t\tif (!simulator.");

		super.visit(task);

		writer.println(") {\n" +
				"\t\t\treturn false;\n" +
				"\t\t}");
	}

	@Override
	public void visit(MShellTask task) {
		writer.printf("executeShell(\"%s\")", task.getCommand());
	}

	@Override
	public void visit(MMavenTask task) {
		writer.printf("maven(\"%s\")", task.getCommand());
	}

	@Override
	public void visit(MMailTask task) {
		writer.printf("sendMail(Arrays.asList(\"%s\"))", task.getMailAdresses().stream().collect(Collectors.joining("\",\"")));
	}

}
