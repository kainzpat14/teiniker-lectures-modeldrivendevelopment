package at.fhj.mdd.generator;

import at.fhj.mdd.metamodel.MGame;
import at.fhj.mdd.metamodel.MGatherStep;
import at.fhj.mdd.metamodel.MKillStep;
import at.fhj.mdd.metamodel.MProtectStep;
import at.fhj.mdd.metamodel.MQuest;
import at.fhj.mdd.metamodel.MStep;

public interface GameVisitor {
	void visit(MGame game);

	void visit(MQuest quest);

	void visit(MStep step);

	void visit(MKillStep step);

	void visit(MGatherStep step);

	void visit(MProtectStep step);
}
