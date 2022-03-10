package list.zip;

public class LinkedList<T> {
    Node<T> head;

    public LinkedList() {
        this.head = null;
    }
    /////////////////////// The Methods class08 /////////////////
    public  LinkedList<T> LinkedListZip(LinkedList<T> one , LinkedList<T> two){
        Node<T> move1 = one.head; // 2 nodes to connect the nodes in each Linked List
        Node<T> move2 = two.head;

        if(one.head == null && two.head == null){
            return  null;
        }else if(two.head == null) {
            return one;
        }else if(one.head == null){
            return two;
        }else if(one.LinkedListLength() == 1 && two.LinkedListLength() == 1) {
            one.head.next = two.head;
            return one;
        }else {
            Node<T> next1; // 2 nodes to keep track with the next elements after move the moves pointer
            Node<T> next2;
            while (move1.next != null && move2.next != null) {
                next1 = move1.next;
                next2 = move2.next;

                move1.next = move2;
                move2.next = next1;

                 move1= next1;
                 move2 = next2;
            }
            if (move1.next == null) {
                move1.next = move2;
            }
            if (move2.next == null) {
                move2.next = move1.next;
                move1.next = move2;
               // move2.next = move1;
            }

            return one;
        }
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
