package at.fhj.mdd.ws2020.generator;

import at.fhj.mdd.ws2020.dsl.metamodel.MFunction;
import at.fhj.mdd.ws2020.dsl.metamodel.MFunctionCall;
import at.fhj.mdd.ws2020.dsl.metamodel.MParameter;
import at.fhj.mdd.ws2020.dsl.metamodel.MPipeline;

public interface PipelineVisitor {
	void visit(MPipeline pipeline);

	void visit(MFunction function);

	void visit(MParameter parameter);

	void visit(MFunctionCall functionCall);
}
