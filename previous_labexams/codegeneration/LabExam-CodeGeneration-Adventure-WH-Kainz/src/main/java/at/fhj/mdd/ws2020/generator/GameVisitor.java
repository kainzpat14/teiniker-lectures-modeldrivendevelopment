package at.fhj.mdd.ws2020.generator;

import at.fhj.mdd.ws2020.metamodel.MGame;
import at.fhj.mdd.ws2020.metamodel.MInteraction;
import at.fhj.mdd.ws2020.metamodel.MInventoryOccurence;
import at.fhj.mdd.ws2020.metamodel.MItem;
import at.fhj.mdd.ws2020.metamodel.MObject;
import at.fhj.mdd.ws2020.metamodel.MOccurence;
import at.fhj.mdd.ws2020.metamodel.MPrecondition;
import at.fhj.mdd.ws2020.metamodel.MRoom;
import at.fhj.mdd.ws2020.metamodel.MTextOccurence;
import at.fhj.mdd.ws2020.metamodel.MTransportOccurence;

public interface GameVisitor {
	void visit(MGame game);

	void visit(MItem item);

	void visit(MRoom room);

	void visit(MObject object);

	void visit(MInteraction interaction);

	void visit(MOccurence occurence);

	void visit(MPrecondition precondition);

	void visit(MInventoryOccurence occurence);

	void visit(MTextOccurence occurence);

	void visit(MTransportOccurence occurence);
}
