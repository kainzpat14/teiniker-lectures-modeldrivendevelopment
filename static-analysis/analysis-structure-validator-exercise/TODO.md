# Static Analysis

The code of this project has been provided by a generous donor for your studies. Just 
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

A bit of background for those that do not know Poker: In Poker there are certain card
patterns so-called "hands", where some are more valuable than others. 

A flush is a hand that exclusively consists of cards of the same color. 

A straight is a hand that consists of consecutive values

A straight flush is a hand that is both a flush and a straight

A royal flush is the highest possible straight flush (so the highest card is the highest possible card)

## Tasks

Please complete the following tasks: 

1) Describe the datastructures used to represent the state of the poker game
2) Describe how RoyalFlushValidator, StraightFlushValidator, FlushValidator and StraightValidator avoid code duplication
3) Describe how you could improve the above-mentioned relationship to allow alternate implementations of the validators
4) Execute the improvement mentioned above
5) Create two meaningfull JUnit tests for two validators

## Your answers

1)
2)
3)
