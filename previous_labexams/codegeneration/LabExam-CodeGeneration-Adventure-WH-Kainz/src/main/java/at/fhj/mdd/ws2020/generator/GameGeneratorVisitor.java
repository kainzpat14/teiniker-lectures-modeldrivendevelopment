package at.fhj.mdd.ws2020.generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import at.fhj.mdd.ws2020.metamodel.MGame;
import at.fhj.mdd.ws2020.metamodel.MInteraction;
import at.fhj.mdd.ws2020.metamodel.MInventoryOccurence;
import at.fhj.mdd.ws2020.metamodel.MObject;
import at.fhj.mdd.ws2020.metamodel.MPrecondition;
import at.fhj.mdd.ws2020.metamodel.MRoom;
import at.fhj.mdd.ws2020.metamodel.MTextOccurence;
import at.fhj.mdd.ws2020.metamodel.MTransportOccurence;

public class GameGeneratorVisitor extends AbstractGameVisitor {

	private PrintWriter canExecuteWriter;
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

	@Override
	public void visit(MRoom room) {
		canExecuteWriter.println("\t\tif(roomName.contentEquals(\"" + room.getName() + "\")) {");
		executeWriter.println("\t\tif(roomName.contentEquals(\"" + room.getName() + "\")) {");

		super.visit(room);

		canExecuteWriter.println("\t\t}");
		executeWriter.println("\t\t}");

	}

	@Override
	public void visit(MObject object) {
		canExecuteWriter.println("\t\t\tif(objectName.contentEquals(\"" + object.getName() + "\")) {");
		executeWriter.println("\t\t\tif(objectName.contentEquals(\"" + object.getName() + "\")) {");

		super.visit(object);

		canExecuteWriter.println("\t\t\t}");
		executeWriter.println("\t\t\t}");
	}

	@Override
	public void visit(MInteraction interaction) {
		canExecuteWriter.println("\t\t\t\tif(interactionName.contentEquals(\"" + interaction.getName() + "\")) {");
		executeWriter.println("\t\t\t\tif(interactionName.contentEquals(\"" + interaction.getName() + "\")) {");

		super.visit(interaction);

		canExecuteWriter.println("\t\t\t\t}");
		executeWriter.println("\t\t\t\t}");
	}

	@Override
	public void visit(MPrecondition precondition) {
		if (precondition == null) {
			canExecuteWriter.println("\t\t\t\t\treturn true;");
		} else {
			canExecuteWriter.println("\t\t\t\t\treturn inventory.hasItem(\"" + precondition.getItem().getName() + "\", "
					+ precondition.getRequiredQuantity() + ");");
		}
	}

	@Override
	public void visit(MInventoryOccurence occurence) {
		executeWriter.println("\t\t\t\t\tgame.addToInventory(\"" + occurence.getItem().getName() + "\", "
				+ occurence.getCount() + ");");
	}

	@Override
	public void visit(MTextOccurence occurence) {
		executeWriter.println("\t\t\t\t\tgame.text(\"" + occurence.getText() + "\");");
	}

	@Override
	public void visit(MTransportOccurence occurence) {
		executeWriter.println("\t\t\t\t\tgame.goToRoom(\"" + occurence.getRoom().getName() + "\");");
	}

}
