package at.fhj.mdd.ss2020.metamodel;

public abstract class MBinaryOperation implements MCurrentSource {
	private MCurrentSource source1;
	private MCurrentSource source2;

	public MBinaryOperation(MCurrentSource source1, MCurrentSource source2) {
		super();
		this.source1 = source1;
		this.source2 = source2;
	}

	public MCurrentSource getSource1() {
		return source1;
	}

	public void setSource1(MCurrentSource source1) {
		this.source1 = source1;
	}

	public MCurrentSource getSource2() {
		return source2;
	}

	public void setSource2(MCurrentSource source2) {
		this.source2 = source2;
	}

}
