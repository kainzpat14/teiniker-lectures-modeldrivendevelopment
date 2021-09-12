package at.fhj.mdd.ws2020.generics;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import at.fhj.mdd.ws2020.generics.annotations.YmlAttribute;
import at.fhj.mdd.ws2020.generics.annotations.YmlEntity;

public class ReflectionUtil {

	public static String getYmlName(Class<?> clazz) {
		if (clazz.isAnnotationPresent(YmlEntity.class)) {
			return clazz.getAnnotation(YmlEntity.class).name();
		}
		throw new IllegalArgumentException("Class has no YmlEntity annotation");
	}

	public static List<Field> getReadableYmlFields(Class<?> clazz) {
		List<Field> readableFields = new ArrayList<>();
		for (Field field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(YmlAttribute.class)) {
				field.setAccessible(true);
				readableFields.add(field);
			}
		}
		return readableFields;
	}

	public static String getYmlName(Field field) {
		if (field.isAnnotationPresent(YmlAttribute.class)) {
			return field.getAnnotation(YmlAttribute.class).name();
		}
		throw new IllegalArgumentException("Class has no YmlAttribute annotation");
	}

}
