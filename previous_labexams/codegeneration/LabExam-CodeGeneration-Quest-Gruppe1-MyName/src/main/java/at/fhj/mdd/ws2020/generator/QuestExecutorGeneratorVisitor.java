package at.fhj.mdd.ws2020.generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import at.fhj.mdd.ws2020.metamodel.MQuest;

public class QuestExecutorGeneratorVisitor extends AbstractGameVisitor {

	private PrintWriter writer;

	@Override
	public void visit(MQuest quest) {
		try {
			String className = getClassName(quest.getShortDescription());
			writer = new PrintWriter(
					Files.newBufferedWriter(Paths.get("src/gen/java/at/fhj/mdd/ws2020/" + className + ".java")));
			writer.println("package at.fhj.mdd.ws2020;");
			writer.println();
			writer.println("import at.fhj.mdd.ws2020.game.Player;");
			writer.println("import at.fhj.mdd.ws2020.game.QuestExecutor;");
			writer.println();
			writer.println("public class " + className + " implements QuestExecutor {");
			writer.println();
			writer.println("\t@Override");
			writer.println("\tpublic void executeQuest(Player player) {");
			// TODO: implement start

			// TODO: implement end
			writer.println("\t}");
			writer.println("}");
			writer.close();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	private String getClassName(String shortDescription) {
		String[] parts = shortDescription.split(" ");
		return Arrays.stream(parts).map(StringUtils::capitalize).collect(Collectors.joining("")) + "QuestExecutor";
	}

	// TODO: implement start

	// TODO: implement end

}
