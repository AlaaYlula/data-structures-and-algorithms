package breadth_first;

import breadth_first.Queue.Queue;

import java.util.ArrayList;

public class BinarySearchTree extends Tree {
    private Node root;
    private int size;

    public BinarySearchTree() {
    }

    public Node getRoot() {
        return root;
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
    public void add(int value){
        if(this.isEmpty()){
            Node newNode = new Node(value) ;
            this.root = newNode;
            ++size;
        }else{
            add(value,this.root);
        }
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
    public void add(int value,Node RootNode){
        Node newNode = new Node(value);// ( has data, left and right )
        //if(value.compareTo(RootNode.getData()) < 0 ){ // the value less than the root >> Go Left
            if(value < RootNode.getData()){
            if(RootNode.getLeftNode() == null ){ // can add here
                RootNode.setLeftNode(newNode);
                ++size;
            }else{ // no space here so recursive again
                this.add(value,RootNode.getLeftNode());
            }
        }else if(value > RootNode.getData()){//if(value.compareTo(RootNode.getData()) > 0){ // the value greater than the root >> Go right
            if(RootNode.getRightNode() == null){
                RootNode.setRightNode(newNode);
                ++size;
            }else{
                this.add(value,RootNode.getRightNode());
            }
        }
    }

    public boolean contains(int value){
        if(this.root == null){
            System.out.println("The tree is Empty");
            return false;
        }
        return contains(this.root,value);
    }
    private boolean contains(Node RootNode,int value) {
        if (RootNode == null) {
            return false;
        }
       // if (value.compareTo(RootNode.getData()) == 0)
        if(value == RootNode.getData())
            return true;
        else if(value < RootNode.getData())//if (value.compareTo(RootNode.getData()) < 0)
            return contains(RootNode.getLeftNode(), value);
        //if (value.compareTo(RootNode.getData()) > 0)
        return contains(RootNode.getRightNode(), value);

    }
    ///////////////////////////////////////////
    // Root Left Right
    public ArrayList PreOrder(){
        ArrayList resultTree = new ArrayList();
        PreOrder(this.root,resultTree);

        return resultTree;
    }
    public ArrayList PreOrder(Node RootNode, ArrayList resultTree){
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
        ArrayList resultTree = new ArrayList();
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
    public  ArrayList PostOrder(){
        ArrayList resultTree = new ArrayList();
        PostOrder(this.root,resultTree);
        return resultTree;
    }
    public ArrayList PostOrder(Node RootNode, ArrayList resultTree ){
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
