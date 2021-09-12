package at.fhj.mdd.ws2020.generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import at.fhj.mdd.ws2020.metamodel.MInstaller;

public class InstallExecutorGeneratorVisitor extends AbstractInstallerVisitor {

	private PrintWriter writer;

	@Override
	public void visit(MInstaller installer) {
		try {
			writer = new PrintWriter(
					Files.newBufferedWriter(Paths.get("src/gen/java/at/fhj/mdd/ws2020/MyInstallExecutor.java")));
			writer.println("package at.fhj.mdd.ws2020;");
			writer.println();
			writer.println("import at.fhj.mdd.ws2020.installer.InstallExecutor;");
			writer.println("import at.fhj.mdd.ws2020.installer.Installer;");
			writer.println();
			writer.println("public class MyInstallExecutor implements InstallExecutor {");
			writer.println();
			writer.println("\t@Override");
			writer.println("\tpublic void execute(Installer installer) {");
			// TODO: implement start

			// TODO: implement end
			writer.println("\t}");
			writer.println("}");
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// TODO: implement start
	// TODO: implement end
}
