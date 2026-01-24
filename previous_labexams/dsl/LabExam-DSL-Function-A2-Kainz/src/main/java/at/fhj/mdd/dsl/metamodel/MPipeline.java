package at.fhj.mdd.dsl.metamodel;

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
