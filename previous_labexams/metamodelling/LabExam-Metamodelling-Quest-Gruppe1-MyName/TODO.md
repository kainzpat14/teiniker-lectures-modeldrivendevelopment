# LabExam Metamodelling Gruppe 1

## Important
Before you start rename the folder, Intellij/Eclipse Project and Maven project by replacing MyName with your Lastname. If you forget this you WILL lose 50% of your points. 
Compiler errors are not tolerated, you will lose all of your points if the code does not compile. Furthermore, it is not possible to get 100% if the tests fail.

You need to upload in time, note that delays because of your software or hardware malfunctioning cannot be considered, so ensure that everything is working fine BEFORE you give the lecturer the go ahead to start. 

You can earn 12,5% (1 point = 1,25%) of your grade in this LabExam.

## Steps

### Metamodelling 10 points

Create a metamodel using whichever tool you want (or even by hand) using the domain description below. Make sure that the model is free of redundancies and that your UML nomenclature is correct. You can hand in your result either via Moodle or in paper. 

#### Domain: Game Quest

Anyone who has ever played an RPG is familiar with the same boring quest routine: Gather X, Kill X, Protect X. We will developing such a 
quest easier by providing a metamodel for it. A game consists of multiple quests, each quest either unlocks immediately or upon completion 
of another quest. A quest has a name, backstory and a number of steps, some of which may be optional, while others may not be. Each step either follows another or is available from the start. Either way a step has text describing the target to the player. Possible steps are:
- Gather N pieces of Entity with name X
- Kill N occurrences of Entity with name X
- Protect N occurrences of Entity with name X

An example: 

Game 1: 

Quest "Rescue the maiden", "The maiden has been locked away in the tower, free her!"

Step "Find the key" "The tower is locked! We must find the key"
- Grather 1 piece of Entity with name "Key"

Step "Kill the ghost holding the maiden" "A ghost is between you and the maiden, slay it!" requires previous step
- Kill 1 occurrence of Entity with name "Ghost"

Step "Bring the maiden safely home" "You have freed the maiden, but the way back home is perilous, protect her!" requires previous step
- Protect 1 occurence of Entity with name "Maiden"



Quest "Heal the maiden" "You have saved the maiden, but she was poisoned, you must find the antidote", activates after "Rescue the maiden"

Step "Gather herbs" "You must gather the healing herbs necessary to brew the antidote"
- Gather 10 pieces of Entity with name "Herb"
