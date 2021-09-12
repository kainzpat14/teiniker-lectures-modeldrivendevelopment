package at.fhj.mdd.ws2020.generator;

import at.fhj.mdd.ws2020.dsl.metamodel.MFunction;
import at.fhj.mdd.ws2020.dsl.metamodel.MFunctionCall;
import at.fhj.mdd.ws2020.dsl.metamodel.MParameter;
import at.fhj.mdd.ws2020.dsl.metamodel.MPipeline;

public abstract class AbstractPipelineVisitor implements PipelineVisitor {

	@Override
	public void visit(MPipeline pipeline) {
		visit(pipeline.getEnd());
	}

	@Override
	public void visit(MFunction function) {
		for (MParameter parameter : function.getParameters()) {
			visit(parameter);
		}
	}

	@Override
	public void visit(MParameter parameter) {
		// nothing to do
	}

	@Override
	public void visit(MFunctionCall functionCall) {

		visit(functionCall.getFunction());

		for (MFunctionCall input : functionCall.getInputs()) {
			visit(input);
		}
	}

}
