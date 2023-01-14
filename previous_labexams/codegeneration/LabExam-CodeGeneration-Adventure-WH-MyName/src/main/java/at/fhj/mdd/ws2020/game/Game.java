package at.fhj.mdd.ws2020.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

import at.fhj.mdd.ws2020.metamodel.MDescribedItem;
import at.fhj.mdd.ws2020.metamodel.MGame;
import at.fhj.mdd.ws2020.metamodel.MInteraction;
import at.fhj.mdd.ws2020.metamodel.MObject;
import at.fhj.mdd.ws2020.metamodel.MRoom;

public class Game {

	private MGame game;
	private MRoom startRoom;
	private InteractionExecutor executor;
	private Inventory inventory = new Inventory();
	private MRoom currentRoom;

	public Game(MGame game, MRoom startRoom, InteractionExecutor executor) {
		super();
		this.game = game;
		this.startRoom = startRoom;
		this.executor = executor;
	}

	public void gameLoop() {
		currentRoom = startRoom;
		while (true) {
			roomLoop(currentRoom);
		}
	}

	private void roomLoop(MRoom room) {
		while (true) {
			System.out.println(room.getDescription());
			MObject object = choose("What do you want to look at?", room.getObjects());
			if (object != null) {
				objectLoop(room, object);
				if (!room.equals(currentRoom)) {
					break;
				}
			}
		}
	}

	private void objectLoop(MRoom room, MObject object) {
		System.out.println(object.getDescription());
		List<MInteraction> interactions = object.getInteractions().stream().filter(
				interaction -> executor.canExecute(inventory, room.getName(), object.getName(), interaction.getName()))
				.collect(Collectors.toList());
		while (true) {
			if (interactions.isEmpty()) {
				System.out.println("You can do nothing here");
				break;
			} else {
				MInteraction choice = choose("What do you wish to do?", interactions);
				if (choice != null) {
					executor.execute(this, room.getName(), object.getName(), choice.getName());
				}
				break;
			}
		}
	}

	private <T extends MDescribedItem> T choose(String header, List<T> objects) {
		Map<Integer, T> choices = objectsToChoices(objects);

		return selectChoice(header, choices);

	}

	private <T extends MDescribedItem> T selectChoice(String header, Map<Integer, T> choices) {
		while (true) {
			System.out.println(header);
			printChoices(choices);
			System.out.println();

			int input = readInt("Your choice: ");
			int enteredChoice = input;
			if (enteredChoice == 0) {
				return null;
			}
			if (choices.containsKey(enteredChoice)) {
				return choices.get(enteredChoice);
			}
			System.out.println("Invalid input!");
		}
	}

	private <T extends MDescribedItem> Map<Integer, T> objectsToChoices(List<T> objects) {
		int count = 1;
		Map<Integer, T> choices = new HashMap<>();
		for (T choice : objects) {
			choices.put(count, choice);
			count++;
		}
		return choices;
	}

	private <T extends MDescribedItem> void printChoices(Map<Integer, T> choices) {
		for (Entry<Integer, T> choice : choices.entrySet()) {
			System.out.println(choice.getKey() + ": " + choice.getValue().getName());
		}
		System.out.println("0: Abort");
	}

	private int readInt(String prompt) {
		while (true) {
			System.out.println(prompt);
			try {
				@SuppressWarnings("resource") // closing this would close system.in
				Scanner scanner = new Scanner(System.in);
				return scanner.nextInt();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void goToRoom(String room) {
		currentRoom = game.getRooms().stream().filter(roomObj -> roomObj.getName().contentEquals(room)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Room not found: " + room));
	}

	public void addToInventory(String item, int count) {
		inventory.addItem(item, count);
	}

	public void text(String text) {
		System.out.println(text);
	}
}
