package org.se.lab.compileTimeMetaprogramming

import static groovyjarjarasm.asm.Opcodes.*
import static org.codehaus.groovy.ast.tools.GeneralUtils.*

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.AnnotationNode
import org.codehaus.groovy.ast.ClassHelper
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation


// Groovy also supports so called compile time transformations, which alter the code at compile time.
// the specifics of the code below are unimportant, but what it does is manipulate the AST of the Groovy
// code to generate the finder methods
@GroovyASTTransformation(phase = CompilePhase.INSTRUCTION_SELECTION)
class FindersTransformation implements ASTTransformation {
	private NO_EXCEPTIONS = ClassNode.EMPTY_ARRAY
	void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {

		if (astNodes?.size() != 2) {
			return
		}
		if (!(astNodes[0] instanceof AnnotationNode))  {
			return
		}
		if (astNodes[0].classNode.name != Finders.name)  {
			return
		}
		if (!(astNodes[1] instanceof ClassNode)) {
			return
		}

		ClassNode targetClass = astNodes[1] as ClassNode
		def findersAnnotation = astNodes[0] as AnnotationNode
		def findersAttributes = findersAnnotation.getMembers()
		def tableName = findersAttributes.get("tableName").getValue()
		def finders = findersAttributes.get("finders")

		for(ConstantExpression finderExpression : finders.expressions) {
			String finder = finderExpression.getValue()
			def methodBlock = generateCodeBlock(tableName, finder)
			addBlockAsMethod(finder, targetClass, methodBlock)
		}
	}

	private addBlockAsMethod(String finder, ClassNode targetClass, org.codehaus.groovy.ast.stmt.BlockStatement methodBlock) {
		def parameters = params(param(ClassHelper.STRING_TYPE, 'value'))
		int visibility = ACC_STATIC | ACC_PUBLIC
		String name = "findBy${finder.capitalize()}"
		ClassNode returnType = ClassHelper.VOID_TYPE
		targetClass.addMethod(name, visibility,
				returnType,parameters, NO_EXCEPTIONS, methodBlock)
	}

	private org.codehaus.groovy.ast.stmt.BlockStatement generateCodeBlock(tableName, String finder) {
		def methodText = "System.out.println(\"SELECT * FROM ${tableName} WHERE $finder = '\$value';\");"
		def methodBlock = block(stmt(new AstBuilder().buildFromString(methodText).get(0).statements[0].expression))
		return methodBlock
	}
}