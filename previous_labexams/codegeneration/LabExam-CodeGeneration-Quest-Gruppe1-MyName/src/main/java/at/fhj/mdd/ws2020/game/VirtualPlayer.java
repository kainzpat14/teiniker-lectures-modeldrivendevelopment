package at.fhj.mdd.ws2020.game;

import java.io.PrintWriter;
import java.io.StringWriter;

public class VirtualPlayer implements Player {
	private StringWriter outputString = new StringWriter();
	private PrintWriter output = new PrintWriter(outputString);

	public String getOutput() {
		return outputString.toString();
	}

	@Override
	public void logStep(String shortDescription, String description) {
		output.println("Performing step " + shortDescription);
	}

	@Override
	public void gather(String entity, int count) {
		output.println("Gathering " + count + " of " + entity);
	}

	@Override
	public void kill(String entity, int count) {
		output.println("Killing " + count + " of " + entity);
	}

	@Override
	public void protect(String entity, int count) {
		output.println("Protecting " + count + " of " + entity);
	}

	@Override
	public void startQuest(String shortDescription, String description) {
		output.println("Starting Quest " + shortDescription);
	}

	@Override
	public void endQuest(String shortDescription) {
		output.println("Quest " + shortDescription + " finished");
	}
}
