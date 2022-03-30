package treeMax;

public class BNode {
    private int data;
    private BNode leftNode;
    private BNode rightNode;

    public BNode() {
    }

    public BNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public BNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BNode leftNode) {
        this.leftNode = leftNode;
    }

    public BNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }

}
