package list.insertions;

public class LinkedList<T> {
    Node head;

    public LinkedList() {
        this.head = null;
    }
    /////////////////////// The Methods class06 /////////////////
    public void Append(T v){

        if (head == null ){
            AddToHead(v);
        }else {
            Node newNode = new Node(v);
            Node pointer = head;
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
            Node newNode = new Node(newValue);
            Node pointer = head;
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
    public void InsertAfter(T v,T newValue){

        if (head == null ) {
            System.out.println("The Linked List is Empty");
        }else if(!ValueExist(v)){
            //throw new InvalidDnDOperationException();
            throw new IllegalArgumentException("The value "+v+" you want to Insert After not in the Linked List");

            // System.out.println("The value "+v+" you want to Insert After not in the Linked List");
        }else {

            Node newNode = new Node(newValue);
            Node pointer = head;
            while (pointer != null) {
                if (pointer.value == v) {
                    newNode.next = pointer.next;
                    pointer.next= newNode;
                    break;
                }
                pointer = pointer.next;
            }
        }

    }
    /////////////////////// The Methods class05 /////////////////
    public void AddToHead(T v){
        Node newNode = new Node(v);
        newNode.next = head;
        head= newNode;
        //  System.out.println(head.value);
    }
    public Boolean ValueExist(T v){
        Node pointer = head;
        while(pointer!=null){
            if(pointer.value == v){
                return true;
            }
            pointer = pointer.next;
        }
        return  false ;
    }
    // ToString "{ a } -> { b } -> { c } -> NULL"
    public String ToString(){
        String LinkedListString ="";
        Node pointer = head;
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
        Node pointer = head ;
        while(pointer!=null){
            System.out.println(pointer.value);
            pointer = pointer.next;
        }
    }
}
