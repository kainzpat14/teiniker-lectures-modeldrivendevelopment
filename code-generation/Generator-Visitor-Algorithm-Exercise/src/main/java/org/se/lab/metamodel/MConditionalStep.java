package org.se.lab.metamodel;

public class MConditionalStep extends MStep {

	private MStep trueStep;
	private MStep falseStep;

	public MConditionalStep(String methodName) {
		super(methodName);
	}

	public MStep getTrueStep() {
		return trueStep;
	}

	public void setTrueStep(MStep trueStep) {
		this.trueStep = trueStep;
	}

	public MStep getFalseStep() {
		return falseStep;
	}

	public void setFalseStep(MStep falseStep) {
		this.falseStep = falseStep;
	}

}
