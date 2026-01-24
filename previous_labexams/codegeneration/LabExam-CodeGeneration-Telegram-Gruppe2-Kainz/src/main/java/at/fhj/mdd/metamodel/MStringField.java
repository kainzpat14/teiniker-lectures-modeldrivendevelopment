package at.fhj.mdd.metamodel;

public class MStringField extends MField {

	public MStringField(String name, String mapping) {
		super(name, mapping);
	}

	@Override
	protected String getType() {
		return "String";
	}

}
