package breadth_first.Queue;

public class QNode<T> {
    private T value;
    private QNode<T> next;

    public QNode(T value) {
        this.value = value;
        this.next = null;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(QNode<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public QNode<T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Queue Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}