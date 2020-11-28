package org.se.lab;

import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

public abstract class AbstractJavaTypeVisitor implements IJavaTypeVisitor {

	@Override
	public void visitClass(TypeElement type) {
		for (ExecutableElement setter : getSetters(type)) {
			visitSetter(setter);
		}

	}

	@Override
	public void visitSetter(ExecutableElement element) {

	}

	private List<ExecutableElement> getSetters(TypeElement clazz) {
		List<ExecutableElement> setters = clazz.getEnclosedElements().stream()
				.filter(element -> element instanceof ExecutableElement).map(element -> (ExecutableElement) element)
				.filter(element -> element.getParameters().size() == 1 && element.getTypeParameters().size() == 0)
				.filter(element -> element.getSimpleName().toString().startsWith("set")).collect(Collectors.toList());
		return setters;
	}

}
