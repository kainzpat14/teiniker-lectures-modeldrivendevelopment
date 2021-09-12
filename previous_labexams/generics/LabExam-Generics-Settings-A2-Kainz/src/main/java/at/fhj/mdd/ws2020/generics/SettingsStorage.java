package at.fhj.mdd.ws2020.generics;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;

public class SettingsStorage<E> {
	public String serialize(E settings) {
		StringWriter string = new StringWriter();
		PrintWriter writer = new PrintWriter(string);
		printObject(writer, ReflectionUtil.getObjectName(settings.getClass()));
		for (Field field : ReflectionUtil.getReadableSettingFields(settings.getClass())) {
			try {
				printSetting(writer, ReflectionUtil.getSettingKey(field), field.get(settings));
			} catch (IllegalAccessException ex) {
				throw new RuntimeException(ex);
			}
		}
		writer.close();
		return string.toString();
	}

	private <T> void printSetting(PrintWriter writer, String key, T value) {
		writer.print(key);
		writer.print("=");
		writer.println(value);
	}

	private void printObject(PrintWriter writer, String name) {
		writer.println("[" + name + "]");
	}

}
