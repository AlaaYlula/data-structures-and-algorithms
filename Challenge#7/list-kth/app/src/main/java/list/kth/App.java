/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package list.kth;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.AddToHead(1);
        linkedList.Append(3);
        linkedList.Append(8);
        linkedList.Append(2);
        linkedList.Append(10);

        System.out.println(linkedList.ToString());
        System.out.println("Index 0 value => "+linkedList.kthFromEnd(0));
        System.out.println("Index 2 value => "+linkedList.kthFromEnd(2));
       // System.out.println(linkedList.kthFromEnd(6)); // this will throw an exception
        System.out.println("The Middle value => "+linkedList.TheMiddlevalue());

       // System.out.println(linkedList.LinkedListLength());
    }
}