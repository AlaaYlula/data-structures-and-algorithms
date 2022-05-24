package graph.data;

public class Edge<T> {
    Vertex<T> node1;
    Vertex<T> node2;

    int weight;

    public Edge(Vertex<T> node1, Vertex<T> node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "{" +
                " weight=" + weight +
                '}';
    }
}
