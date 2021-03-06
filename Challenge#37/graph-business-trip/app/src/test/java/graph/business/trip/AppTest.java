/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package graph.business.trip;

import graph.business.trip.data.Vertex;
import graph.business.trip.structure.Graph;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static graph.business.trip.App.BusinessTrip;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Test void Cost(){
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
        arrayList.add("Arendelle");
        arrayList.add("Monstroplolis");
        int result = BusinessTrip(graph,arrayList);

        assertEquals(141,result);

    }
}
