package at.fhj.mdd.ws2020.dsl;

import at.fhj.mdd.ws2020.dsl.metamodel.MStep;

public class SingleStepBuilder<T> extends GeneralStepBuilder<T> {

	private MStep step;
	private T delegate;

	public SingleStepBuilder(T delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	protected void addStep(MStep step) {
		if (this.step != null) {
			throw new UnsupportedOperationException("Step is already defined");
		}
		this.step = step;
	}

	public MStep getStep() {
		return step;
	}

	@Override
	protected T getObject() {
		return delegate;
	}

}
