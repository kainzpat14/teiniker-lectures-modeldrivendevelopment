# python uses ducktyping, so this method does not need generics, it supports sorting of all lists containing 
# items which support the > operator
from typing import TypeVar, SupportsAbs
def bubbleSort(mylist):
    count=len(mylist)
    for i in range(count-1):
        for j in range(0, count-i-1):
            if mylist[j] > mylist[j+1]:
                tmp = mylist[j]
                mylist[j] = mylist[j+1]
                mylist[j+1] = tmp
                

class NotADuck:
    def __init__(self,x,y):
        self.x = x
        self.y = y
    
    def __str__(self):
        return "("+str(self.x)+","+str(self.y)+")"                

intlist = [5,4,3,2,1]
doublelist = [5.0,4.0,3.0,2.0,1.0]
stringlist = ["f", "e", "d", "c", "b", "a"]
noDuckList = [NotADuck(1,2),NotADuck(2,3),NotADuck(3,4)]

bubbleSort(intlist)
print(*intlist)

bubbleSort(doublelist)
print(*doublelist)

bubbleSort(stringlist)
print(*stringlist)

# unfortunately this means if we try to sort a type that does not support the operation, we get a quite ugly 
# runtime error
#bubbleSort(noDuckList)
print(*noDuckList)

