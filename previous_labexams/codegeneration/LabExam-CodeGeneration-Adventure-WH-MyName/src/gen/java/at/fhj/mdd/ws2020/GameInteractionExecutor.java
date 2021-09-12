package at.fhj.mdd.ws2020;

import at.fhj.mdd.ws2020.game.Game;
import at.fhj.mdd.ws2020.game.InteractionExecutor;
import at.fhj.mdd.ws2020.game.Inventory;

public class GameInteractionExecutor implements InteractionExecutor {

	@Override
	public void execute(Game game, String roomName, String objectName, String interactionName) {
		if(roomName.contentEquals("Attic")) {
			if(objectName.contentEquals("Candle")) {
				if(interactionName.contentEquals("Light")) {
					game.text("The candle throws light around the room. In one of the corners you see a key.");
				}
			}
			if(objectName.contentEquals("Trap door")) {
				if(interactionName.contentEquals("Open")) {
					game.text("The trap door opens and you go down to a different room");
					game.goToRoom("Hall");
				}
			}
			if(objectName.contentEquals("Key")) {
				if(interactionName.contentEquals("Pick Up")) {
					game.addToInventory("Trap Door Key", 1);
				}
			}
		}
		if(roomName.contentEquals("Hall")) {
			if(objectName.contentEquals("Trap Door")) {
				if(interactionName.contentEquals("Climp")) {
					game.goToRoom("Attic");
				}
			}
		}
	}

	@Override
	public boolean canExecute(Inventory inventory, String roomName, String objectName, String interactionName) {
		if(roomName.contentEquals("Attic")) {
			if(objectName.contentEquals("Candle")) {
				if(interactionName.contentEquals("Light")) {
					return inventory.hasItem("Lighter", 1);
				}
			}
			if(objectName.contentEquals("Trap door")) {
				if(interactionName.contentEquals("Open")) {
					return inventory.hasItem("Trap Door Key", 1);
				}
			}
			if(objectName.contentEquals("Key")) {
				if(interactionName.contentEquals("Pick Up")) {
					return true;
				}
			}
		}
		if(roomName.contentEquals("Hall")) {
			if(objectName.contentEquals("Trap Door")) {
				if(interactionName.contentEquals("Climp")) {
					return true;
				}
			}
		}
		return false;
	}
}
