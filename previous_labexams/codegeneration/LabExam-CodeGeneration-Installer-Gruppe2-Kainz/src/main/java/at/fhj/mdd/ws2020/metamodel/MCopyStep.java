package at.fhj.mdd.ws2020.metamodel;

public class MCopyStep implements MStep {
	private String source;
	private String destination;

	public MCopyStep(String source, String destination) {
		super();
		this.source = source;
		this.destination = destination;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
