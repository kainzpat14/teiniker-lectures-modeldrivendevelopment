package at.fhj.mdd.ss2020.generics;

import java.lang.reflect.Field;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class GenericXmlConverter<T> extends AbstractXmlConverter {

	public String toXML(T element) {
		Document document = newDocument();
		document.appendChild(toElement(element, document));
		return documentToString(document);
	}

	private Element toElement(T element, Document document) {
		try {
			Element root = document.createElement(ReflectionUtil.getElementName(element.getClass()));
			for (Field field : ReflectionUtil.getTelegramFields(element.getClass())) {
				writeToTelegram(document, root, ReflectionUtil.getElementName(field), field.get(element));
			}
			return root;
		} catch (IllegalAccessException ex) {
			throw new RuntimeException("Unable to convert to element", ex);
		}
	}

}
