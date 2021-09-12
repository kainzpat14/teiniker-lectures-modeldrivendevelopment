package at.fhj.mdd.ws2020.dsl;

import java.util.ArrayList;
import java.util.List;

import at.fhj.mdd.ws2020.dsl.metamodel.MFunction;
import at.fhj.mdd.ws2020.dsl.metamodel.MFunctionCall;

public class FunctionCallBuilder<T extends IParentBuilder> implements IParentBuilder {
	private MFunctionCall call;
	private T parent;
	private List<FunctionCallBuilder<?>> inputs = new ArrayList<>();

	public FunctionCallBuilder(T parent, MFunction function) {
		super();
		this.call = new MFunctionCall(function);
		this.parent = parent;
	}

	public T done() {
		return parent;
	}

	public FunctionCallBuilder<FunctionCallBuilder<T>> input(String function) {
		FunctionCallBuilder<FunctionCallBuilder<T>> input = new FunctionCallBuilder<>(this,
				getFunctionByName(function));
		inputs.add(input);
		return input;
	}

	public MFunctionCall toFunctionCall() {
		if (inputs.size() != call.getFunction().getParameters().size()) {
			throw new IllegalArgumentException("Invalid number of inputs for function " + call.getFunction().getName());
		}
		for (FunctionCallBuilder<?> input : inputs) {
			call.getInputs().add(input.toFunctionCall());
		}
		return call;
	}

	@Override
	public MFunction getFunctionByName(String name) {
		return parent.getFunctionByName(name);
	}

}
