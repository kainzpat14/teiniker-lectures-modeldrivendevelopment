package at.fhj.mdd.ws2020.dsl.metamodel;

public abstract class MDescribedElement {
	private String shortDescription;
	private String description;

	public MDescribedElement(String shortDescription, String description) {
		super();
		this.shortDescription = shortDescription;
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
