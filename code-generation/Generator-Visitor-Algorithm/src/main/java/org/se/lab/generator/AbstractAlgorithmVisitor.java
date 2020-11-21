package org.se.lab.generator;

import org.se.lab.metamodel.MAlgorithm;
import org.se.lab.metamodel.MConditionalStep;
import org.se.lab.metamodel.MExecuteStep;
import org.se.lab.metamodel.MStep;

public class AbstractAlgorithmVisitor implements IAlgorithmVisitor {

	@Override
	public void visit(MAlgorithm algorithm) {
		visit(algorithm.getFirstStep());
	}

	@Override
	public void visit(MStep step) {
		if (step != null) {
			if (step instanceof MConditionalStep) {
				visit((MConditionalStep) step);
			} else if (step instanceof MExecuteStep) {
				visit((MExecuteStep) step);
			} else {
				throw new IllegalArgumentException("Invalid step class " + step.getClass().getName());
			}
		}
	}

	@Override
	public void visit(MConditionalStep step) {
		visit(step.getTrueStep());
		visit(step.getFalseStep());
	}

	@Override
	public void visit(MExecuteStep step) {
		visit(step.getNextStep());
	}

}
