package org.se.lab;

import java.io.PrintWriter;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ExecutableType;

import org.apache.commons.lang3.StringUtils;

public class BuilderGeneratorJavaTypeVisitor extends AbstractJavaTypeVisitor {
	private PrintWriter out;
	private String simpleName;

	public BuilderGeneratorJavaTypeVisitor(PrintWriter out) {
		super();
		this.out = out;
	}

	@Override
	public void visitClass(TypeElement clazz) {
		String className = clazz.getQualifiedName().toString();
		String packageName = determinePackageName(className);
		simpleName = clazz.getSimpleName() + "Builder";

		if (packageName != null) {
			out.println("package " + packageName + ";");
			out.println();
		}

		out.println("public class " + simpleName + " {");
		out.println("\tprivate " + className + " obj = new " + className + "();");
		out.println();
		super.visitClass(clazz);
		out.println("\tpublic " + className + " build() {");
		out.println("\t\treturn obj;");
		out.println("\t}");
		out.println("}");
	}

	@Override
	public void visitSetter(ExecutableElement setter) {
		String typeName = ((ExecutableType) setter.asType()).getParameterTypes().get(0).toString();
		String variableName = StringUtils.uncapitalize(setter.getSimpleName().toString().substring(3));
		out.println("\tpublic " + simpleName + " " + variableName + "(" + typeName + " " + variableName + ") {");
		out.println("\t\tobj." + setter.getSimpleName() + "(" + variableName + ");");
		out.println("\t\treturn this;");
		out.println("\t}");
	}

	private String determinePackageName(String className) {
		String packageName = null;
		int lastDot = className.lastIndexOf('.');
		if (lastDot > 0) {
			packageName = className.substring(0, lastDot);
		}
		return packageName;
	}

}
