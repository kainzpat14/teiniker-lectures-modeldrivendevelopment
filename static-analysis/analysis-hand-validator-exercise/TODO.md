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
Those patterns are descending by value:
- Royal Flush
- Straight Flush
- Four of a Kind
- Full House
- Flush
- Straight
- Three of a Kind
- Two Pairs
- Two of a Kind
- High card

If two players hold the same hand, the highest cards within those hands win. 

## Tasks

Please complete the following tasks: 

1) Describe the purpose of the method PokerHandValidator.validateCards
2) Describe how the method PokerHandValidator.validateCards accomplishes its goal
3) Describe how the PokerHandValidator always validates the highest hand first
4) Describe how the PokerHandValidator.validateCards method handles hands of more than 5 cards
5) Describe why the algorithm always selects the best subhand in hands with more than 5 cards
6) Refactor PokerHandValidator.validateCards so improve readability

## Your answers

1)
2)
3)
4)
5)

