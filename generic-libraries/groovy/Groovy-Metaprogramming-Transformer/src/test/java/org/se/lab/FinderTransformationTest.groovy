package org.se.lab

import org.junit.Test

class FinderTransformationTest {
	@Test
	public void testFinderTransformation() {
		def tester = new GroovyClassLoader().parseClass('''
		@org.se.lab.compileTimeMetaprogramming.Finders(tableName="CAR", finders=["make", "model"])
		class Car {
		}
		''')
	}
}
