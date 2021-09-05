# Static Analysis

The code of this project has been provided by me for your studies. Just 
as with normal projects, the code here is far from optimal. Still you should be able to
read, understand and use it. 

## General hints
In the following part you will be asked to answer questions. Some of those questions 
will require you to describe the code you see. This does not mean that you should 
simply turn the code into language. The following code: 

```java
    int sum = 0;
    for(int i = 0;i<matrix.length;i++)
    {
        sum+=matrix[i][i];   
    }
    Assert.assertEquals(10,sum);
```

Cannot be described as: 
```
Sum is initialized with 0. The variable "i" is counted from
0 to matrix.length and we add the value of the matrix at first index = i and second index
= i to sum. Finally, we check if sum has value 10. 
```
That would just be reading the code symbol by symbol, which I assume any programmer can 
do. Instead, you should prove your understanding of the code: 
```
This code checks if the diagonal sum of a matrix is 10. 
```

## Background

An object diagram is an UML diagram that shows the state of objects in memory. PlantUML 
is a tool that enables the creation of UML diagrams such as object diagrams from a textual
description. 

[Syntax](https://plantuml.com/de/)

[Online Editor](https://www.planttext.com/)

## Tasks

Please complete the following tasks: 

1) Describe the purpose of ModelToObjectDiagram
2) Describe which data types the class supports
3) Describe how the class generates the names of the objects
4) Describe which conditions a field in an object has to satisfy in order to be processed
5) Describe a potential bug with regard to nullable fields and fix it
6) Describe and apply some potential refactorings

## Your answers

1)
2)
3)
4)
5)
6)
