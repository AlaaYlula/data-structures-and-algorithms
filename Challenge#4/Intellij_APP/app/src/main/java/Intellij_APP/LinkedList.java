package Intellij_APP;

public class LinkedList<T> {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    /////////////////////// The Methods /////////////////
    public void AddToHead(T v){
        Node newNode = new Node(v);
        newNode.next = head;
        head= newNode;
        //  System.out.println(head.value);
    }
    public Boolean VlaueExist(T v){
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
    //Print
    public void PrintElements(){
        Node pointer = head ;
        while(pointer!=null){
            System.out.println(pointer.value);
            pointer = pointer.next;
        }
    }
}
