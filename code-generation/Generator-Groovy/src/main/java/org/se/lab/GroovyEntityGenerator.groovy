package org.se.lab

import java.nio.file.Files
import java.nio.file.Path

import org.se.lab.metamodel.MEntity
import org.se.lab.metamodel.MInteger
import org.se.lab.metamodel.MProperty
import org.se.lab.metamodel.MString



class GroovyEntityGenerator {
	def generate(MEntity entity, Path target) {
		Files.writeString(target, generate(entity))
	}

	def generate(MEntity entity) {
		"""
package org.se.lab;

@Entity
@Table(name = "${entity.name.toUpperCase()}")
public class ${entity.name.capitalize()} {
	${entity.properties.collect{ generate(it) }.join("\n")}

	public ${entity.name.capitalize()}(${entity.properties.collect{ generateVariableDeclaration(it) }.join(", ")}) {
		${entity.properties.collect{generateVariableAssignment(it)}.join("\n\t\t")}
	}
}
"""
	}

	def generate(MProperty property) {
		"""
	${property.id?"@Id":""}
	private ${getType(property)} ${property.name.uncapitalize()};

	public void set${property.name.capitalize()}(${generateVariableDeclaration(property)}) {
		${generateVariableAssignment(property)}
	}

	public ${getType(property)} get${property.name.capitalize()}() {
		return ${property.name.uncapitalize()};
	}
"""
	}

	def generateVariableAssignment(MProperty property) {
		"this.${property.name.uncapitalize()} = ${property.name.uncapitalize()};"
	}

	def generateVariableDeclaration(MProperty property) {
		"${getType(property)} ${property.name.uncapitalize()}"
	}

	def getType(MProperty property) {
		if(property.type instanceof MString) {
			return "String"
		} else if(property.type instanceof MInteger) {
			return "int"
		} else {
			throw new IllegalArgumentException("Invalid type "+type.getClass().getName())
		}
	}
}
