package at.fhj.mdd.generator;

import at.fhj.mdd.metamodel.MAnd;
import at.fhj.mdd.metamodel.MCircuit;
import at.fhj.mdd.metamodel.MCircuitReuse;
import at.fhj.mdd.metamodel.MCurrentSource;
import at.fhj.mdd.metamodel.MInput;
import at.fhj.mdd.metamodel.MModel;
import at.fhj.mdd.metamodel.MNot;
import at.fhj.mdd.metamodel.MOr;

public interface ModelVisitor {
	void visit(MModel model);

	void visit(MCircuit circuit);

	void visit(MCurrentSource source);

	void visit(MInput input);

	void visit(MNot not);

	void visit(MAnd and);

	void visit(MOr or);

	void visit(MCircuitReuse reuse);
}
