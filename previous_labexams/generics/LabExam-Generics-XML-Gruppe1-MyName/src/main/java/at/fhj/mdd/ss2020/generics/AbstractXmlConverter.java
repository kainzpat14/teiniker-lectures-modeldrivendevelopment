package at.fhj.mdd.ss2020.generics;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public abstract class AbstractXmlConverter {
	protected String documentToString(Document document) {
		try {
			StringWriter writer = new StringWriter();
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(writer);
			transformer.transform(domSource, streamResult);

			return writer.toString();
		} catch (TransformerFactoryConfigurationError | TransformerException ex) {
			throw new RuntimeException("Error converting document to string", ex);
		}
	}

	protected Element parseXml(String xml) {
		try {
			DocumentBuilder builder = createDocumentBuilder();
			Document document = builder.parse(new ByteArrayInputStream(xml.getBytes()));
			return (Element) document.getFirstChild();
		} catch (SAXException | IOException ex) {
			throw new RuntimeException("Error parsing document", ex);
		}
	}

	protected Document newDocument() {
		DocumentBuilder builder = createDocumentBuilder();
		return builder.newDocument();
	}

	protected Object readFromTelegram(Element rootNode, Class<?> type, String telegramName) {
		String text = getNodeText(rootNode, telegramName);
		if (String.class.isAssignableFrom(type)) {
			return text;
		} else if (int.class.isAssignableFrom(type)) {
			return Integer.parseInt(text);
		} else {
			throw new IllegalArgumentException("Unssuported type " + type);
		}
	}

	protected String getNodeText(Element rootNode, String telegramName) {
		for (int i = 0; i < rootNode.getChildNodes().getLength(); i++) {
			Node node = rootNode.getChildNodes().item(i);
			if (node instanceof Element) {
				Element element = (Element) node;
				if (element.getTagName().equals(telegramName)) {
					if (!(element.getFirstChild() instanceof Text)) {
						throw new IllegalArgumentException("Expected text inside node " + element.getTagName());
					}
					return ((Text) element.getFirstChild()).getData();
				}
			}
		}
		throw new IllegalArgumentException("Did not find node with name " + telegramName);
	}

	protected void writeToTelegram(Document document, Element root, String elementName, Object value) {
		Element attribute = document.createElement(elementName);
		attribute.appendChild(document.createTextNode(value.toString()));
		root.appendChild(attribute);

	}

	private DocumentBuilder createDocumentBuilder() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			return factory.newDocumentBuilder();
		} catch (ParserConfigurationException ex) {
			throw new RuntimeException("Error creating document builder", ex);
		}
	}
}
