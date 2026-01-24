package at.fhj.mdd.generator;

import at.fhj.mdd.dsl.metamodel.MFunction;
import at.fhj.mdd.dsl.metamodel.MFunctionCall;
import at.fhj.mdd.dsl.metamodel.MParameter;
import at.fhj.mdd.dsl.metamodel.MPipeline;

public interface PipelineVisitor {
	void visit(MPipeline pipeline);

	void visit(MFunction function);

	void visit(MParameter parameter);

	void visit(MFunctionCall functionCall);
}
