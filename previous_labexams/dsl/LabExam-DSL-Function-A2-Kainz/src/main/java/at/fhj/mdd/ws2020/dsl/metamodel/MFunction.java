package at.fhj.mdd.ws2020.dsl.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MFunction extends MNamedElement {

	private List<MParameter> parameters = new ArrayList<>();

	public MFunction(String name) {
		super(name);
	}

	public List<MParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<MParameter> parameters) {
		this.parameters = parameters;
	}

}
