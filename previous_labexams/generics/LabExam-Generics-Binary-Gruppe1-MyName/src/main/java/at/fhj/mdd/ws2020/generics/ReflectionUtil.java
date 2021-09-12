package at.fhj.mdd.ws2020.generics;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReflectionUtil {

	public static int getMessageSize(Class<?> clazz) {
		// TODO: Check if class has MessageBinaryMapping annotation and return its
		// totalSize
	}

	public static List<Field> getReadableSortedFields(Class<?> clazz) {
		List<Field> readableFields = new ArrayList<>();
		// TODO: get all fields with a FieldBinaryMapping attribute and fix any
		// visibility related errors
		readableFields.sort(Comparator.comparing(ReflectionUtil::getOffset));
		return readableFields;
	}

	public static int getOffset(Field field) {
		// TODO: return offset in FieldBinaryMapping
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
