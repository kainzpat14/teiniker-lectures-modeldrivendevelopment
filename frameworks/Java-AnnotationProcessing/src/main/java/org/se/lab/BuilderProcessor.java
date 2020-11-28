package org.se.lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

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
			String clazzName = clazz.getQualifiedName().toString();
			JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(clazzName + "Builder");
			try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {
				new BuilderGeneratorJavaTypeVisitor(out).visitClass(clazz);
			}
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

}
