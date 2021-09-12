package at.fhj.mdd.ss2020.metamodel;

import java.util.List;

public class MCircuit {
	private String name;
	private MCurrentSource output;
	private List<MInput> inputs;

	public MCircuit(String name, MCurrentSource output, List<MInput> inputs) {
		super();
		this.name = name;
		this.output = output;
		this.inputs = inputs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MCurrentSource getOutput() {
		return output;
	}

	public void setOutput(MCurrentSource output) {
		this.output = output;
	}

	public List<MInput> getInputs() {
		return inputs;
	}

	public void setInputs(List<MInput> inputs) {
		this.inputs = inputs;
	}

}
