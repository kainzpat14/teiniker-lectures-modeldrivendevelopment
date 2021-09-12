package at.fhj.mdd.ws2020.dsl;

import java.util.ArrayList;
import java.util.List;

import at.fhj.mdd.ws2020.dsl.metamodel.MFunction;
import at.fhj.mdd.ws2020.dsl.metamodel.MPipeline;

public class PipelineBuilder implements IParentBuilder {
	private List<MFunction> functions = new ArrayList<>();
	private FunctionCallBuilder<PipelineBuilder> end = null;

	public FunctionBuilder function(String name) {
		MFunction function = new MFunction(name);
		functions.add(function);
		return new FunctionBuilder(this, function);
	}

	public MFunction getFunctionByName(String function) {
		return functions.stream().filter(fun -> fun.getName().contentEquals(function)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No function with name " + function + " defined"));
	}

	public FunctionCallBuilder<PipelineBuilder> end(String function) {
		end = new FunctionCallBuilder<>(this, getFunctionByName(function));
		return end;
	}

	public MPipeline toPipeline() {
		if (end == null) {
			throw new IllegalArgumentException("No end function defined");
		}
		return new MPipeline(end.toFunctionCall());
	}

}
