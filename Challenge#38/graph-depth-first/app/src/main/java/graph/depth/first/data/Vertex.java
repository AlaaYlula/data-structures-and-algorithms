package graph.depth.first.data;

import java.util.Objects;

public class Vertex <T>{
    private T data;
    private Edge<T> edge;

    public Vertex(T data) {
        this.data = data;
        this.edge = new Edge<>();
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Edge<T> getEdge() {
        return edge;
    }

    public void setEdge(Edge<T> edge) {
        this.edge = edge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
//        if(edge.isEmpty()){
//            return "Vertex{" +
//                    "data=" + data +
//                    '}';
//        }
        return "Vertex{" +
                "data=" + data +
                ", edge=" + edge +
                '}';
    }
}
