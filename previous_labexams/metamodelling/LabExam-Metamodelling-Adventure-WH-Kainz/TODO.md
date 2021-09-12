# LabExam Metamodelling Gruppe 1

## Important
Before you start rename the folder, Intellij/Eclipse Project and Maven project by replacing MyName with your Lastname. If you forget this you WILL lose 50% of your points. 
Compiler errors are not tolerated, you will lose all of your points if the code does not compile. Furthermore, it is not possible to get 100% if the tests fail.

You need to upload in time, note that delays because of your software or hardware malfunctioning cannot be considered, so ensure that everything is working fine BEFORE you give the lecturer the go ahead to start. 

You can earn 12,5% (1 point = 1,25%) of your grade in this LabExam.

## Steps

### Metamodelling 10 points

Create a metamodel using whichever tool you want (or even by hand) using the domain description below. Make sure that the model is free of redundancies and that your UML nomenclature is correct. You can hand in your result either via Moodle or in paper.

#### Domain: Text Based Adventure

Some of the very first computer games, were text based adventures, where the player would be presented with a textual description of their environment and would interact with that environment via a series of textual commands. We will now try and describe such a text based adventure. Such an adventure game consists of a number of rooms, which all have a name and a textual description. Contained within a room can be a number of interactable objects, each of which also has a name and a textual description. Each interactable object has a number of possible interactions (which have a name and description), which may depend on a certain quantity of a certain item being in the players inventory, or may be executable without any precondition. Upon performing such an interaction any number of things may happen (so one interaction may cause zero, one or multiple occurences): 
- Text is displayed
- N pieces of Item A are added to the players inventory
- The player is transported to another room
As for the items themselves, the game has a list of them where each of them has a name and description. 

##### Example: 

Room Attic: You look around and find yourself in what looks like an attic, light enters the room via holes in the roof and the entire room is covered in dust. In the middle of the room there is a candle and a trap door is on the floor.
Objects:
- Candle: A large candle stands in the middle of the room
	- Interaction Light: Light the candle
		- Precondition: 1 Lighter in the inventory
		- Occurrences:
			- Text: The candle throws light around the room. In one of the corners you see a key.
- Trap Door: A trap door 
	- Interaction Open: Open the trap door
		- Precondition: 1 Trap Door Key in the inventory
		- Ocurrences:
			- Text: The trap door opens and you go down to a different room
			- Transport: Hall
- Key: A rusty key
	- Interaction Pick Up: Pick up the key
		- Precondition: None
		- Occurrences: 
			- Inventory: Add 1 trap door key to the inventory

Room Hall: You find yourself in a corridor with two doors at either end and a drap door above you. 
Objects:
- Trap Door: The trap door you just came through
	- Interaction Climp: Climp through the trap door
		- Precondition: None
		- Occurrences:
			- Transport: Attic
- Door 1: A door
	- Interaction Go through: Go through the door
		- Precondition: None
		- Occurrences: 
			- Transport: Living Room
- Door 2: A door
	- Interaction Go through: Go through the door
		- Precondition: None
		- Occurrences: 
			- Transport: Bedroom

Items: 
- Lighter: Used to set fire to things
- Trap Door Key: Used to open the trap door in the attic