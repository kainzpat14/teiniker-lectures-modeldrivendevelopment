package at.fhj.mdd.metamodel;

public class MNot implements MCurrentSource {

	private MCurrentSource source;

	public MNot(MCurrentSource source) {
		super();
		this.source = source;
	}

	public MCurrentSource getSource() {
		return source;
	}

	public void setSource(MCurrentSource source) {
		this.source = source;
	}

}
