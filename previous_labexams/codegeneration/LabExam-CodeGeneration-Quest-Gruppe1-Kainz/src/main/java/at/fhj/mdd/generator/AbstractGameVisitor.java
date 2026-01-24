package at.fhj.mdd.generator;

import at.fhj.mdd.metamodel.MGame;
import at.fhj.mdd.metamodel.MGatherStep;
import at.fhj.mdd.metamodel.MKillStep;
import at.fhj.mdd.metamodel.MProtectStep;
import at.fhj.mdd.metamodel.MQuest;
import at.fhj.mdd.metamodel.MStep;

public abstract class AbstractGameVisitor implements GameVisitor {

	@Override
	public void visit(MGame game) {
		for (MQuest quest : game.getQuests()) {
			visit(quest);
		}
	}

	@Override
	public void visit(MQuest quest) {
		for (MStep step : quest.getSteps()) {
			visit(step);
		}
	}

	@Override
	public void visit(MStep step) {
		if (step instanceof MKillStep) {
			visit((MKillStep) step);
		} else if (step instanceof MGatherStep) {
			visit((MGatherStep) step);
		} else if (step instanceof MProtectStep) {
			visit((MProtectStep) step);
		} else {
			throw new IllegalArgumentException("Invalid step class " + step.getClass().getName());
		}
	}

	@Override
	public void visit(MKillStep step) {

	}

	@Override
	public void visit(MGatherStep step) {

	}

	@Override
	public void visit(MProtectStep step) {

	}

}
