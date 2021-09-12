package at.fhj.mdd.ss2020.generator;

import at.fhj.mdd.ss2020.metamodel.MAnd;
import at.fhj.mdd.ss2020.metamodel.MCircuit;
import at.fhj.mdd.ss2020.metamodel.MCircuitReuse;
import at.fhj.mdd.ss2020.metamodel.MCurrentSource;
import at.fhj.mdd.ss2020.metamodel.MInput;
import at.fhj.mdd.ss2020.metamodel.MModel;
import at.fhj.mdd.ss2020.metamodel.MNot;
import at.fhj.mdd.ss2020.metamodel.MOr;

public class AbstractModelVisitor implements ModelVisitor {
	// TODO: Implement start
	@Override
	public void visit(MModel model) {
		for (MCircuit circuit : model.getCircuits()) {
			visit(circuit);
		}
	}

	@Override
	public void visit(MCircuit circuit) {
		visit(circuit.getOutput());
	}

	@Override
	public void visit(MCurrentSource source) {
		if (source instanceof MInput) {
			visit((MInput) source);
		} else if (source instanceof MNot) {
			visit((MNot) source);
		} else if (source instanceof MAnd) {
			visit((MAnd) source);
		} else if (source instanceof MOr) {
			visit((MOr) source);
		} else if (source instanceof MCircuitReuse) {
			visit((MCircuitReuse) source);
		} else {
			throw new UnsupportedOperationException("Unsupported source type " + source.getClass().getName());
		}
	}

	@Override
	public void visit(MInput input) {

	}

	@Override
	public void visit(MNot not) {
		visit(not.getSource());
	}

	@Override
	public void visit(MAnd and) {
		visit(and.getSource1());
		visit(and.getSource2());
	}

	@Override
	public void visit(MOr or) {
		visit(or.getSource1());
		visit(or.getSource2());
	}

	@Override
	public void visit(MCircuitReuse reuse) {

	}
	// TODO: Implement end

}
