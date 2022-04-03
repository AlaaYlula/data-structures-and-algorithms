package breadth_first;

    public class Node {
        private    int data;
        private Node leftNode;
        private Node rightNode;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
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
