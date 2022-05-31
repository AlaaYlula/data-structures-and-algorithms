/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package graph.depth.first;

import graph.depth.first.data.Vertex;
import graph.depth.first.structure.Graph;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Test void DFS(){
        Graph<String> graph = new Graph<>();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge(new Vertex<>("A"),new Vertex<>("C"));
        graph.addEdge(new Vertex<>("A"),new Vertex<>("B"));

        graph.addEdge(new Vertex<>("B"),new Vertex<>("A"));
        graph.addEdge(new Vertex<>("B"),new Vertex<>("D"));
        graph.addEdge(new Vertex<>("B"),new Vertex<>("C"));

        graph.addEdge(new Vertex<>("C"),new Vertex<>("B"));
        graph.addEdge(new Vertex<>("C"),new Vertex<>("A"));

        graph.addEdge(new Vertex<>("D"),new Vertex<>("B"));

        Set<String> result = graph.DepthFirst(new Vertex<>("A"));
        Set<String> expected = new HashSet<>();
        expected.add("A");
        expected.add("B");
        expected.add("D");
        expected.add("C");

        assertEquals(expected,result);
    }
}