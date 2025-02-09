package org.se.lab.marshalling;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CustomMarshaller {

    public String marshal(Object obj) {
        try {
            Document document = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder().newDocument();
            Element element = document.createElement(determineElementName(obj));
            renderElement(obj, document, element);
            document.appendChild(element);
            return convertDocumentToString(document);
        } catch (ParserConfigurationException | IllegalAccessException e) {
            throw new RuntimeException("Error converting object to XML",e);
        }
    }

    public <T> T unmarshal(String xml, Class<T> clazz) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document document = factory.newDocumentBuilder().parse(new java.io.ByteArrayInputStream(xml.getBytes()));
            Element element = document.getDocumentElement();
            return readFromElement(clazz, element);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing XML to Document", e);
        }
    }

    private <T> T readFromElement(Class<T> clazz, Element element) throws InstantiationException, IllegalAccessException {
        T obj = clazz.newInstance();
        for (Field field : getAllFields(clazz)) {
            setFieldValue(field, obj, element);
        }
        return obj;
    }

    private <T> void setFieldValue(Field field, T obj, Element element) throws IllegalAccessException, InstantiationException {
        field.setAccessible(true);
        String elementName = determineElementName(field);
        XmlAttribute attribute = field.getAnnotation(XmlAttribute.class);
        if(attribute != null) {
            setFieldFromAttribute(field, obj, element, elementName);
        } else {
            setFieldFromElement(field, obj, element, elementName);
        }
    }

    private <T> void setFieldFromElement(Field field, T obj, Element element, String elementName) throws IllegalAccessException, InstantiationException {
        Element child = (Element) element.getElementsByTagName(elementName).item(0);
        if(child != null) {
            field.set(obj,readFromElement(field.getType(),child));
        }
    }

    private <T> void setFieldFromAttribute(Field field, T obj, Element element, String elementName) throws IllegalAccessException {
        String value = element.getAttribute(elementName);
        if(!StringUtils.isEmpty(value)) {
            field.set(obj,convertFromString(value, field.getType()));
        }
    }

    private Object convertFromString(String value, Class<?> type) {
        if(type.equals(String.class)) {
            return value;
        } else if(type.equals(Integer.class)||type.equals(int.class)) {
            return Integer.parseInt(value);
        } else if(type.equals(Boolean.class) || type.equals(boolean.class)) {
            return Boolean.parseBoolean(value);
        } else if(type.equals(Double.class) || type.equals(double.class)) {
            return Double.parseDouble(value);
        } else {
            //TODO: complete
            throw new IllegalArgumentException("Unsupported type: "+type);
        }
    }

    private boolean isPrimitiveType(Object obj) {
        return obj instanceof String || obj instanceof Number || obj instanceof Boolean || obj.getClass().isPrimitive();
    }

    private void addFieldToElement(Field field, Element element, Object obj, Document document) throws IllegalAccessException {
        field.setAccessible(true);
        Object value = field.get(obj);
        if(value != null) {
            XmlAttribute attribute = field.getAnnotation(XmlAttribute.class);
            String elementName = determineElementName(field);
            if(attribute != null) {
                element.setAttribute(elementName,value.toString());
            } else {
                Element child = document.createElement(elementName);
                renderElement(value, document, child);
                element.appendChild(child);
            }
        }
    }

    private void renderElement(Object obj, Document document, Element child) throws IllegalAccessException {
        if(isPrimitiveType(obj)) {
            child.setTextContent(obj.toString());
        } else {
            for (Field childField : getAllFields(obj.getClass())) {
                addFieldToElement(childField, child, obj, document);
            }
        }
    }

    private List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>(List.of(clazz.getDeclaredFields()));
        if(clazz.getSuperclass() != null && !clazz.getSuperclass().equals(Object.class)) {
            fields.addAll(getAllFields(clazz.getSuperclass()));
        }
        return fields;
    }

    private String determineElementName(Object obj) {
        XmlRootElement rootAnnotation = obj.getClass().getAnnotation(XmlRootElement.class);
        if(rootAnnotation != null && rootAnnotation.name() != null && !rootAnnotation.name().equals("##default")) {
            return rootAnnotation.name();
        }
        return StringUtils.uncapitalize(obj.getClass().getSimpleName());
    }


    private String determineElementName(Field field) {
        XmlElement elementAnnotation = field.getAnnotation(XmlElement.class);
        if(elementAnnotation != null && elementAnnotation.name() != null&& !elementAnnotation.name().equals("##default")) {
            return elementAnnotation.name();
        }
        XmlAttribute attributeAnnotation = field.getAnnotation(XmlAttribute.class);
        if(attributeAnnotation != null && attributeAnnotation.name() != null && !attributeAnnotation.name().equals("##default")) {
            return attributeAnnotation.name();
        }
        return StringUtils.uncapitalize(field.getName());
    }

    private String convertDocumentToString(Document document) {
        try {
            StringWriter writer = new StringWriter();
            javax.xml.transform.Transformer transformer = javax.xml.transform.TransformerFactory.newDefaultInstance().newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.transform(new javax.xml.transform.dom.DOMSource(document), new javax.xml.transform.stream.StreamResult(writer));
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error converting Document to String", e);
        }
    }
}
