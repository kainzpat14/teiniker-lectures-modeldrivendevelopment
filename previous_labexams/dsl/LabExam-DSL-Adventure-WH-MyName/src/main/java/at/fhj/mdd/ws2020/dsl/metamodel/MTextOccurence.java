package at.fhj.mdd.ws2020.dsl.metamodel;

public class MTextOccurence implements MOccurence {
	private String text;

	public MTextOccurence(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
