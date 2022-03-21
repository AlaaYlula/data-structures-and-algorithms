/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package StackQueue;

import java.net.Inet4Address;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        System.out.println("/////////////////// Stack /////////////////");

        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.isEmpty());
        stack.push(5);
        stack.push(10);
        stack.push(15); // this is the top

        System.out.println(stack);
        System.out.println("Remove the top => "+stack.pop());
        System.out.println(stack);

        System.out.println("Return the top => "+stack.peek());

        System.out.println("/////////////////// Queue /////////////////");
        Queue<Integer> queue = new Queue<>();
        System.out.println(queue.isEmpty());
        queue.enqueue(5); // front
        queue.enqueue(10);
        queue.enqueue(15); // back

        System.out.println(queue);
        System.out.println("Remove the top => "+queue.dequeue());
        System.out.println(queue);
         System.out.println("Return the top => "+queue.peek());
        System.out.println("////////////////////////////////////");


    }
}