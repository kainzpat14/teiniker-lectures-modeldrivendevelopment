package at.fhj.mdd.ws2020.generics;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;

public class SettingsSerializer<E> {
	public String serialize(E settings) {
		StringWriter string = new StringWriter();
		PrintWriter writer = new PrintWriter(string);
		printEntity(writer, ReflectionUtil.getYmlName(settings.getClass()));
		for (Field field : ReflectionUtil.getReadableYmlFields(settings.getClass())) {
			try {
				printAttribute(writer, ReflectionUtil.getYmlName(field), field.get(settings));
			} catch (IllegalAccessException ex) {
				throw new RuntimeException(ex);
			}
		}
		writer.close();
		return string.toString();
	}

	private <T> void printAttribute(PrintWriter writer, String name, T value) {
		writer.print(" - ");
		writer.print(name);
		writer.print(": ");
		writer.println(value);
	}

	private void printEntity(PrintWriter writer, String name) {
		writer.print(name);
		writer.println(":");
	}

}
