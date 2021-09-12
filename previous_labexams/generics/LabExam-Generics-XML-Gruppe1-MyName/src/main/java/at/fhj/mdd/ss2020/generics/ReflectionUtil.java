package at.fhj.mdd.ss2020.generics;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionUtil {

	public static List<Field> getTelegramFields(Object element) {
		return getTelegramFields(element.getClass());
	}

	public static List<Field> getTelegramFields(Class<?> elementClass) {

		List<Field> fieldsWithMapping = null;
		// TODO: Implement
		return fieldsWithMapping.stream().map(ReflectionUtil::getAccessibleField).collect(Collectors.toList());
	}

	public static String getElementName(Field field) {
		// TODO: Implement
		return null;
	}

	public static String getElementName(Class<?> clazz) {
		// TODO: Implement
		return null;
	}

	private static Field getAccessibleField(Field field) {
		field.setAccessible(true);
		return field;
	}
}
