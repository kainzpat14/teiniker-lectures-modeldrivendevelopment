package org.se.lab

import java.util.ArrayList
import java.util.HashMap

@DslMarker
annotation class XMLDSLMarker

@XMLDSLMarker
class XMLDslElement(var name : String) {
	var children = ArrayList<XMLDslElement>();
	var attributes = HashMap<String,String>();
	
	fun element(name : String, init: XMLDslElement.() -> Unit): XMLDslElement {
		val child = XMLDslElement(name);
		child.init();
		children.add(child);
		return child;
	}
	
	fun attribute(name : String, value : String) : XMLDslElement {
		attributes.put(name,value);
		return this;
	}
	
	fun toNode() : MNode {
		var node = MNode(name);
		node.children = children.map { it.toNode() }
		node.attributes = attributes.entries.map { MAttribute(it.key, it.value)};
		return node;
	}
}


fun xml(name : String, init: XMLDslElement.() -> Unit) : MDocument {
	var rootElement = XMLDslElement(name);
	rootElement.init();
	return MDocument(rootElement.toNode());
}
