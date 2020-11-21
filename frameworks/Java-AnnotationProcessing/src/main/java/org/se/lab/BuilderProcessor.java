package org.se.lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ExecutableType;
import javax.tools.JavaFileObject;

import org.apache.commons.lang3.StringUtils;

@SupportedAnnotationTypes("org.se.lab.Builder")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class BuilderProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (TypeElement annotation : annotations) {
			Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);
			for (Element clazzElement : annotatedElements) {
				TypeElement clazz = (TypeElement) clazzElement;
				writerBuilderClass(clazz);
			}
		}
		return true;
	}

	private void writerBuilderClass(TypeElement clazz) {
		try {
			String className = clazz.getQualifiedName().toString();
			JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(className + "Builder");
			try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {
				generateBuilderClass(clazz, className, out);
			}
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	private void generateBuilderClass(TypeElement clazz, String className, PrintWriter out) {
		String packageName = determinePackageName(className);
		String builderSimpleName = clazz.getSimpleName() + "Builder";

		if (packageName != null) {
			out.println("package " + packageName + ";");
			out.println();
		}

		out.println("public class " + builderSimpleName + " {");
		out.println("\tprivate " + className + " obj = new " + className + "();");
		out.println();
		generateBuilderMethods(clazz, out, builderSimpleName);
		out.println("\tpublic " + className + " build() {");
		out.println("\t\treturn obj;");
		out.println("\t}");
		out.println("}");
	}

	private void generateBuilderMethods(TypeElement clazz, PrintWriter out, String builderSimpleName) {
		for (ExecutableElement setter : getSetters(clazz)) {
			generateBuilderMethod(out, builderSimpleName, setter);
		}
	}

	private void generateBuilderMethod(PrintWriter out, String builderSimpleName, ExecutableElement setter) {
		String typeName = ((ExecutableType) setter.asType()).getParameterTypes().get(0).toString();
		String variableName = StringUtils.uncapitalize(setter.getSimpleName().toString().substring(3));
		out.println("\tpublic " + builderSimpleName + " " + variableName + "(" + typeName + " " + variableName + ") {");
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

	private List<ExecutableElement> getSetters(TypeElement clazz) {
		List<ExecutableElement> setters = clazz.getEnclosedElements().stream()
				.filter(element -> element instanceof ExecutableElement).map(element -> (ExecutableElement) element)
				.filter(element -> element.getParameters().size() == 1 && element.getTypeParameters().size() == 0)
				.filter(element -> element.getSimpleName().toString().startsWith("set")).collect(Collectors.toList());
		return setters;
	}

}
