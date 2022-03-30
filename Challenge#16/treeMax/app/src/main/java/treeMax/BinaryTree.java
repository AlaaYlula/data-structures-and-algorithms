package treeMax;

import java.util.ArrayList;

public class BinaryTree{

    private BNode root;

    public BinaryTree() {
    }

    public BNode getRoot() {
        return root;
    }

    public void setRoot(BNode root) {
        this.root = root;
    }
    ////////////////////////// Challenege 16 ////////////////////////////
    public int Max_Value(){
        if(this.root == null){
            throw new IllegalArgumentException();
        }
        return Max_Value(this.root,this.root.getData());
    }
    public int Max_Value(BNode RootNode,int valueMax){
        if(RootNode == null)
            return valueMax;
        if(RootNode.getData() >= valueMax)
        {
            valueMax = RootNode.getData();
        }
        if(RootNode.getLeftNode() != null){
            valueMax = Max_Value(RootNode.getLeftNode(),valueMax);
        }
        if(RootNode.getRightNode() != null){
            valueMax = Max_Value(RootNode.getRightNode(),valueMax);
        }
        return valueMax;
    }

    //////////////////////////////////////////////////////
    // Root Left Right
    public ArrayList<Integer> PreOrder(){
        ArrayList<Integer> resultTree = new ArrayList<>();
        PreOrder(this.root,resultTree);

        return resultTree;
    }
    public ArrayList<Integer> PreOrder(BNode RootNode,ArrayList<Integer> resultTree){
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
    public ArrayList<Integer> InOrder(){
        ArrayList<Integer> resultTree = new ArrayList<>();
        InOrder(this.root,resultTree);
        return resultTree;
    }

    public ArrayList<Integer> InOrder(BNode RootNode , ArrayList<Integer> resultTree  ){
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
    public ArrayList<Integer> PostOrder(){
        ArrayList<Integer> resultTree = new ArrayList<>();
        PostOrder(this.root,resultTree);
        return resultTree;
    }
    public ArrayList<Integer> PostOrder(BNode RootNode,  ArrayList<Integer> resultTree ){
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
