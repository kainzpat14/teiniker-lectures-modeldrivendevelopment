package at.fhj.mdd.ws2020.generics;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import at.fhj.mdd.ws2020.generics.annotations.Setting;
import at.fhj.mdd.ws2020.generics.annotations.SettingObject;

public class ReflectionUtil {

	public static String getObjectName(Class<?> clazz) {
		if (clazz.isAnnotationPresent(SettingObject.class)) {
			return clazz.getAnnotation(SettingObject.class).name();
		}
		throw new IllegalArgumentException("Class has no SettingObject annotation");
	}

	public static List<Field> getReadableSettingFields(Class<?> clazz) {
		List<Field> readableFields = new ArrayList<>();
		for (Field field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(Setting.class)) {
				field.setAccessible(true);
				readableFields.add(field);
			}
		}
		return readableFields;
	}

	public static String getSettingKey(Field field) {
		if (field.isAnnotationPresent(Setting.class)) {
			return field.getAnnotation(Setting.class).key();
		}
		throw new IllegalArgumentException("Class has no Setting annotation");
	}

}
