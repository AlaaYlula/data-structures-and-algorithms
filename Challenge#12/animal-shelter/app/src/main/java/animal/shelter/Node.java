package animal.shelter;

public class Node<T> {
    private T value;
    private String name;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }
    public Node(T value,String name) { // For Add Dog and Cat Objects
        this.value = value;
        this.next = null;
        this.name = name;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}
