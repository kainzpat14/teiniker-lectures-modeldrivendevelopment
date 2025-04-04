package at.fhj.mdd.ws2020.dsl.metamodel;

public class MShellStep implements MStep {
	private String script;

	public MShellStep(String script) {
		super();
		this.script = script;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

}
