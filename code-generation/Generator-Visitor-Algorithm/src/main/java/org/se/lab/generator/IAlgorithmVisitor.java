package org.se.lab.generator;

import org.se.lab.metamodel.MAlgorithm;
import org.se.lab.metamodel.MConditionalStep;
import org.se.lab.metamodel.MExecuteStep;
import org.se.lab.metamodel.MStep;

public interface IAlgorithmVisitor {
	void visit(MAlgorithm algorithm);

	void visit(MStep step);

	void visit(MConditionalStep step);

	void visit(MExecuteStep step);
}
