# LabExam Code Generation Gruppe 2

## Important
Before you start rename the folder, Intellij/Eclipse Project and Maven project by replacing MyName with your Lastname. If you forget this you WILL lose 50% of your points. 
Compiler errors are not tolerated, you will lose all of your points if the code does not compile. Furthermore, it is not possible to get 100% if the tests fail.

You need to upload in time, note that delays because of your software or hardware malfunctioning cannot be considered, so ensure that everything is working fine BEFORE you give the lecturer the go ahead to start. 

You can earn 12,5% (10pts) of your grade in this LabExam.

## Steps

### Visitor Pattern 5pts
Using the given metamodel construct a visitor interface and abstract visitor class that simply traverses any given object tree without doing anything. 


### Code Generation 5pts
Using your abstract visitor class, create a code generator that will generate the InstallExecutor class as can be seen in ExampleInstallExecutor. Use the provided writer to generate the Java code, no frameworks. Use the given test to verify your implementation.

NOTES: 
- do not change method signatures, catch any checked exceptions and convert them to runtime exceptions
- use StringUtils.capitalize to generate the names of getters and setters for fields

