package at.fhj.mdd.ws2020.generator;

import at.fhj.mdd.ws2020.metamodel.MGame;
import at.fhj.mdd.ws2020.metamodel.MGatherStep;
import at.fhj.mdd.ws2020.metamodel.MKillStep;
import at.fhj.mdd.ws2020.metamodel.MProtectStep;
import at.fhj.mdd.ws2020.metamodel.MQuest;
import at.fhj.mdd.ws2020.metamodel.MStep;

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
