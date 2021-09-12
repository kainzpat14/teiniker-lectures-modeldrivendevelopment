package at.fhj.mdd.ss2020.metamodel;

import java.io.PrintWriter;

import org.apache.commons.lang3.StringUtils;

public abstract class MField extends MMappedElement {

	public MField(String name, String mapping) {
		super(name, mapping);
	}

	public void generate(PrintWriter writer) {
		writer.println("\t@FieldMapping(elementName = \"" + getMapping() + "\")");
		writer.println("\tprivate " + getType() + " " + getName() + ";");
		writer.println();
		writer.println("\tpublic " + getType() + " get" + StringUtils.capitalize(getName()) + "() {");
		writer.println("\t\treturn " + getName() + ";");
		writer.println("\t}");
		writer.println();
		writer.println(
				"\tpublic void set" + StringUtils.capitalize(getName()) + "(" + getType() + " " + getName() + ") {");
		writer.println("\t\tthis." + getName() + " = " + getName() + ";");
		writer.println("\t}");
		writer.println();
	}

	protected abstract String getType();

}
