package tree;


import tree.Nodes.Node;

import java.util.ArrayList;


public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    private Node<T> root;
    private int size;

    public BinarySearchTree() {
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private Boolean isEmpty(){
        return this.root == null;
    }
    // Insert Values :
    public void add(T value){
       if(this.isEmpty()){
           Node<T> newNode = new Node<>(value) ;
           this.root = newNode;
           ++size;
       }else{
            add(value,this.root);
       }
       }
    public void add(T value,Node<T> RootNode){
        Node<T> newNode = new Node<>(value);// ( has data, left and right )
        if(value.compareTo(RootNode.getData()) < 0 ){ // the value less than the root >> Go Left
            if(RootNode.getLeftNode() == null ){ // can add here
                RootNode.setLeftNode(newNode);
                ++size;
            }else{ // no space here so recursive again
                this.add(value,RootNode.getLeftNode());
            }
        }else if(value.compareTo(RootNode.getData()) > 0){ // the value greater than the root >> Go right
            if(RootNode.getRightNode() == null){
                RootNode.setRightNode(newNode);
                ++size;
            }else{
                this.add(value,RootNode.getRightNode());
            }
        }
    }

    public boolean contains(T value){
        if(this.root == null){
            System.out.println("The tree is Empty");
            return false;
        }
        return contains(this.root,value);
    }
    private boolean contains(Node<T> RootNode,T value) {
        if (RootNode == null) {
            return false;
        }
        if (value.compareTo(RootNode.getData()) == 0)
                return true;
        else if (value.compareTo(RootNode.getData()) < 0)
                return contains(RootNode.getLeftNode(), value);
       //if (value.compareTo(RootNode.getData()) > 0)
                return contains(RootNode.getRightNode(), value);

    }
    ///////////////////////////////////////////
      // Root Left Right
    public ArrayList<T> PreOrder(){
        ArrayList<T> resultTree = new ArrayList<>();
        PreOrder(this.root,resultTree);

        return resultTree;
    }
    public ArrayList<T> PreOrder(Node<T> RootNode, ArrayList<T> resultTree){
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
    public  ArrayList<T> PostOrder(){
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
    //////////////////////////////////////////

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }
}

