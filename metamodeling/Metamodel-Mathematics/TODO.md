# Metamodel Mathematic Formula

## Task 

Create a metamodel based on the following domain description in any format you prefer (ex. PlantUML, Handdrawn)

## Domain

Many processes in the real world and also in IT systems can be modelled as a collection
of mathematic formulas. In order to model such a process a number of formulas are applied
one after another. At the end the final formula returns the result of the process. 

To keep this simple we are going to limit our formulas to simple arithmetics and restrict
them to the set of real numbers. 

A formula can contain a certain number of input variables, that must be provided in order 
for the calculation to start. The type of those input variables must not be modelled, 
it is fixed. 

The formula then includes a hierarchy of nested operations used to determine the result. 
These operations consist of a number of inputs which can either be a variable, a constant or the result 
of a nested operation. 

Supported operations are: 
- Addition
- Substraction
- Multiplication
- Division
- Potentiation

The result of one formula can be mapped to the input of another formula.
