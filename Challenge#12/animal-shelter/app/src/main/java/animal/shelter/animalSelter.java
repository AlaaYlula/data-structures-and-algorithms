package animal.shelter;

import java.util.EmptyStackException;
import java.util.Locale;

public class animalSelter{
    private  Queue<Animal> catQueue;
    private  Queue<Animal> dogQueue;

    public animalSelter() {
        catQueue = new Queue<>();
        dogQueue = new Queue<>();
    }

    public Queue<Animal> getCatQueue() {
        return catQueue;
    }

    public Queue<Animal> getDogQueue() {
        return dogQueue;
    }

    public void setCatQueue(Queue<Animal> catQueue) {
        this.catQueue = catQueue;
    }

    public void setDogQueue(Queue<Animal> dogQueue) {
        this.dogQueue = dogQueue;
    }

public void enqueue(Animal animal){

    if (animal.getClass().getSimpleName().equals("Cat")){
        catQueue.enqueue(animal);
    }else if (animal.getClass().getSimpleName().equals("Dog")){
        dogQueue.enqueue(animal);
    }else{
        throw new IllegalArgumentException();
    }
}
    public Animal dequeue(String pref){
        if(pref.toLowerCase(Locale.ROOT).equals("dog")){
            // No Need because the dequeue Method check if it is Empty
//            if (dogQueue.isEmpty()){
//                throw new EmptyStackException();
//            }
            return dogQueue.dequeue();
        }else if(pref.toLowerCase(Locale.ROOT).equals("cat")){
            return catQueue.dequeue();
        }
        return null;
    }

    @Override
    public String toString() {
        String strDog="";
        String strCat="";

        Node<Animal> pointerDog = dogQueue.getFront();
        Node<Animal> pointerCat = catQueue.getFront();
        while (pointerDog != null){
            strDog = strDog + "{ " + pointerDog.getValue() + " } => ";
            pointerDog = pointerDog.getNext();
        }
        while (pointerCat != null){
            strCat = strCat + "{ " + pointerCat.getValue() + " } => ";
            pointerCat = pointerCat.getNext();
        }
        return "The Cat Queue => "+strCat + "\n" + "The Dog Queue => " + strDog ;
    }

//    @Override
//    public String toString() {
//        return "animalSelter{" +
//                "catQueue=" + catQueue +
//                ", dogQueue=" + dogQueue +
//                '}';
//    }
}
