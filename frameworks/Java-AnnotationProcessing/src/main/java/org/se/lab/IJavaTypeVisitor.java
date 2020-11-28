package org.se.lab;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

public interface IJavaTypeVisitor {
	void visitClass(TypeElement type);

	void visitSetter(ExecutableElement element);
}
