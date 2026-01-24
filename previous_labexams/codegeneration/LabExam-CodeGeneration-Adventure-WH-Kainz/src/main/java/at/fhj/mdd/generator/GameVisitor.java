package at.fhj.mdd.generator;

import at.fhj.mdd.metamodel.MGame;
import at.fhj.mdd.metamodel.MInteraction;
import at.fhj.mdd.metamodel.MInventoryOccurence;
import at.fhj.mdd.metamodel.MItem;
import at.fhj.mdd.metamodel.MObject;
import at.fhj.mdd.metamodel.MOccurence;
import at.fhj.mdd.metamodel.MPrecondition;
import at.fhj.mdd.metamodel.MRoom;
import at.fhj.mdd.metamodel.MTextOccurence;
import at.fhj.mdd.metamodel.MTransportOccurence;

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
