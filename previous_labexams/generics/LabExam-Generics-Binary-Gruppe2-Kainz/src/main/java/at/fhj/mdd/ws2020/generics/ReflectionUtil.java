package at.fhj.mdd.ws2020.generics;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import at.fhj.mdd.ws2020.generics.annotations.FieldBinaryMapping;
import at.fhj.mdd.ws2020.generics.annotations.MessageBinaryMapping;

public class ReflectionUtil {

	public static int getMessageSize(Class<?> clazz) {
		MessageBinaryMapping mapping = clazz.getAnnotation(MessageBinaryMapping.class);
		if (mapping == null) {
			throw new IllegalArgumentException("No MessageBinaryMapping annotation present on " + clazz.getName());
		}
		return mapping.totalSize();
	}

	public static List<Field> getReadableSortedFields(Class<?> clazz) {
		List<Field> readableFields = new ArrayList<>();
		for (Field field : clazz.getDeclaredFields()) {
			if (field.getAnnotation(FieldBinaryMapping.class) != null) {
				field.setAccessible(true);
				readableFields.add(field);
			}
		}
		readableFields.sort(Comparator.comparing(ReflectionUtil::getOffset));
		return readableFields;
	}

	public static int getOffset(Field field) {
		return field.getAnnotation(FieldBinaryMapping.class).offset();
	}

	public static SerializationType getType(Field field) {
		if (Integer.class.isAssignableFrom(field.getType()) || int.class.isAssignableFrom(field.getType())) {
			return SerializationType.INT;
		} else if (Long.class.isAssignableFrom(field.getType()) || long.class.isAssignableFrom(field.getType())) {
			return SerializationType.LONG;
		} else if (Float.class.isAssignableFrom(field.getType()) || float.class.isAssignableFrom(field.getType())) {
			return SerializationType.FLOAT;
		} else if (Double.class.isAssignableFrom(field.getType()) || double.class.isAssignableFrom(field.getType())) {
			return SerializationType.DOUBLE;
		} else if (String.class.isAssignableFrom(field.getType())) {
			return SerializationType.STRING;
		} else {
			throw new UnsupportedOperationException("Unsupported field type: " + field.getType().getName());
		}
	}

}
