package tree;

import tree.Nodes.Node;

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

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
