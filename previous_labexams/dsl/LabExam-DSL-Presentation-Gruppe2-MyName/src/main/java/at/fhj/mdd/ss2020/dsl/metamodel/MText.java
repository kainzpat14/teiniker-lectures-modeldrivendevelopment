package at.fhj.mdd.ss2020.dsl.metamodel;

public abstract class MText {
	private String text;

	public MText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
