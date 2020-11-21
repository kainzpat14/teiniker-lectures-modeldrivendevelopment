# Algorithm Visitor Generator

The purpose of this example is to illustrate different generation strategies when generating: 
- Structural Code
- Behavioral Code
- Mixed Code

## Step 1: Visitor Pattern
Create a visitor pattern by implementing IAlgorithmVisitor and AbstractAlgorithmVisitor so that the entire structure of the algorithm metamodel (see metamodel.puml) is iterated without any code being executed. NOTE: nextStep is nullable, so is falseStep, ensure that the proper null checks are present

## Step 2: InterfaceGenerator Structural Code
Implement a generator based on AbstractAlgorithmVisitor to generate the Interface for such an algorithm. Each step is generated as a method, where execute steps are void methods and conditional steps boolean methods. See src/test/resources/I*Algorithm.java for examples

## Step 3: AlgorithmGenerator Behavioral Code
Implement a generator based on AbstractAlgorithmVisitor to generate the workflow for an algorithm. Each execute step here is simply a call of the corresponding method of the interface generator above. Each conditional step represents an if statement, where the method generated above is used as the condition. See src/test/resources/*Algorithm.java for examples. 

## Step 4: AlgorithmTemplateGenerator Mixed Code
Implement a generator based on AbstractAlgorithmVisitor to generate both the structure and workflow of an algorithm using the Template Method pattern. Generate abstract methods for all steps and an algorithm implementation as seen in the two steps above. See src/test/resources/*Template.java for examples. 