package org.se.lab.metamodel;

public class MExecuteStep extends MStep {

	private MStep nextStep;

	public MExecuteStep(String methodName) {
		super(methodName);
	}

	public MStep getNextStep() {
		return nextStep;
	}

	public void setNextStep(MStep nextStep) {
		this.nextStep = nextStep;
	}

}
