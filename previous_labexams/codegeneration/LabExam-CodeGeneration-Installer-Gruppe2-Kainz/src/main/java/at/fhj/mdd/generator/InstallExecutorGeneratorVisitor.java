package at.fhj.mdd.generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import at.fhj.mdd.metamodel.MCopyStep;
import at.fhj.mdd.metamodel.MCreateFolderStep;
import at.fhj.mdd.metamodel.MInstaller;
import at.fhj.mdd.metamodel.MInstallerStep;
import at.fhj.mdd.metamodel.MOutputStep;
import at.fhj.mdd.metamodel.MShellStep;
import at.fhj.mdd.metamodel.MStep;

public class InstallExecutorGeneratorVisitor extends AbstractInstallerVisitor {

	private PrintWriter writer;

	@Override
	public void visit(MInstaller installer) {
		try {
			writer = new PrintWriter(
					Files.newBufferedWriter(Paths.get("src/gen/java/at/fhj/mdd/MyInstallExecutor.java")));
			writer.println("package at.fhj.mdd;");
			writer.println();
			writer.println("import at.fhj.mdd.installer.InstallExecutor;");
			writer.println("import at.fhj.mdd.installer.Installer;");
			writer.println();
			writer.println("public class MyInstallExecutor implements InstallExecutor {");
			writer.println();
			writer.println("\t@Override");
			writer.println("\tpublic void execute(Installer installer) {");
			// TODO: implement start
			for (MStep preStep : installer.getPreSetupSteps()) {
				visitPre(preStep);
			}
			for (MInstallerStep step : installer.getSetupSteps()) {
				visit(step);
			}
			for (MStep step : installer.getCleanupSteps()) {
				writer.print("\t\t");
				visit(step);
				writer.println(";");
			}
			// TODO: implement end
			writer.println("\t}");
			writer.println("}");
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void visitPre(MStep step) {
		writer.print("\t\tif(!");
		visit(step);
		writer.println(") {");
		writer.println("\t\t\treturn;");
		writer.println("\t\t}");
	}

	@Override
	public void visit(MInstallerStep installerStep) {
		writer.print("\t\tif(!");
		visit(installerStep.getInstallStep());
		writer.println(") {");
		writer.print("\t\t\t");
		visit(installerStep.getCleanupStep());
		writer.print(";");
		writer.println("\t\t\treturn;");
		writer.println("\t\t}");
	}

	@Override
	public void visit(MOutputStep step) {
		writer.print("installer.output(\"" + step.getHeader() + "\",\"" + step.getText() + "\")");
	}

	@Override
	public void visit(MCreateFolderStep step) {
		writer.print("installer.mkdir(\"" + step.getFolder() + "\")");
	}

	@Override
	public void visit(MShellStep step) {
		writer.print("installer.execute(\"" + step.getScript() + "\")");
	}

	@Override
	public void visit(MCopyStep step) {
		writer.print("installer.copy(\"" + step.getSource() + "\",\"" + step.getDestination() + "\")");
	}

}
