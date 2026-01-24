package at.fhj.mdd.dsl;

import at.fhj.mdd.dsl.metamodel.MFunction;
import at.fhj.mdd.dsl.metamodel.MParameter;
import at.fhj.mdd.dsl.metamodel.MPipeline;

public class FunctionBuilder {
	private MFunction function;
	private PipelineBuilder parent;

	public FunctionBuilder(PipelineBuilder parent, MFunction function) {
		super();
		this.function = function;
		this.parent = parent;
	}

	public FunctionBuilder parameter(String name) {
		function.getParameters().add(new MParameter(name));
		return this;
	}

	public FunctionBuilder function(String name) {
		return parent.function(name);
	}

	public MPipeline toPipeline() {
		return parent.toPipeline();
	}

	public FunctionCallBuilder<PipelineBuilder> end(String function) {
		return parent.end(function);
	}

}
