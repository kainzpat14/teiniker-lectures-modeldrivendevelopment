package at.fhj.mdd.metamodel;

public class MMavenTask implements MBuildTask {
	private String command;

	public MMavenTask(String command) {
		super();
		this.command = command;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

}
