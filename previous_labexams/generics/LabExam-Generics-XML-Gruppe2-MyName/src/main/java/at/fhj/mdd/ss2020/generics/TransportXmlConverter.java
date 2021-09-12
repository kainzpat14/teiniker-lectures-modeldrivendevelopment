package at.fhj.mdd.ss2020.generics;

import org.w3c.dom.Element;

import at.fhj.mdd.ss2020.generics.model.TransportTelegram;

public class TransportXmlConverter extends AbstractXmlConverter {

	public TransportTelegram fromXml(String xml) {
		Element rootNode = parseXml(xml);
		validateTagName(rootNode);
		return readFromElement(rootNode);
	}

	private TransportTelegram readFromElement(Element rootNode) {
		TransportTelegram obj = new TransportTelegram();
		obj.setBarcode((String) readFromTelegram(rootNode, String.class, "BARCODE"));
		obj.setTargetId((int) readFromTelegram(rootNode, int.class, "TARGET_ID"));
		return obj;
	}

	private void validateTagName(Element rootNode) {
		if (!"TRANSPORT".equals(rootNode.getTagName())) {
			throw new IllegalArgumentException("Invalid root tag name " + rootNode.getTagName());
		}
	}

}
