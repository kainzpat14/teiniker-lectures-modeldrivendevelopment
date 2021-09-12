package at.fhj.mdd.ws2020.generics;

import java.io.PrintWriter;
import java.io.StringWriter;

import at.fhj.mdd.ws2020.generics.model.ConnectionSettings;

public class ConnectionSettingsStorage {
	public String serialize(ConnectionSettings settings) {
		StringWriter string = new StringWriter();
		PrintWriter writer = new PrintWriter(string);
		printObject(writer, "connection");
		printSetting(writer, "serverAddress", settings.getServerAddress());
		printSetting(writer, "port", settings.getPort());
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
