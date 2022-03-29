/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package tree;

import org.junit.jupiter.api.Test;
import tree.Nodes.Node;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
   }
//    Can successfully instantiate an empty tree
      @Test void EmptyTreeTest(){
        BinaryTree<String> binaryTree = new BinaryTree<>();
        assertTrue(binaryTree.getRoot() == null);
      }
//    Can successfully instantiate a tree with a single root node
    @Test void RootNodeTest(){
        BinaryTree<String> binaryTree = new BinaryTree<>();
        binaryTree.setRoot(new Node<>("A"));
        assertTrue(binaryTree.getRoot().getData().equals("A"));

    }
//    For a Binary Search Tree, can successfully add a left child and right child properly to a node
    @Test void addChildNode(){
        BinaryTree<String> binaryTree = new BinaryTree<>();
        binaryTree.setRoot(new Node<>("A"));
        binaryTree.getRoot().setLeftNode(new Node<>("L"));
        binaryTree.getRoot().setRightNode(new Node<>("A"));
        assertTrue(binaryTree.getRoot().getLeftNode().getData().equals("L"));
        assertTrue(binaryTree.getRoot().getRightNode().getData().equals("A"));
    }

//    Can successfully return a collection from a preorder traversal
    @Test void preorderTest(){
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        //Root
        binaryTree.setRoot(new Node<Integer>(1));
        //level 1
        binaryTree.getRoot().setLeftNode(new  Node<Integer >(2));
        binaryTree.getRoot().setRightNode(new  Node<Integer >(5));
        //level 2
        binaryTree.getRoot().getLeftNode().setLeftNode(new Node<Integer>(3));
        binaryTree.getRoot().getLeftNode().setRightNode(new Node<Integer>(4));
        binaryTree.getRoot().getRightNode().setLeftNode(new Node<Integer>(6));
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        assertTrue(binaryTree.PreOrder().equals(array));

    }
//    Can successfully return a collection from an inorder traversal
    @Test void inorderTest(){
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        //Root
        binaryTree.setRoot(new Node<Integer>(1));
        //level 1
        binaryTree.getRoot().setLeftNode(new  Node<Integer >(2));
        binaryTree.getRoot().setRightNode(new  Node<Integer >(5));
        //level 2
        binaryTree.getRoot().getLeftNode().setLeftNode(new Node<Integer>(3));
        binaryTree.getRoot().getLeftNode().setRightNode(new Node<Integer>(4));
        binaryTree.getRoot().getRightNode().setLeftNode(new Node<Integer>(6));
        ArrayList<Integer> array = new ArrayList<>();
        array.add(3);
        array.add(2);
        array.add(4);
        array.add(1);
        array.add(6);
        array.add(5);
        assertTrue(binaryTree.InOrder().equals(array));

    }
//    Can successfully return a collection from a postorder traversal
    @Test void postorderTest(){
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        //Root
        binaryTree.setRoot(new Node<Integer>(1));
        //level 1
        binaryTree.getRoot().setLeftNode(new  Node<Integer >(2));
        binaryTree.getRoot().setRightNode(new  Node<Integer >(5));
        //level 2
        binaryTree.getRoot().getLeftNode().setLeftNode(new Node<Integer>(3));
        binaryTree.getRoot().getLeftNode().setRightNode(new Node<Integer>(4));
        binaryTree.getRoot().getRightNode().setLeftNode(new Node<Integer>(6));
        ArrayList<Integer> array = new ArrayList<>();
        array.add(3);
        array.add(4);
        array.add(2);
        array.add(6);
        array.add(5);
        array.add(1);
        assertTrue(binaryTree.PostOrder().equals(array));

    }
//    Returns true	false for the contains method, given an existing or non-existing node value
    @Test void containsTest(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(10);
        binarySearchTree.add(5);
        binarySearchTree.add(20);
        assertTrue(binarySearchTree.contains(20));
        assertTrue(!binarySearchTree.contains(0));
    }
}
