package org.se.lab.metamodel;

public class MAlgorithm {
	private MStep firstStep;

	public MAlgorithm(MStep firstStep) {
		this.firstStep = firstStep;
	}

	public MStep getFirstStep() {
		return firstStep;
	}

	public void setFirstStep(MStep firstStep) {
		this.firstStep = firstStep;
	}

}
