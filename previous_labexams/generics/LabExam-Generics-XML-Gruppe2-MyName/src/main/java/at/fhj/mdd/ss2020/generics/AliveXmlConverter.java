package at.fhj.mdd.ss2020.generics;

import org.w3c.dom.Element;

import at.fhj.mdd.ss2020.generics.model.AliveTelegram;

public class AliveXmlConverter extends AbstractXmlConverter {

	public AliveTelegram fromXml(String xml) {
		Element rootNode = parseXml(xml);
		validateTagName(rootNode);
		return readFromElement(rootNode);
	}

	private AliveTelegram readFromElement(Element rootNode) {
		return new AliveTelegram();
	}

	private void validateTagName(Element rootNode) {
		if (!"ALIVE".equals(rootNode.getTagName())) {
			throw new IllegalArgumentException("Invalid root tag name " + rootNode.getTagName());
		}
	}

}
