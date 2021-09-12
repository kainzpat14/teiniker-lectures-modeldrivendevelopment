package at.fhj.mdd.ws2020.generics;

import java.io.PrintWriter;
import java.io.StringWriter;

import at.fhj.mdd.ws2020.generics.model.ClientSettings;

public class ClientSettingsSerializer {
	public String serialize(ClientSettings settings) {
		StringWriter string = new StringWriter();
		PrintWriter writer = new PrintWriter(string);
		printEntity(writer, "client");
		printAttribute(writer, "serverAddress", settings.getServerAddress());
		printAttribute(writer, "port", settings.getPort());
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
