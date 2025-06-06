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

These classes are part of a project that downloads songs from a popular music streaming 
service.

## Tasks

Please complete the following tasks: 

1) Describe the datastructures in objects and what they model in the music streaming service
2) Describe the purpose of TrackProviderPlaylist
3) Describe the purpose of MP3TrackProcessor
4) Describe a precondition for MP3TrackProcessor to correctly process a track
5) Hard: Create an outline on how one would call TrackProviderPlaylist to download files

## Your answers

1)
2)
3)
4)
5)
