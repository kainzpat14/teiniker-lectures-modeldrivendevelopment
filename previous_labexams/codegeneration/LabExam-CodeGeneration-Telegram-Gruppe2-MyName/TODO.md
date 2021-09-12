# LabExam Code Generation Gruppe 2

## Important
Before you start rename the folder, Intellij/Eclipse Project and Maven project by replacing MyName with your Lastname. If you forget this you WILL lose 50% of your points. 
Compiler errors are not tolerated, you will lose all of your points if the code does not compile. Furthermore, it is not possible to get 100% if the tests fail.

You need to upload in time, note that delays because of your software or hardware malfunctioning cannot be considered, so ensure that everything is working fine BEFORE you give the lecturer the go ahead to start. 

You can earn 10% of your grade in this LabExam.

## Steps

### Code Generation using the composite pattern
Adapt the provided metamodel classes to create a code generator based on the composite pattern. The expected code structure can be found in src/test/resources. Use the provided test to test your implementation. 

NOTES: 
- do not change method signatures, catch any checked exceptions and convert them to runtime exceptions
- use StringUtils.capitalize to generate the names of getters and setters for fields
- all empty lines are really empty (no whitespaces)
- all intentations are tabs
- time is tight, so copy as much from the example java files as you can and use auto generation
- you are using a quasi-composite pattern, don't be afraid to create new methods in the metamodel classes with parameters convenient to you. The methods don't all have to have the same name, parameters or do the same thing as usual in a composite pattern.
