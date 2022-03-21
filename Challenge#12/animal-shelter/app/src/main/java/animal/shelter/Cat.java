package animal.shelter;

import org.checkerframework.checker.units.qual.C;

public class Cat extends  Animal{
    Node<String> cat;


    public Cat( String name) {
        cat = new Node<>(this.getClass().getSimpleName(),name);// Changed the Node Constructor
    }

    public Node<String> getCat() {
        return cat;
    }

    public void setCat(Node<String> cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return " { "+ cat.getValue() + " : " + cat.getName() + " } ";

    }
}
