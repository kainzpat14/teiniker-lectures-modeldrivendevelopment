package at.fhj.mdd.ss2020.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MModel {
	private List<MCircuit> circuits = new ArrayList<>();

	public List<MCircuit> getCircuits() {
		return circuits;
	}

	public void setCircuits(List<MCircuit> circuits) {
		this.circuits = circuits;
	}

}
