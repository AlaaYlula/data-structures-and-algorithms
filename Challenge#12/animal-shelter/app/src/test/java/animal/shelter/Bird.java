package animal.shelter;

public class Bird extends Animal{
    Node<String> bird;


    public Bird( String name) {
        bird = new Node<>(this.getClass().getSimpleName(),name);// Changed the Node Constructor
    }

    public Node<String> getBird() {
        return bird;
    }

    public void setBird(Node<String> bird) {
        this.bird = bird;
    }

    @Override
    public String toString() {
        return " { "+ bird.getValue() + " : " + bird.getName() + " } ";

    }
}
