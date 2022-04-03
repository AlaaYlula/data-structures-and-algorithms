package breadth_first;

import breadth_first.Queue.Queue;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree extends Tree {

    private Node root;

    public BinaryTree() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    ////////////////////////////////////////////////
    public ArrayList<Integer> breadthFirst(){
        ArrayList<Integer> resultList = new ArrayList<>();
        Queue<Node> queue = new Queue<>();
            if(root != null){ // if the root not null add it to the Queue
                queue.enqueue(root);
                return breadthRecursion(queue,resultList);
            }
        return null;
    }
    public static ArrayList<Integer> breadthRecursion(Queue<Node> queue,ArrayList<Integer> resultList) {
        if (!queue.isEmpty()) { // if the queue is not empty dequeue and add it to the list and check the left and right
            Node node = queue.dequeue();
            resultList.add(node.getData());

            if (node.getLeftNode() != null) { // if the root has left node then enqueue the left
                queue.enqueue(node.getLeftNode());
            }
            if (node.getRightNode() != null) {// if the root has right node then enqueue the right
                queue.enqueue(node.getRightNode());
            }
            return breadthRecursion(queue, resultList);
        }
        return resultList;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Root Left Right
    public ArrayList PreOrder(){
        ArrayList resultTree = new ArrayList();
        PreOrder(this.root,resultTree);

        return resultTree;
    }
    public ArrayList PreOrder(Node RootNode,ArrayList resultTree){
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
    public ArrayList InOrder(){
        ArrayList resultTree = new ArrayList<>();
        InOrder(this.root,resultTree);
        return resultTree;
    }

    public ArrayList InOrder(Node RootNode , ArrayList resultTree  ){
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
    public ArrayList PostOrder(){
        ArrayList resultTree = new ArrayList<>();
        PostOrder(this.root,resultTree);
        return resultTree;
    }
    public ArrayList PostOrder(Node RootNode,  ArrayList resultTree ){
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
