package at.fhj.mdd.ss2020.generator;

import java.util.HashSet;
import java.util.Set;

import at.fhj.mdd.ss2020.metamodel.MField;
import at.fhj.mdd.ss2020.metamodel.MIntField;
import at.fhj.mdd.ss2020.metamodel.MStringField;
import at.fhj.mdd.ss2020.metamodel.MTelegram;
import at.fhj.mdd.ss2020.metamodel.MTelegrams;

public abstract class AbstractTelegramVisitor implements TelegramVisitor {

	@Override
	public void visit(MTelegrams telegrams) {
		Set<MTelegram> visited = new HashSet<>();
		for (MTelegram telegram : telegrams.getInputTelegrams()) {
			visit(telegram);
			visited.add(telegram);
		}
		for (MTelegram telegram : telegrams.getOutputTelegrams()) {
			if (!visited.contains(telegram)) {
				visit(telegram);
			}
		}
	}

	@Override
	public void visit(MTelegram telegram) {
		for (MField field : telegram.getFields()) {
			visit(field);
		}
	}

	@Override
	public void visit(MField field) {
		if (field instanceof MIntField) {
			visit((MIntField) field);
		} else if (field instanceof MStringField) {
			visit((MStringField) field);
		} else {
			throw new IllegalArgumentException("Unknown field type: " + field.getClass());
		}
	}

	@Override
	public void visit(MIntField field) {

	}

	@Override
	public void visit(MStringField field) {

	}

}
