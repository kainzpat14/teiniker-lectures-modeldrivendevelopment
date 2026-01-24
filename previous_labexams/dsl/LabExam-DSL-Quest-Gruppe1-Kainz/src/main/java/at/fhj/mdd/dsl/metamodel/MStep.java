package at.fhj.mdd.dsl.metamodel;

public abstract class MStep extends MDescribedElement {
	private boolean optional;

	public MStep(String shortDescription, String description, boolean optional) {
		super(shortDescription, description);
		this.optional = optional;
	}

	public boolean isOptional() {
		return optional;
	}

	public void setOptional(boolean optional) {
		this.optional = optional;
	}

}
