# Metamodel PLC Safety System

## Task 

Create a metamodel based on the following domain description in any format you prefer (ex. PlantUML, Handdrawn)

## Domain

A PLC (Programmable Logic Controller) is a device used in industry to control low level hardware. 
It operates similarly to microcontrollers in that it can read electronic inputs and write
electronic outputs based on its programming, but PLCs usually have a greater feature set
and are geared towards availability, predictability, safety and security. 

Most industry grade PLC systems provide normal programming language to model business logic, 
but when it comes to safety critical behaviour, they usually have a separate, often graphical
programming language with limited features to model such safety features, in order to provide 
maximum dependability. A safety program cannot fail under any circumstances.

Our limited version of a safety program, which should be modelled here, contains a number of 
boolean inputs (named), boolean decision points which take inputs as input
and model basic boolean operators (ISTRUE, AND,OR,XOR,NOT), and the option to shutdown (ie. completely disable the current)
for certain outputs (each shutdown affects a named output).

The program is a basic decision tree, not a graph (no loops allowed), each node has exactly
one predecessor (except the first node), and max. 2 children (0 for terminal nodes, 1 for normal nodes, 2 for decisions). 
