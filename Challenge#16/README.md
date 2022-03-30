# Challenge Summary
<!-- Description of the challenge -->
Method Return the maximum Integer value in the binary tree.  
Method Return the maximum value in the binary search tree.  

## Whiteboard Process
<!-- Embedded whiteboard image -->
* **Binary  Tree**
![WB1](./Image/WhiteBoard2.PNG)  
* **Binary Search Tree**
![WB](./Image/WhiteBoard.PNG)  

## Approach & Efficiency
<!-- What approach did you take? Why? What is the Big O space/time for this approach? -->
* **Binary  Tree**
- first check if the tree is Empty then throw exception.  
- otherwise will call another method and send the root and the data in the root as parameter.   
- in the function we will use the recursive to reach the End of the tree.  Each time will check :   
a . if the Node had the data bigger than the data in the valueMax then make it as maxvalue.   
b. if the Left node not null then call the function again.   
c. if the right not null call the function again.  
Return the maximum value stored.  
The Big O space O(1) / time is O(n) since we check the whole tree.  

* **Binary Search Tree**

- first check if the tree is Empty then throw exception.  
- if the tree doesn't have any element in the right side of the root then the root the maximum value.  
- otherwise will call another method and send the root as parameter.   
- in the function we will use the recursive to reach the last element in the right side of the tree(which is has the maximum value,since this is the binary search tree so need only check the right side). Each time will sent the right node and stop when the right node is null. then we reach the End of the tree.   

The Big O space O(1) / time is O(logn) since we check only the right side of the binary search tree.  
## Solution
<!-- Show how to run your code, and examples of it in action -->
 ![App](./Image/AppTask.PNG)   
 [Solution_Link](https://github.com/AlaaYlula/data-structures-and-algorithms/tree/main/Challenge%2316/treeMax/app/src/main/java/treeMax) 

