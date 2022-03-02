# Singly Linked List
<!-- Short summary or background information -->
Consistant of nodes are ordered sequntially,each node has a value and pointer which point to the next one.  
The last node point to the NULL, and there is head node point to the first node.  

## Challenge
<!-- Description of the challenge -->
We need to create two classes Node and LinkedList.  
* Class Node : has the value and Node to point to the next node,and constructor to  set the value.  
* Class LinkedList : has a Node head and contructor to make the head point to null as defualt,  
    And Four Methods:
        newLinkedList.AddToHead(10); : which add value at the First of the linked list.  
        System.out.println(newLinkedList.ToString()); : which return a String in this Format "{ a } -> { b } -> { c } -> NULL" for the nodes in this Linked List.  
        System.out.println(newLinkedList.ValueExist(10)); : which check the value if it is exist or not.    
        newLinkedList.PrintElements(); : which print the elements of the Linked List.  


## Approach & Efficiency
<!-- What approach did you take? Why? What is the Big O space/time for this approach? -->
* AddToHead Method : it just create a node and make this node point to the head, and the head point to the new Node.  
The Big O space/time is  O(1).  
* ToString() Method : while loop to go through all the nodes and create string in this Format "{ a } -> { b } -> { c } -> NULL".   
The Big O space O(n) each time initialize a string / time is  O(n^2) :  we will go through whole linked list and each time concatenate the string.    
* ValueExist() Method : create pointer node equal to head node for moving through all nodes using a while loop to check the value for each node and return true if found else return false.   
The Big O space O(1) no need to store value/ time is  O(n) : the worset case we will go through whole linked list until find the value.  
* PrintElements() Method :  
The Big O space O(1) no need to store value/ time is  O(n) : we will go through whole linked list tp print the all values.  

## API
<!-- Description of each method publicly available to your Linked List -->  
* AddToHead Method : it just create a node and make this node point to the head, and the head point to the new Node.  
* ToString() Method : create an empty string to concatenate the all values in it and pointer node equal to head node for moving through  all nodes. Then go through the all nodes while the pointer not equal null and do the concatenate, make the pointer equal pointer.next. Then return the String.    
* ValueExist() Method : create pointer node equal to head node for moving through all nodes. Then go through the all nodes while the pointer not equal null and make the pointer equal pointer.next if the condition for the if statement false, and each time check if pointer.value equal to the value we search for then return true if found the value, and if finish the wihle return false.   
* PrintElements() Method : create pointer node equal to head node for moving through all nodes. Then go through the all nodes while the pointer not equal null and each time print the pointer.value and do pointer equal pointer.next.  