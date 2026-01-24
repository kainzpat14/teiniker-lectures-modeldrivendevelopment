package at.fhj.mdd.metamodel;

public class MIntField extends MField {

	public MIntField(String name, String mapping) {
		super(name, mapping);
	}

	@Override
	protected String getType() {
		return "int";
	}

}
