/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package treeMax;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
//////////////////////////// Binary Tree /////////////////////

    @Test void EmptyBTree(){
        try{
            BinaryTree  binaryTree= new BinaryTree();
            System.out.println(binaryTree.Max_Value());
            fail("The Tree is Empty ");
        }catch (IllegalArgumentException e){

        }
    }
    @Test void OneElementBTree(){
        BinaryTree  binaryTree= new BinaryTree();
        binaryTree.setRoot(new BNode(1));
        assertTrue(binaryTree.Max_Value() == 1);
    }
    @Test void RootIsMaxBTree(){
        BinaryTree  binaryTree= new BinaryTree();
        binaryTree.setRoot(new BNode(10));
        binaryTree.getRoot().setRightNode(new BNode(1));

        assertTrue(binaryTree.Max_Value() == 10);
    }
    @Test void MaxBTree(){
        BinaryTree  binaryTree= new BinaryTree();
        binaryTree.setRoot(new BNode(10));
        binaryTree.getRoot().setRightNode(new BNode(1));
        binaryTree.getRoot().setLeftNode(new BNode(11));

        binaryTree.getRoot().getRightNode().setRightNode(new BNode(20));
        binaryTree.getRoot().getLeftNode().setRightNode(new BNode(0));

        assertTrue(binaryTree.Max_Value() == 20);
    }
//////////////////////////// Binary Search Tree /////////////////////
    @Test void EmptyTree(){
        try{
            BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
            System.out.println(binarySearchTree.Max_Value());
            fail("The Tree is Empty ");
        }catch (IllegalArgumentException e){

        }
    }
    @Test void OneElementTree(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(100);
        assertTrue(binarySearchTree.Max_Value().equals(100));
    }
    @Test void RootIsMaxTree(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(100);
        binarySearchTree.add(10);

        assertTrue(binarySearchTree.Max_Value().equals(100));
    }
    @Test void MaxTree(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(100);
        binarySearchTree.add(200);
        binarySearchTree.add(300);
        binarySearchTree.add(150);
        binarySearchTree.add(400);

        assertTrue(binarySearchTree.Max_Value().equals(400));
    }
}