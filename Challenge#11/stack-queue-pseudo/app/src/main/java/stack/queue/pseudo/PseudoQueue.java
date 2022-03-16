package stack.queue.pseudo;

import java.util.EmptyStackException;

public class PseudoQueue<T> {

    private Stack<T> stackIn = new Stack<>();
    private Stack<T> stackOut = new Stack<>();

    public PseudoQueue() {
    }

    public Stack<T> getStackIn() {
        return stackIn;
    }

    public Stack<T> getStackOut() {
        return stackOut;
    }

    //enqueue
    //Arguments: value
    //Inserts value into the PseudoQueue, using a first-in, first-out approach.
    public void enqueue(T value){
        this.stackIn.push(value);
        System.out.println("Add => "+ value);
    }
    // dequeue
    //Arguments: none
    //Extracts a value from the PseudoQueue, using a first-in, first-out approach.h
    public T dequeue() {
        if (stackIn.isEmpty()) {
            throw new EmptyStackException();
        } else if (stackIn.getTop().getNext() == null) {
             return stackIn.pop();
        } else {
            while (!stackIn.isEmpty()) {
                //  System.out.println("Last in Stack : "+stackIn.peek());
                stackOut.push(stackIn.peek());
                stackIn.pop();
            }
//            for (int i = StackLength(stackIn); i > 0 ; i--) {
//                stackOut.push(stackIn.peek());
//                stackIn.pop();
//            }
            T valueRemoved = stackOut.pop();
            while (!stackOut.isEmpty()) {
                stackIn.push(stackOut.peek());
                stackOut.pop();
            }
//            for (int i = StackLength(stackOut); i >0 ; i--) {
//                stackIn.push(stackOut.peek());
//                stackOut.pop();
//            }
            // System.out.println("Remove => " + valueRemoved);
            return valueRemoved;
        }
    }
    public int StackLength(Stack<T> stack){
        Node<T> pointer = stack.getTop();
        int length = 0 ; 
        while (pointer!=null){
            length++;
            pointer = pointer.getNext();
        }
        return length;
    }
    @Override
    public String toString() {
        String str = "";
        Node<T> pointer = stackIn.getTop();
        while (pointer != null){
            str = str + " { " + pointer.getValue() + " } => ";
            pointer = pointer.getNext();
        }
        return "Back => " + str + " Front ";
    }
}
