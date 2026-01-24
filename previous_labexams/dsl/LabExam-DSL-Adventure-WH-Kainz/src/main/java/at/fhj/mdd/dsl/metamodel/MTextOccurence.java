package at.fhj.mdd.dsl.metamodel;

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
