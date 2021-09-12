package at.fhj.mdd.ws2020;

import at.fhj.mdd.ws2020.game.Game;
import at.fhj.mdd.ws2020.game.InteractionExecutor;
import at.fhj.mdd.ws2020.game.Inventory;

public class ExampleInteractionExecutor implements InteractionExecutor {

	@Override
	public void execute(Game game, String roomName, String objectName, String interactionName) {
		if (roomName.contentEquals("Entrance")) {
			if (objectName.contentEquals("Door")) {
				if (interactionName.contentEquals("Open")) {
					game.goToRoom("Living Room");
				}
				if (interactionName.contentEquals("Look at")) {
					game.text("A door with a silver key hole");
				}
			}
			if (objectName.contentEquals("Key")) {
				if (interactionName.contentEquals("Take")) {
					game.addToInventory("Entrance Key", 1);
				}
			}
		}
	}

	@Override
	public boolean canExecute(Inventory inventory, String roomName, String objectName, String interactionName) {
		if (roomName.contentEquals("Entrance")) {
			if (objectName.contentEquals("Door")) {
				if (interactionName.contentEquals("Open")) {
					return inventory.hasItem("Entrance Key", 1);
				}
				if (interactionName.contentEquals("Look at")) {
					return true;
				}
			}
			if (objectName.contentEquals("Key")) {
				if (interactionName.contentEquals("Take")) {
					return true;
				}
			}
		}
		return false;
	}

}
