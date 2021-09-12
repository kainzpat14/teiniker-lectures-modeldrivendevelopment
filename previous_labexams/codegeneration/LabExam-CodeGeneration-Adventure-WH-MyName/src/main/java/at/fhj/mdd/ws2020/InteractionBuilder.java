package at.fhj.mdd.ws2020;

import at.fhj.mdd.ws2020.metamodel.MGame;
import at.fhj.mdd.ws2020.metamodel.MInteraction;
import at.fhj.mdd.ws2020.metamodel.MInventoryOccurence;
import at.fhj.mdd.ws2020.metamodel.MItem;
import at.fhj.mdd.ws2020.metamodel.MPrecondition;
import at.fhj.mdd.ws2020.metamodel.MRoom;
import at.fhj.mdd.ws2020.metamodel.MTextOccurence;
import at.fhj.mdd.ws2020.metamodel.MTransportOccurence;

public class InteractionBuilder {
	private ObjectBuilder parent;
	private MInteraction interaction;

	public InteractionBuilder(ObjectBuilder parent, MInteraction interaction) {
		super();
		this.parent = parent;
		this.interaction = interaction;
	}

	public InteractionBuilder requires(int requiredQuantity, String item) {
		MItem itemObj = parent.getItem(item);
		MPrecondition precondition = new MPrecondition(itemObj, requiredQuantity);
		interaction.setPrecondition(precondition);
		return this;
	}

	public InteractionBuilder text(String text) {
		MTextOccurence occurence = new MTextOccurence(text);
		interaction.getOccurences().add(occurence);
		return this;
	}

	public InteractionBuilder transport(String room) {
		parent.addFinalization(() -> {
			MRoom roomObj = parent.getRoom(room);
			MTransportOccurence occurence = new MTransportOccurence(roomObj);
			interaction.getOccurences().add(occurence);
		});
		return this;
	}

	public InteractionBuilder add(int count, String item) {
		MItem itemObj = parent.getItem(item);
		MInventoryOccurence occurence = new MInventoryOccurence(itemObj, count);
		interaction.getOccurences().add(occurence);
		return this;
	}

	public InteractionBuilder interaction(String name, String description) {
		return parent.interaction(name, description);
	}

	public ObjectBuilder object(String name, String description) {
		return parent.object(name, description);
	}

	public GameBuilder item(String name, String description) {
		return parent.item(name, description);
	}

	public RoomBuilder room(String name, String description) {
		return parent.room(name, description);
	}

	public MItem getItem(String name) {
		return parent.getItem(name);
	}

	public MRoom getRoom(String name) {
		return parent.getRoom(name);
	}

	public void addFinalization(Runnable runnable) {
		parent.addFinalization(runnable);
	}

	public MGame toGame() {
		return parent.toGame();
	}

}
