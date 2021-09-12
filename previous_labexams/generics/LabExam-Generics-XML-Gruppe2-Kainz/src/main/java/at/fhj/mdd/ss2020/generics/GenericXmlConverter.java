package at.fhj.mdd.ss2020.generics;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.w3c.dom.Element;

public abstract class GenericXmlConverter<T> extends AbstractXmlConverter {

	private Class<T> clazz;

	public GenericXmlConverter(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T fromXml(String xml) {
		Element rootNode = parseXml(xml);
		validateTagName(rootNode);
		return readFromElement(rootNode);
	}

	private T readFromElement(Element rootNode) {
		try {
			T obj = clazz.getConstructor().newInstance();
			for (Field field : ReflectionUtil.getTelegramFields(clazz)) {
				field.set(obj, readFromTelegram(rootNode, field.getType(), ReflectionUtil.getElementName(field)));
			}
			return obj;
		} catch (IllegalAccessException | InstantiationException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException ex) {
			throw new RuntimeException("Could not read from element", ex);
		}
	}

	private void validateTagName(Element rootNode) {
		if (!ReflectionUtil.getElementName(clazz).equals(rootNode.getTagName())) {
			throw new IllegalArgumentException("Invalid root tag name " + rootNode.getTagName());
		}
	}
}
