package at.fhj.mdd.ss2020.generics;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import at.fhj.mdd.ss2020.generics.model.AliveTelegram;

public class AliveXmlConverter extends AbstractXmlConverter {

	public AliveXmlConverter() {

	}

	public String toXML(AliveTelegram element) {
		Document document = newDocument();
		document.appendChild(toElement(element, document));
		return documentToString(document);
	}

	private Element toElement(AliveTelegram element, Document document) {
		return document.createElement("ALIVE");
	}

}
