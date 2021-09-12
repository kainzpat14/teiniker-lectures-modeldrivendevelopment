package at.fhj.mdd.ss2020.generics;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import at.fhj.mdd.ss2020.generics.annotations.FieldMapping;
import at.fhj.mdd.ss2020.generics.annotations.TelegramMapping;

public class ReflectionUtil {

	public static List<Field> getTelegramFields(Object element) {
		return getTelegramFields(element.getClass());
	}

	public static List<Field> getTelegramFields(Class<?> elementClass) {

		List<Field> fieldsWithMapping = Arrays.asList(elementClass.getDeclaredFields()).stream()
				.filter(field -> field.isAnnotationPresent(FieldMapping.class)).collect(Collectors.toList());
		return fieldsWithMapping.stream().map(ReflectionUtil::getAccessibleField).collect(Collectors.toList());
	}

	public static String getElementName(Field field) {
		if (!field.isAnnotationPresent(FieldMapping.class)) {
			throw new IllegalArgumentException("No FieldMapping annotation on " + field);
		}
		return field.getAnnotation(FieldMapping.class).elementName();
	}

	public static String getElementName(Class<?> clazz) {
		if (!clazz.isAnnotationPresent(TelegramMapping.class)) {
			throw new IllegalArgumentException("No TelegramMapping annotation on " + clazz);
		}
		return clazz.getAnnotation(TelegramMapping.class).elementName();
	}

	private static Field getAccessibleField(Field field) {
		field.setAccessible(true);
		return field;
	}
}
