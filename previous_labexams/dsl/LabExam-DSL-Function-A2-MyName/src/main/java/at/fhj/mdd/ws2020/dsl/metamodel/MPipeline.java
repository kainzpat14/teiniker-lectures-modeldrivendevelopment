package at.fhj.mdd.ws2020.dsl.metamodel;

public class MPipeline {
	private MFunctionCall end;

	public MPipeline(MFunctionCall end) {
		super();
		this.end = end;
	}

	public MFunctionCall getEnd() {
		return end;
	}

	public void setEnd(MFunctionCall end) {
		this.end = end;
	}

}
