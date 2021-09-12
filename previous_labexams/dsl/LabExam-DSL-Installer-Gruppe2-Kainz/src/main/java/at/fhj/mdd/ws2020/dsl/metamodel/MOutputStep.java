package at.fhj.mdd.ws2020.dsl.metamodel;

public class MOutputStep implements MStep {
	private String header;
	private String text;

	public MOutputStep(String header, String text) {
		super();
		this.header = header;
		this.text = text;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
