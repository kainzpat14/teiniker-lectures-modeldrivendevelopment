package at.fhj.mdd.ws2020.dsl;

import at.fhj.mdd.ws2020.dsl.metamodel.MGame;
import at.fhj.mdd.ws2020.dsl.metamodel.MItem;
import at.fhj.mdd.ws2020.dsl.metamodel.MObject;
import at.fhj.mdd.ws2020.dsl.metamodel.MRoom;

public class RoomBuilder {
	private GameBuilder parent;
	private MRoom room;

	public RoomBuilder(GameBuilder parent, MRoom room) {
		super();
		this.parent = parent;
		this.room = room;
	}

	public ObjectBuilder object(String name, String description) {
		MObject object = new MObject(name, description);
		room.getObjects().add(object);
		return new ObjectBuilder(this, object);
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
