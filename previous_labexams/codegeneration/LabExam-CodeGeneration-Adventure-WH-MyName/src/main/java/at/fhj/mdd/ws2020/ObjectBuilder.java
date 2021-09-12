package at.fhj.mdd.ws2020;

import at.fhj.mdd.ws2020.metamodel.MGame;
import at.fhj.mdd.ws2020.metamodel.MInteraction;
import at.fhj.mdd.ws2020.metamodel.MItem;
import at.fhj.mdd.ws2020.metamodel.MObject;
import at.fhj.mdd.ws2020.metamodel.MRoom;

public class ObjectBuilder {
	private RoomBuilder parent;
	private MObject object;

	public ObjectBuilder(RoomBuilder parent, MObject object) {
		super();
		this.parent = parent;
		this.object = object;
	}

	public InteractionBuilder interaction(String name, String description) {
		MInteraction interaction = new MInteraction(name, description);
		object.getInteractions().add(interaction);
		return new InteractionBuilder(this, interaction);
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
