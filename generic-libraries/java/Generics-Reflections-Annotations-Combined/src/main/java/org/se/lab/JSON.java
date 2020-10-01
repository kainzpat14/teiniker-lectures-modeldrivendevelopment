package org.se.lab;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.se.lab.annotation.JsonSequence;

public class JSON {
	public static <T> String stringify(T obj) {
		// null -> null
		if (obj == null) {
			return "null";
		}
		// boolean -> true, false
		else if (obj instanceof Boolean) {
			return obj.toString();
		}
		// number, string -> "1" "abc"
		else if (obj instanceof Number || obj instanceof String) {
			return "\"" + obj.toString() + "\"";
		}
		// ["1","2"]
		else if (obj instanceof Collection) {
			Collection<?> list = (Collection<?>) obj;
			return "[" + list.stream().map(JSON::stringify).collect(Collectors.joining(",")) + "]";
		}
		// { "name" : "abc", "name2" : "def" }
		else {
			return "{" + stringifyObject(obj) + "}";

		}
	}

	private static <T> String stringifyObject(T obj) {
		return Arrays.stream(obj.getClass().getDeclaredFields())
				.sorted(Comparator.comparing(JSON::getFieldSequence)).map(field -> stringifyField(field, obj))
				.collect(Collectors.joining(","));
	}

	private static int getFieldSequence(Field field) {
		JsonSequence sequence = field.getAnnotation(JsonSequence.class);
		if (sequence == null) {
			return Integer.MAX_VALUE;
		}
		return sequence.sequence();
	}

	private static <T> String stringifyField(Field field, T obj) {
		try {
			field.setAccessible(true);
			return "\"" + field.getName() + "\" : " + stringify(field.get(obj));
		} catch (IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}
	}
}
