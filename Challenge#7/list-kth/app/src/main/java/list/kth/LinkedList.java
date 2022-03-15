package list.kth;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedList<T> {
    Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public Node<T> reverseLinkedList1(Node<T> head){
        Node<T> current = head;
        Node<T> nextNode;
        Node<T> Prev = null;
        while (current != null){
            nextNode = current.next;
            current.next = Prev;
            Prev = current;
            current = nextNode;
        }
        this.head = Prev;
        return this.head;
    }
    public Boolean isPalindrome(Node<T> head){
        Boolean flag = true;
        ArrayList<T> arrayList = new ArrayList<>();
        Node<T> pointer = head ;
        while (pointer != null){
            arrayList.add(pointer.value);
            pointer = pointer.next;
        }
        System.out.println(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) != arrayList.get(arrayList.size()-1 - i)){
                flag = false;
            }
        }
        return flag;
    }
    // https://stackoverflow.com/questions/4984071/how-do-you-copy-a-linked-list-into-another-list
    public Node<T> CopyLinkedList(Node<T> head){
        if (head == null) return null;

        Node<T> current = new Node<T>(head.value);

        Node<T> copyLinkedList = current;
        Node<T> previous = current;

        head = head.next;

        // keep moving until we hit a null reference which is the end.
        while (head != null)
        {
            current = new Node(head.value); // create a new node every time as we move forward.
            previous.next = current; // set previous node's next to current node as previous node itself is one step behind the current.
            previous = previous.next; // move prev pointer forward
            head = head.next; // move head pointer forward as well
        }

        // return the reference to copyList.
        // copyList and previous both started off pointing to the currentNode, then in the while loop
        // previous kept moving forward till all nodes are copied.
        // copyList reference never moved from its position so its still pointing at the start.
        return copyLinkedList;
    }
    /////////////////////// The Methods class07 /////////////////
    public int LinkedListLength(){
        int size=0;
        Node<T> pointer = this.head;
        if(this.head == null){
            return 0;
        }else {
            while (pointer != null) {
                size++;
                pointer = pointer.next;
            }
        }
        return size;
    }
   // Return the node’s value that is k places from the tail of the linked list.
    public T kthFromEnd(int kthIdx){
        int size = LinkedListLength();
        int elementNumber = size - kthIdx;
        int element = 1;
            if (size == 0) {
                System.out.println(" The Linked List is Empty ");
            } else if (kthIdx > size || kthIdx < 0) {
                System.out.println(" The Linked List not has this index ");
            } else {
                Node<T> pointer = this.head;
                while (pointer != null) {
                    if (element == elementNumber) {
                        return pointer.value;
                    }else {
                        element++;
                        pointer = pointer.next;
                    }
                }
            }
         throw new IllegalArgumentException();
    }

    // Return the node’s value that is k places from the head of the linked list.
    public T kthFromFirst(int kthIdx){
        int size = LinkedListLength();
        int kth = 0;
        if(size == 0){
            System.out.println(" The Linked List is Empty ");
        }else if (kth > size){
            System.out.println(" The Linked List not has this index ");
        }else {
             Node<T> pointer = this.head;
            while (pointer!=null){
                if(kth == kthIdx)
                {
                    return pointer.value;
                }
                kth++;
                pointer = pointer.next;
            }
        }
        throw new IllegalArgumentException();
    }
   // Return the node’s value at the middle of the Linked List.
   public T TheMiddlevalue(){
       int size = LinkedListLength();
       int idx = size / 2 ;
       int element = 1;
       Node<T> pointer = this.head;
       if(size == 0){
           System.out.println(" The Linked List is Empty ");
       }else {
            if(size % 2 != 0 ){
                while(pointer!=null){
                    if((idx+1) == element ){
                        return  pointer.value;
                    }
                    pointer = pointer.next;
                    element++;
                }
            }else{
                while(pointer!=null){
                    if((idx) == element ){
                        return  pointer.value;
                    }
                    pointer = pointer.next;
                    element++;
                }
            }
       }
       throw new IllegalArgumentException();
   }
    /////////////////////// The Methods class06 /////////////////
    public void Append(T value){

        if (head == null ){
            AddToHead(value);
        }else {
            Node<T> newNode = new Node<>(value);
            Node<T> pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            newNode.next = null;
            pointer.next = newNode;
        }

    }
    public void InsertBefore(T v,T newValue){
        if (head == null ) {
            System.out.println("The Linked List is Empty");
        } else if ( head.value == v) {
            AddToHead(newValue);
        }else if(!ValueExist(v)) {
            System.out.println("The value "+v+" you want to Insert Before not in the Linked List");
        }else
        {
            Node<T> newNode = new Node<>(newValue);
            Node<T> pointer = head;
            while (pointer != null) {
                if (pointer.next.value == v) {
                    newNode.next = pointer.next;
                    pointer.next = newNode;
                    break;
                }
                pointer = pointer.next;
            }
        }
    }
    public void InsertAfter(T value,T newValue){

        if (head == null ) {
            System.out.println("The Linked List is Empty");
        }else if(!ValueExist(value)){
            //throw new InvalidDnDOperationException();
            throw new IllegalArgumentException("The value "+value+" you want to Insert After not in the Linked List");

            // System.out.println("The value "+value+" you want to Insert After not in the Linked List");
        }else {

            Node<T> newNode = new Node<T>(newValue);
            Node<T> pointer = head;
            while (pointer != null) {
                if (pointer.value == value) {
                    newNode.next = pointer.next;
                    pointer.next= newNode;
                    break;
                }
                pointer = pointer.next;
            }
        }

    }
    /////////////////////// The Methods class05 /////////////////
    public void AddToHead(T value){
        Node<T> newNode = new Node<T>(value);
        newNode.next = head;
        head= newNode;
        //  System.out.println(head.value);
    }
    public Boolean ValueExist(T value){
        Node<T> pointer = head;
        while(pointer!=null){
            if(pointer.value == value){
                return true;
            }
            pointer = pointer.next;
        }
        return  false ;
    }
    // ToString "{ a } -> { b } -> { c } -> NULL"
    public String ToString(){
        String LinkedListString ="";
        Node<T> pointer = head;
        while(pointer!=null){
            LinkedListString = LinkedListString+"{ "+pointer.value + " } -> ";
            pointer = pointer.next;
        }
        return LinkedListString+"NULL";
    }

//    @Override
//    public String toString() {
//        return "LinkedList{" +
//                "head=" + head +
//                '}';
//    }

    //Print
    public void PrintElements(){
        Node<T> pointer = head ;
        while(pointer!=null){
            System.out.println(pointer.value);
            pointer = pointer.next;
        }
    }
}
