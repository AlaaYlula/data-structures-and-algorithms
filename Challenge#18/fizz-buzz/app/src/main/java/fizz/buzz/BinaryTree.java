package fizz.buzz;

import java.util.ArrayList;

public class BinaryTree<T extends Comparable<T>>{

    private Node<T> root;

    public BinaryTree() {
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    // Root Left Right
    public ArrayList<T> PreOrder(){
        ArrayList<T> resultTree = new ArrayList<>();
        PreOrder(this.root,resultTree);

        return resultTree;
    }
    public ArrayList<T> PreOrder(Node<T> RootNode,ArrayList<T> resultTree){
        if (RootNode == null){
            return resultTree;
        }
        resultTree.add(RootNode.getData());
        if (RootNode.getLeftNode() != null){
            PreOrder(RootNode.getLeftNode(),resultTree);
        }
        if (RootNode.getRightNode() != null){
            PreOrder(RootNode.getRightNode(),resultTree);
        }
        return resultTree;
    }
    // Left Root Right
    public ArrayList<T> InOrder(){
        ArrayList<T> resultTree = new ArrayList<>();
        InOrder(this.root,resultTree);
        return resultTree;
    }

    public ArrayList<T> InOrder(Node<T> RootNode , ArrayList<T> resultTree  ){
        if (RootNode == null){
            return resultTree;
        }
        if (RootNode.getLeftNode() != null){
            InOrder(RootNode.getLeftNode(),resultTree);
        }
        resultTree.add(RootNode.getData());
        if (RootNode.getRightNode() != null){
            InOrder(RootNode.getRightNode(),resultTree);
        }
        return resultTree;
    }
    // Left Right Root
    public ArrayList<T> PostOrder(){
        ArrayList<T> resultTree = new ArrayList<>();
        PostOrder(this.root,resultTree);
        return resultTree;
    }
    public ArrayList<T> PostOrder(Node<T> RootNode,  ArrayList<T> resultTree ){
        if (RootNode == null){
            return resultTree;
        }
        if (RootNode.getLeftNode() != null){
            PostOrder(RootNode.getLeftNode(),resultTree);
        }
        if (RootNode.getRightNode() != null){
            PostOrder(RootNode.getRightNode(),resultTree);
        }
        resultTree.add(RootNode.getData());
        return resultTree;
    }

    public BinaryTree<String> fizzBuzz(BinaryTree<Integer> InputTree){
        if(InputTree.root == null){
            throw new IllegalArgumentException();
        }
            BinaryTree<String> binaryTreeResult = new BinaryTree<>();
            binaryTreeResult.root = fizzBuzz(InputTree.getRoot());
        return  binaryTreeResult;
    }

    public Node<String> fizzBuzz(Node<Integer> node){
       // The break point
        if(node == null){
            return null;
        }else {
            Node<String> newNode = new Node<>();
            int value = node.getData();
            if ((value % 5) == 0 && (value % 3) == 0) {
                newNode.setData("FizzBuzz");
               // binaryTreeResult.setRoot(newNode);
            } else if ((value % 5) == 0) {
                newNode.setData("Buzz");
                //binaryTreeResult.setRoot(newNode);
            } else if ((value % 3) == 0) {
                newNode.setData("fizz");
               // binaryTreeResult.setRoot(newNode);
            } else {
                newNode.setData(Integer.toString(value));
                //binaryTreeResult.setRoot(newNode);
            }
            // To go through the left and the right of this node
            newNode.setLeftNode(fizzBuzz(node.getLeftNode()));
            newNode.setRightNode(fizzBuzz(node.getRightNode()));
            return newNode;
        }
    }
    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}