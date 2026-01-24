package at.fhj.mdd.metamodel;

public class MShellTask implements MPreBuildTask, MBuildTask, MPostBuildTask {
	private String command;

	public MShellTask(String command) {
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
