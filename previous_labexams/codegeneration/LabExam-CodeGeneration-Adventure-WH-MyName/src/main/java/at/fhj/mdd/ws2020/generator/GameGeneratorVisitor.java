package at.fhj.mdd.ws2020.generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import at.fhj.mdd.ws2020.metamodel.MGame;

public class GameGeneratorVisitor extends AbstractGameVisitor {

	// contains the content of the canExecute method
	private PrintWriter canExecuteWriter;
	// contains the content of the execute method
	private PrintWriter executeWriter;

	@Override
	public void visit(MGame game) {
		try {

			StringWriter canExecuteString = new StringWriter();
			canExecuteWriter = new PrintWriter(canExecuteString);
			StringWriter executeString = new StringWriter();
			executeWriter = new PrintWriter(executeString);
			super.visit(game);
			canExecuteWriter.close();
			executeWriter.close();

			PrintWriter writer = new PrintWriter(
					Files.newBufferedWriter(Paths.get("src/gen/java/at/fhj/mdd/ws2020/GameInteractionExecutor.java")));
			writer.println("package at.fhj.mdd.ws2020;");
			writer.println();
			writer.println("import at.fhj.mdd.ws2020.game.Game;");
			writer.println("import at.fhj.mdd.ws2020.game.InteractionExecutor;");
			writer.println("import at.fhj.mdd.ws2020.game.Inventory;");
			writer.println();
			writer.println("public class GameInteractionExecutor implements InteractionExecutor {");
			writer.println();
			writer.println("\t@Override");
			writer.println(
					"\tpublic void execute(Game game, String roomName, String objectName, String interactionName) {");
			writer.print(executeString.toString());
			writer.println("\t}");
			writer.println();
			writer.println("\t@Override");
			writer.println(
					"\tpublic boolean canExecute(Inventory inventory, String roomName, String objectName, String interactionName) {");
			writer.print(canExecuteString.toString());
			writer.println("\t\treturn false;");
			writer.println("\t}");
			writer.println("}");
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// TODO: implement (only write to canExecutewriter and executeWriter)

}
