package at.fhj.mdd.ss2020.generics;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import at.fhj.mdd.ss2020.generics.model.TransportTelegram;

public class TransportXmlConverter extends AbstractXmlConverter {

	public TransportXmlConverter() {
	}

	public String toXML(TransportTelegram element) {
		Document document = newDocument();
		document.appendChild(toElement(element, document));
		return documentToString(document);
	}

	private Element toElement(TransportTelegram element, Document document) {
		Element root = document.createElement("TRANSPORT");
		writeToTelegram(document, root, "BARCODE", element.getBarcode());
		writeToTelegram(document, root, "TARGET_ID", element.getTargetId());
		return root;
	}

}
