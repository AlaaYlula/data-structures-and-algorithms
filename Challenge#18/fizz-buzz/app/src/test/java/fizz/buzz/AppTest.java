/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package fizz.buzz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
    @Test void EmptyTree(){
        try {
            BinaryTree<Integer> tree = new BinaryTree<>();
            tree.fizzBuzz(tree);
            fail();
        }catch (IllegalArgumentException e){

        }
    }

    @Test void TreeOneElement(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setRoot(new Node<>(5));

        BinaryTree<String> result = tree.fizzBuzz(tree);

        BinaryTree<String> expected = new BinaryTree<>();
        expected.setRoot(new Node<>("Buzz"));

        System.out.println(expected);
        System.out.println(result);
        assertEquals(expected.getRoot().getData(),result.getRoot().getData());
    }
    @Test void TestFizzBuzz(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setRoot(new Node<>(5));
        tree.getRoot().setRightNode(new Node<>(15));
        tree.getRoot().getRightNode().setLeftNode(new Node<>(2));
        tree.getRoot().getRightNode().setRightNode(new Node<>(4));

        BinaryTree<String> result = tree.fizzBuzz(tree);

        BinaryTree<String> expected = new BinaryTree<>();
        expected.setRoot(new Node<>("Buzz"));
        expected.getRoot().setRightNode(new Node<>("FizzBuzz"));
        expected.getRoot().getRightNode().setLeftNode(new Node<>("2"));
        expected.getRoot().getRightNode().setRightNode(new Node<>("4"));

        System.out.println(expected);
        System.out.println(result);
        assertEquals(expected.getRoot().getData(),result.getRoot().getData());
        assertEquals(expected.getRoot().getRightNode().getData(),result.getRoot().getRightNode().getData());
        assertEquals(expected.getRoot().getRightNode().getLeftNode().getData(),result.getRoot().getRightNode().getLeftNode().getData());
        assertEquals(expected.getRoot().getRightNode().getRightNode().getData(),result.getRoot().getRightNode().getRightNode().getData());

    }
}