package at.fhj.mdd.ss2020.metamodel;

public class MIntField extends MField {

	public MIntField(String name, String mapping) {
		super(name, mapping);
	}

	@Override
	protected String getType() {
		return "int";
	}

}
