package at.fhj.mdd.ws2020.dsl;

import at.fhj.mdd.ws2020.dsl.metamodel.MInteraction;
import at.fhj.mdd.ws2020.dsl.metamodel.MRoom;
import at.fhj.mdd.ws2020.dsl.metamodel.MTransportOccurence;

public class InteractionBuilder {
	private ObjectBuilder parent;
	private MInteraction interaction;

	public InteractionBuilder(ObjectBuilder parent, MInteraction interaction) {
		super();
		this.parent = parent;
		this.interaction = interaction;
	}

	// TODO: implement

	public InteractionBuilder transport(String room) {
		parent.addFinalization(() -> {
			MRoom roomObj = parent.getRoom(room);
			MTransportOccurence occurence = new MTransportOccurence(roomObj);
			interaction.getOccurences().add(occurence);
		});
		return this;
	}

}
