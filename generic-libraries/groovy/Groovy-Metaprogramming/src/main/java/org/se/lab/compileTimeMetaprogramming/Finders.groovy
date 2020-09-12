package org.se.lab.compileTimeMetaprogramming

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

import org.codehaus.groovy.transform.GroovyASTTransformationClass

@Retention(RetentionPolicy.SOURCE)
@Target([ElementType.TYPE])
@GroovyASTTransformationClass(classes = [org.se.lab.compileTimeMetaprogramming.FindersTransformation])
@interface Finders {
	public String tableName()
	public String[] finders()
}
