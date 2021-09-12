package at.fhj.mdd.ss2020.metamodel;

public abstract class MMappedElement extends MNamedElement {
	private String mapping;

	public MMappedElement(String name, String mapping) {
		super(name);
		this.mapping = mapping;
	}

	public String getMapping() {
		return mapping;
	}

	public void setMapping(String mapping) {
		this.mapping = mapping;
	}

}
