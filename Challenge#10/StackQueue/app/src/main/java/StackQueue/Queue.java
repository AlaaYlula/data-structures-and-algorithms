package StackQueue;

import java.nio.BufferOverflowException;

public class Queue<T> {
    private final int QUEUE_SIZE = 10;
    private Node<T> front;
    private Node<T> back;
    private int size ;
    public Queue() {
        size = 0;
    }

    public Node<T> getFront() {
        return front;
    }

    public Node<T> getBack() {
        return back;
    }
////////////////////////////////////// Method class 10 //////////////////////////////
    // return if the Queue is empty or not
    public Boolean isEmpty(){
        return front == null;
    }
    // add Node to the back
    public void enqueue(T value){
        Node<T> newNode = new Node<>(value);
        if(isEmpty()){
            front = newNode;
            back = newNode;
            size++;
        }else{
            if(size < QUEUE_SIZE) {
             //   newNode.setNext(back);
                back.setNext(newNode);
                back = newNode;
                size++ ;
            }else{
                throw new BufferOverflowException();
            }
        }
    }
    // return the value from the front and then remove the node from the front >> If empty throw exception
 public T dequeue()  {
        if (isEmpty()){
            throw new IllegalArgumentException();
        }else{
            T valueTemp = front.getValue();
            front = front.getNext();
            size--;
            return valueTemp;
        }
 }
    // return the value from the front >> If empty throw exception
    public T peek() {
        if (isEmpty()){
            throw new IllegalArgumentException();
        }else {
            return front.getValue();
        }
    }
    @Override
    public String toString() {
        return "Queue{" +
                "front=" + front +
                ", back=" + back +
                '}';
    }
}
