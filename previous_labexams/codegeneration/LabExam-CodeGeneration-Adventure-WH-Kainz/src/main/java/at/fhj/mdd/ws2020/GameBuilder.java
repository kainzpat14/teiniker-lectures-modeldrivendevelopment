package at.fhj.mdd.ws2020;

import java.util.ArrayList;
import java.util.List;

import at.fhj.mdd.ws2020.metamodel.MGame;
import at.fhj.mdd.ws2020.metamodel.MItem;
import at.fhj.mdd.ws2020.metamodel.MRoom;

public class GameBuilder {

	private MGame game = new MGame();
	private List<Runnable> finalizations = new ArrayList<>();

	public GameBuilder item(String name, String description) {
		game.getItems().add(new MItem(name, description));
		return this;
	}

	public RoomBuilder room(String name, String description) {
		MRoom room = new MRoom(name, description);
		game.getRooms().add(room);
		return new RoomBuilder(this, room);
	}

	public MItem getItem(String name) {
		return game.getItems().stream().filter(item -> item.getName().contentEquals(name)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Item with name " + name + " does not exist"));
	}

	public MRoom getRoom(String name) {
		return game.getRooms().stream().filter(room -> room.getName().contentEquals(name)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Room with name " + name + " does not exist"));
	}

	public void addFinalization(Runnable runnable) {
		finalizations.add(runnable);
	}

	public MGame toGame() {
		for (Runnable finalization : finalizations) {
			finalization.run();
		}
		return game;
	}
}
