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

public abstract class AbstractGameVisitor implements GameVisitor {

	@Override
	public void visit(MGame game) {
		for (MItem item : game.getItems()) {
			visit(item);
		}

		for (MRoom room : game.getRooms()) {
			visit(room);
		}
	}

	@Override
	public void visit(MItem item) {

	}

	@Override
	public void visit(MRoom room) {
		for (MObject object : room.getObjects()) {
			visit(object);
		}
	}

	@Override
	public void visit(MObject object) {
		for (MInteraction interaction : object.getInteractions()) {
			visit(interaction);
		}
	}

	@Override
	public void visit(MInteraction interaction) {
		visit(interaction.getPrecondition());
		for (MOccurence occurence : interaction.getOccurences()) {
			visit(occurence);
		}
	}

	@Override
	public void visit(MOccurence occurence) {
		if (occurence instanceof MInventoryOccurence) {
			visit((MInventoryOccurence) occurence);
		} else if (occurence instanceof MTextOccurence) {
			visit((MTextOccurence) occurence);
		} else if (occurence instanceof MTransportOccurence) {
			visit((MTransportOccurence) occurence);
		} else {
			throw new IllegalArgumentException("Invalid occurence type: " + occurence.getClass().getName());
		}
	}

	@Override
	public void visit(MPrecondition precondition) {

	}

	@Override
	public void visit(MInventoryOccurence occurence) {

	}

	@Override
	public void visit(MTextOccurence occurence) {

	}

	@Override
	public void visit(MTransportOccurence occurence) {

	}

}
