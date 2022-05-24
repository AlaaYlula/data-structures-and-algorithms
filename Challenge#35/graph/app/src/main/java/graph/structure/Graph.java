package graph.structure;

import graph.data.Edge;
import graph.data.Vertex;

import java.util.*;

public class Graph<T> {

    private Map<Vertex<T>, List<Vertex<T>>> adjVertices;

    public Graph() {
        this.adjVertices = new HashMap<>();
    }

    //Add a node to the graph
    public Vertex<T> addNode(T value){
        Vertex<T> vertex = new Vertex<>(value);
        adjVertices.putIfAbsent(vertex,new ArrayList<>());

        return vertex;
    }

    //Adds a new edge between two nodes in the graph
    public void addEdge(Vertex<T> node1 , Vertex<T> node2,int weight){
        // Both nodes should already be in the Graph
        if(adjVertices.containsKey(node1) && adjVertices.containsKey(node2)){
            Edge<T> edge = new Edge<>(node1,node2,weight);
            adjVertices.get(node1).add(node2);
            List<Edge<T>> edges = node1.getEdge();
            edges.add(edge);
            node1.setEdge(edges);

            adjVertices.get(node2).add(node1);
            List<Edge<T>> edges2 = node2.getEdge();
            edges2.add(edge);
            node2.setEdge(edges2);

        }
    }
    public void addEdge(Vertex<T> node1 , Vertex<T> node2){
        // Both nodes should already be in the Graph
        if(adjVertices.containsKey(node1) && adjVertices.containsKey(node2)){
            adjVertices.get(node1).add(node2);
            adjVertices.get(node2).add(node1);
        }
    }
    //Returns all of the nodes in the graph as a collection (set, list, or similar)
    public Set<Vertex<T>> getNodes(){
        if(this.size() == 0){
            return null;
        }
        return adjVertices.keySet();
    }

    //Returns a collection of edges connected to the given node
    public List<Vertex<T>> getNeighbors(Vertex<T> node){
        if(adjVertices.containsKey(node)){
            return adjVertices.get(node);
        }
        return null;
    }

    //Returns the total number of nodes in the graph
    public int size(){
        return adjVertices.size();
    }

    public String printGraph() {
        StringBuilder strBuilder = new StringBuilder();
        for (Vertex vertex : adjVertices.keySet()) {
            strBuilder.append(vertex);
            strBuilder.append(adjVertices.get(vertex));
            strBuilder.append(" / ");
        }

        return strBuilder.toString();
    }

    // Breadth First
    public Set<T> BFS(Graph<T> graph,T root){
        Set<T> visited = new LinkedHashSet<>();
        Queue<T> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()){
            T vertex = queue.poll();
            for(Vertex<T> v : graph.getAdjVertices(vertex)){
                if(!visited.contains(v.getData()))
                {
                    if(!queue.contains(v.getData()))
                        queue.add(v.getData());
                }
            }
            visited.add(vertex);

        }
        return visited;
    }

    public List<Vertex<T>> getAdjVertices(T data){
        return adjVertices.get(new Vertex<>(data));
    }

    // Remove Node
    public void removeVertex(T data){
        Vertex<T> vertex = new Vertex<>(data);
        adjVertices.values().forEach(list -> list.remove(vertex));
        adjVertices.remove(vertex);

    }

    // Remove Edge
    public void removeEdge(T data1,T data2){
        Vertex<T> vertex1 = new Vertex<>(data1);
        Vertex<T> vertex2 = new Vertex<>(data2);

        List<Vertex<T>> edgeList1 = adjVertices.get(vertex1);
        List<Vertex<T>> edgList2 = adjVertices.get(vertex2);

        if(!edgeList1.isEmpty()) {
            edgeList1.remove(vertex2);
        }

        if(!edgList2.isEmpty()) {
            edgList2.remove(vertex1);
        }
    }
}