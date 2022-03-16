package stack.queue.pseudo;

public class Stack<T> {
    private Node<T> top;

    public Stack() {
        this.top = null;
    }

    public Node<T> getTop() {
        return top;
    }
    //////////////////////////// Methods Class 10 /////////////////////////
    // return if the Stack is empty or not
    public Boolean isEmpty(){
        return top == null;
    }
    // add the value to the top
    public void push(T value){
        Node<T> newNode = new Node<>(value);
        if (isEmpty()){
            top = newNode;
        }else{
            newNode.setNext(top);
            top = newNode;
        }
    }
    // return the value from the top and then remove the node from the top >> If empty throw exception
    public T pop()  {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            T valueTemp = top.getValue();
            top = top.getNext();
            return valueTemp;
        }
    }
    // return the value from the top >> If empty throw exception
    public T peek()  {
        if (isEmpty()){
            throw new IllegalArgumentException();
        }else {
            return top.getValue();
        }
    }

    @Override
    public String toString() {
        return "Stack{" +
                "top=" + top +
                '}';
    }
}
