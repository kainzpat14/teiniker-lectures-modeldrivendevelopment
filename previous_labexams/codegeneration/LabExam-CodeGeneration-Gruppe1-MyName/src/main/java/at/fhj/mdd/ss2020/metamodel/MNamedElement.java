package at.fhj.mdd.ss2020.metamodel;

public abstract class MNamedElement {
	private String name;

	public MNamedElement(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
