package at.fhj.mdd.ss2020.metamodel;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MTelegram extends MMappedElement {
	private List<MField> fields = new ArrayList<>();

	public MTelegram(String name, String mapping) {
		super(name, mapping);
	}

	public List<MField> getFields() {
		return fields;
	}

	public void setFields(List<MField> fields) {
		this.fields = fields;
	}

	public void generate(Path target, String pkg) {
		try {
			PrintWriter writer = new PrintWriter(Files.newBufferedWriter(target.resolve(getName() + "Telegram.java")));
			writer.println("package " + pkg + ";");
			writer.println();
			writer.println("import at.fhj.mdd.ss2020.annotations.FieldMapping;");
			writer.println("import at.fhj.mdd.ss2020.annotations.TelegramMapping;");
			writer.println();
			writer.println("@TelegramMapping(elementName = \"" + getMapping() + "\")");
			writer.println("public class " + getName() + "Telegram {");
			writer.println();
			writer.println("\tpublic " + getName() + "Telegram() {");
			writer.println();
			writer.println("\t}");
			writer.println();

			for (MField field : getFields()) {
				field.generate(writer);
			}

			writer.println("}");
			writer.close();
		} catch (IOException ex) {
			throw new RuntimeException("Error generating " + getName(), ex);
		}
	}

}
