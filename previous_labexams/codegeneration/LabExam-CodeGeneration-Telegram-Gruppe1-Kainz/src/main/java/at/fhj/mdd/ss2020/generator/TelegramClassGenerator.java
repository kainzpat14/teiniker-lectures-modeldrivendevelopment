package at.fhj.mdd.ss2020.generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;

import at.fhj.mdd.ss2020.metamodel.MField;
import at.fhj.mdd.ss2020.metamodel.MIntField;
import at.fhj.mdd.ss2020.metamodel.MStringField;
import at.fhj.mdd.ss2020.metamodel.MTelegram;
import at.fhj.mdd.ss2020.metamodel.MTelegrams;

public class TelegramClassGenerator extends AbstractTelegramVisitor {

	private String pkg;
	private String basePath;
	private PrintWriter currentWriter;
	private Path target;

	public TelegramClassGenerator(String pkg, String basePath) {
		this.pkg = pkg;
		this.basePath = basePath;
	}

	@Override
	public void visit(MTelegrams telegrams) {
		String path = pkg.replace(".", "/");
		target = Paths.get(basePath, path);
		if (!Files.exists(target)) {
			try {
				Files.createDirectories(target);
			} catch (IOException ex) {
				throw new RuntimeException("Could not create directory " + target, ex);
			}
		}
		super.visit(telegrams);
	}

	@Override
	public void visit(MTelegram telegram) {
		try {
			currentWriter = new PrintWriter(
					Files.newBufferedWriter(target.resolve(telegram.getName() + "Telegram.java")));
			currentWriter.println("package " + pkg + ";");
			currentWriter.println();
			currentWriter.println("import at.fhj.mdd.ss2020.annotations.FieldMapping;");
			currentWriter.println("import at.fhj.mdd.ss2020.annotations.TelegramMapping;");
			currentWriter.println();
			currentWriter.println("@TelegramMapping(elementName = \"" + telegram.getMapping() + "\")");
			currentWriter.println("public class " + telegram.getName() + "Telegram {");
			currentWriter.println();
			currentWriter.println("\tpublic " + telegram.getName() + "Telegram() {");
			currentWriter.println();
			currentWriter.println("\t}");
			currentWriter.println();
			super.visit(telegram);
			currentWriter.println("}");
			currentWriter.close();
		} catch (IOException ex) {
			throw new RuntimeException("Could not write telegram " + telegram.getName(), ex);
		}
	}

	@Override
	public void visit(MField field) {
		currentWriter.println("\t@FieldMapping(elementName = \"" + field.getMapping() + "\")");
		currentWriter.print("\tprivate ");
		super.visit(field);
		currentWriter.println(" " + field.getName() + ";");
		currentWriter.println();
		currentWriter.print("\tpublic ");
		super.visit(field);
		currentWriter.println(" get" + StringUtils.capitalize(field.getName()) + "() {");
		currentWriter.println("\t\treturn " + field.getName() + ";");
		currentWriter.println("\t}");
		currentWriter.println();

		currentWriter.print("\tpublic void set" + StringUtils.capitalize(field.getName()) + "(");
		super.visit(field);
		currentWriter.println(" " + field.getName() + ") {");
		currentWriter.println("\t\tthis." + field.getName() + " = " + field.getName() + ";");
		currentWriter.println("\t}");
		currentWriter.println();

	}

	@Override
	public void visit(MIntField field) {
		currentWriter.print("int");
	}

	@Override
	public void visit(MStringField field) {
		currentWriter.print("String");
	}

}
