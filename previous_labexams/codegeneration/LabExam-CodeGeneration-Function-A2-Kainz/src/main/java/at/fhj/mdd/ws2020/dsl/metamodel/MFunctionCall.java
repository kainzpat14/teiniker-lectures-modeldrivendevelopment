package at.fhj.mdd.ws2020.dsl.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MFunctionCall {
	private MFunction function;

	private List<MFunctionCall> inputs = new ArrayList<>();

	public MFunctionCall(MFunction function) {
		super();
		this.function = function;
	}

	public MFunction getFunction() {
		return function;
	}

	public void setFunction(MFunction function) {
		this.function = function;
	}

	public List<MFunctionCall> getInputs() {
		return inputs;
	}

	public void setInputs(List<MFunctionCall> inputs) {
		this.inputs = inputs;
	}

}
