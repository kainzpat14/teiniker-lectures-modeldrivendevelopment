package org.se.lab

import org.junit.Test

class TestXMLDsl {
	@Test
	fun testXmlDSL() {
		var document = xml("students") {
			element("student") {
				attribute("matnr","0815")
				attribute("firstname","Patrick")
				attribute("lastname","Kainz")
				element("lectures") {
					element("lecture") {
						attribute("name","MDD")
						attribute("grade","5")
					}
				}
			}
		}
		
		println(ModelToObjectDiagram().toDiagram(document));
	}
} 