/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Intellij_APP;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
       // System.out.println(new App().getGreeting());
        LinkedList<Integer> newLinkedList = new LinkedList();
        newLinkedList.AddToHead(5);
        newLinkedList.AddToHead(2);
        newLinkedList.AddToHead(10);

        System.out.println(newLinkedList.ToString());
        System.out.println(newLinkedList.VlaueExist(10));
        newLinkedList.PrintElements();
    }
}
