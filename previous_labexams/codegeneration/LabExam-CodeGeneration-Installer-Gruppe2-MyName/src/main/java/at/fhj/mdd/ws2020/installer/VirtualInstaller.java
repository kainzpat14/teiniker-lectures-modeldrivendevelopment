package at.fhj.mdd.ws2020.installer;

import java.io.PrintWriter;
import java.io.StringWriter;

public class VirtualInstaller implements Installer {
	private StringWriter outputString = new StringWriter();
	private PrintWriter output = new PrintWriter(outputString);

	@Override
	public boolean output(String header, String text) {
		output.println(header);
		output.println(text);
		return true;
	}

	@Override
	public boolean execute(String command) {
		output.println("#>" + command);
		return true;
	}

	@Override
	public boolean mkdir(String directory) {
		output.println("#mkdir " + directory);
		return true;
	}

	@Override
	public boolean copy(String source, String destination) {
		output.println("#copy " + source + " " + destination);
		return true;
	}

	public String getOutput() {
		return outputString.toString();
	}

}
