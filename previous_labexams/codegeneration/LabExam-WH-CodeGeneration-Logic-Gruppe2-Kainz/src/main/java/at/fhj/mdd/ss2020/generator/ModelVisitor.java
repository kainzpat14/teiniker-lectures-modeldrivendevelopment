package at.fhj.mdd.ss2020.generator;

import at.fhj.mdd.ss2020.metamodel.MAnd;
import at.fhj.mdd.ss2020.metamodel.MCircuit;
import at.fhj.mdd.ss2020.metamodel.MCircuitReuse;
import at.fhj.mdd.ss2020.metamodel.MCurrentSource;
import at.fhj.mdd.ss2020.metamodel.MInput;
import at.fhj.mdd.ss2020.metamodel.MModel;
import at.fhj.mdd.ss2020.metamodel.MNot;
import at.fhj.mdd.ss2020.metamodel.MOr;

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
