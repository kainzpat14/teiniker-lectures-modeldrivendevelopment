package at.fhj.mdd.ss2020.metamodel;

import java.util.List;

public class MCircuitReuse implements MCurrentSource {
	private MCircuit circuit;
	private List<MCurrentSource> inputs;

	public MCircuitReuse(MCircuit circuit, List<MCurrentSource> inputs) {
		super();
		this.circuit = circuit;
		this.inputs = inputs;
	}

	public MCircuit getCircuit() {
		return circuit;
	}

	public void setCircuit(MCircuit circuit) {
		this.circuit = circuit;
	}

	public List<MCurrentSource> getInputs() {
		return inputs;
	}

	public void setInputs(List<MCurrentSource> inputs) {
		this.inputs = inputs;
	}

}
