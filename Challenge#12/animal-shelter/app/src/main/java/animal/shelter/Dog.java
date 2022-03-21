package animal.shelter;

public class Dog extends Animal{
    Node<String> dog;

    public Dog( String name) {
        dog = new Node<>(this.getClass().getSimpleName(),name); // Changed the Node Constructor
    }

    public Node<String> getDog() {
        return dog;
    }

    public void setDog(Node<String> dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return " { "+ dog.getValue() + " : " + dog.getName() + " } ";

    }
}
