# LabExam Metamodelling Gruppe 1

## Important
Before you start rename the folder, Intellij/Eclipse Project and Maven project by replacing MyName with your Lastname. If you forget this you WILL lose 50% of your points. 
Compiler errors are not tolerated, you will lose all of your points if the code does not compile. Furthermore, it is not possible to get 100% if the tests fail.

You need to upload in time, note that delays because of your software or hardware malfunctioning cannot be considered, so ensure that everything is working fine BEFORE you give the lecturer the go ahead to start. 

You can earn 10% of your grade in this LabExam.

## Steps

### Metamodelling 10%

Create a metamodel using whichever tool you want (or even by hand) using the domain description below. Make sure that the model is free of redundancies and that your UML nomenclature is correct. You can hand in your result either via Moodle or in paper. 

#### Domain: Logic 

Electric circuits often incorporate so called logic gates. These gates perform simply logical operations such as "AND", "OR" and "NOT". The circuits have certain boolean inputs which are piped into those logic operations (AND and OR combine two named inputs while NOT only uses one input). Such can then be used to form larger blocks which can then be reused in other circuits (like XOR as input1 OR input2 AND NOT (input1 AND input2)). Either a gate or input can serve as output of a circuit

Examples:

Circuit 1: 

Input 1 Named XorInput1
Input 2 Named XorInput2
Gate 1: Input 1 AND Input 2 
Gate 2: NOT Gate 1
Gate 3: Input 1 OR Input 2 
Gate 4: Gate 3 AND Gate 2
Output: Gate 4

Circuit 2:

Input 1 Named FlipSwitch1 
Input 2 Named FlipSwitch2
Input 3 Named PowerPlug
Circuit Reuse 1: Input 1 Circuit 1 Input 2
Gate 1: Circuit Reuse 1 AND Input3
Output: Gate 1

