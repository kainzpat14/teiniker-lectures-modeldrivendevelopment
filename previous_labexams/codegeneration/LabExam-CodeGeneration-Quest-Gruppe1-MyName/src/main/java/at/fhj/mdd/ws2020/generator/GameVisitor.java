package at.fhj.mdd.ws2020.generator;

import at.fhj.mdd.ws2020.metamodel.MGame;
import at.fhj.mdd.ws2020.metamodel.MGatherStep;
import at.fhj.mdd.ws2020.metamodel.MKillStep;
import at.fhj.mdd.ws2020.metamodel.MProtectStep;
import at.fhj.mdd.ws2020.metamodel.MQuest;
import at.fhj.mdd.ws2020.metamodel.MStep;

public interface GameVisitor {
	void visit(MGame game);

	void visit(MQuest quest);

	void visit(MStep step);

	void visit(MKillStep step);

	void visit(MGatherStep step);

	void visit(MProtectStep step);
}
