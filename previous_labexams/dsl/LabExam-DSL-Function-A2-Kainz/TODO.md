# LabExam DSL Attempt 2

## Important
Before you start rename the folder, Intellij/Eclipse Project and Maven project by replacing MyName with your Lastname. If you forget this you WILL lose 50% of your points. 
Compiler errors are not tolerated, you will lose all of your points if the code does not compile. Furthermore, it is not possible to get 100% if the tests fail.

You need to upload in time, note that delays because of your software or hardware malfunctioning cannot be considered, so ensure that everything is working fine BEFORE you give the lecturer the go ahead to start. 

You can earn 12,5% (10 pts) of your grade in this LabExam.

## Steps

### DSL Builder Function pipeline (10 pts)

Given the metamodel in *metamodel.puml* create a collection of builder classes that allow creation of the models for this metamodel using an internal DSL. Use the given Testclass to identify the structure of the method calls and your functionality. You will get most points if you fulfill the requirements of the test, however you will only get all points if any model theoretically possible with the metamodel can be created using your builder.

NOTE: The test outputs the actual object graph and src/test/resources contains the expected one, so you can use plantuml for a visual comparison of your mistakes.