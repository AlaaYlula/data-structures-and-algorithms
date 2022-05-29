/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package graph.business.trip;

import graph.business.trip.data.Vertex;
import graph.business.trip.structure.Graph;

import java.util.ArrayList;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        Graph<String> graph = new Graph<>();
        graph.addNode("Pandora");
        graph.addNode("Arendelle");
        graph.addNode("Metroville");
        graph.addNode("Monstroplolis");
        graph.addNode("Narnia");
        graph.addNode("Naboo");

        graph.addEdge(new Vertex<>("Pandora"),new Vertex<>("Arendelle"),150);
        graph.addEdge(new Vertex<>("Pandora"),new Vertex<>("Metroville"),82);

        graph.addEdge(new Vertex<>("Arendelle"),new Vertex<>("Metroville"),99);
        graph.addEdge(new Vertex<>("Arendelle"),new Vertex<>("Monstroplolis"),42);
        graph.addEdge(new Vertex<>("Arendelle"),new Vertex<>("Pandora"),150);

        graph.addEdge(new Vertex<>("Metroville"),new Vertex<>("Arendelle"),99);
        graph.addEdge(new Vertex<>("Metroville"),new Vertex<>("Monstroplolis"),105);
        graph.addEdge(new Vertex<>("Metroville"),new Vertex<>("Narnia"),37);
        graph.addEdge(new Vertex<>("Metroville"),new Vertex<>("Naboo"),26);
        graph.addEdge(new Vertex<>("Metroville"),new Vertex<>("Pandora"),82);

        graph.addEdge(new Vertex<>("Narnia"),new Vertex<>("Metroville"),37);
        graph.addEdge(new Vertex<>("Narnia"),new Vertex<>("Naboo"),250);

        graph.addEdge(new Vertex<>("Monstroplolis"),new Vertex<>("Arendelle"),42);
        graph.addEdge(new Vertex<>("Monstroplolis"),new Vertex<>("Metroville"),105);
        graph.addEdge(new Vertex<>("Monstroplolis"),new Vertex<>("Naboo"),73);

        graph.addEdge(new Vertex<>("Naboo"),new Vertex<>("Monstroplolis"),73);
        graph.addEdge(new Vertex<>("Naboo"),new Vertex<>("Metroville"),26);
        graph.addEdge(new Vertex<>("Naboo"),new Vertex<>("Narnia"),250);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Metroville");
        arrayList.add("Pandora");
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Arendelle");
        arrayList2.add("Monstroplolis");
        arrayList2.add("Naboo");
        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("Naboo");
        arrayList3.add("Pandora");
        ArrayList<String> arrayList4 = new ArrayList<>();
        arrayList4.add("Narnia");
        arrayList4.add("Arendelle");
        arrayList4.add("Naboo");
        ArrayList<String> arrayList5 = new ArrayList<>();
        arrayList5.add("Metroville");
        arrayList5.add("Arendelle");
        arrayList5.add("Monstroplolis");

        ArrayList<String> arrayList6 = new ArrayList<>();
        arrayList6.add("Pandora");
        arrayList6.add("Arendelle");
        arrayList6.add("Naboo");

        System.out.println("The Graph : ");
        System.out.println(graph.printGraph());
        System.out.println("Array 1 => "+arrayList+" => "+BusinessTrip(graph,arrayList));
        System.out.println("Array 2 => "+arrayList2+" => "+BusinessTrip(graph,arrayList2));
        System.out.println("Array 3 => "+arrayList3+" => "+BusinessTrip(graph,arrayList3));
        System.out.println("Array 4 => "+arrayList4+" => "+BusinessTrip(graph,arrayList4));
        System.out.println("Array 5 => "+arrayList5+" => "+BusinessTrip(graph,arrayList5));
        System.out.println("Array 6 => "+arrayList6+" => "+BusinessTrip(graph,arrayList6));
    }

    public static int BusinessTrip(Graph<String> graph, ArrayList<String> cities){
        int cost = 0;
        for (int i = 0; i < cities.size(); i++) {
            if(graph.getNeighbors(new Vertex<>(cities.get(i))).
                    contains(new Vertex<>(cities.get(i+1)))) {
                for (Vertex v :
                        graph.getNeighbors(new Vertex<>(cities.get(i)))) {
                    if (v.getData().equals(cities.get(i+1))) {
                        cost = cost + v.getEdge().getWeight();
                    }
                }
            }else{
                // if one of the city is not neighbor with the next one then return 0
                return 0;
            }
            int j = i+2;
            // check if reach the city which is before the last one.
            if( j == cities.size()){
                break;
            }
        }
        return cost;

    }
}
