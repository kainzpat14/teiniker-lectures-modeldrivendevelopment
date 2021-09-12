# LabExam Metamodelling Attempt 2

## Important
Before you start rename the folder, Intellij/Eclipse Project and Maven project by replacing MyName with your Lastname. If you forget this you WILL lose 50% of your points. 
Compiler errors are not tolerated, you will lose all of your points if the code does not compile. Furthermore, it is not possible to get 100% if the tests fail.

You need to upload in time, note that delays because of your software or hardware malfunctioning cannot be considered, so ensure that everything is working fine BEFORE you give the lecturer the go ahead to start. 

You can earn 12,5% (1 point = 1,25%) of your grade in this LabExam.

## Steps

### Metamodelling 10 points

Create a metamodel using whichever tool you want (or even by hand) using the domain description below. Make sure that the model is free of redundancies and that your UML nomenclature is correct. You can hand in your result either via Moodle or in paper.

#### Domain: Function Pipeline

In order to implement mathematical algorithms one often uses function pipelines. A function pipeline consists of any number of functions, where each function has a name and any number (also 0) of numeric parameters (numeric = number from the set of real numbers, in Java BigDecimal, or similar). Each parameter also has a name. Additionally, the function pipeline contains a call chain, where the output of one function can serve as the input of any number of other functions. Any function can occur multiple times in the chain, but there must be just one function at the end of the chain and the number of parameters must always be satisfied. 

##### Example: 

Function: Input
Parameters: None


Function: Sqare
Parameters:
- base

Function: Addition
Parameters:
- summand1
- summand2

Function: Square Root
Parameters: 
- square

Pipeline: 

input (input1)
input (input29

input1 -> square (square1)
input2 -> square (square2)

square1, square2 -> addition (addition1)

addition1 -> squareRoot

or in mathematical terms:
sqrt(square(input) + square(input))