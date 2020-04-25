package Algorithms.GraphTheory.ElementaryGraphAlgorithms;

import Algorithms.GraphTheory.Implementations.AdjacencyList.DirectedGraphAdjacencyList;
import Algorithms.GraphTheory.Implementations.Color;
import Algorithms.GraphTheory.Implementations.Vertex;

public class Utility {

    public static <E> void initializeTraversal(DirectedGraphAdjacencyList<E> graph) {
        for(Vertex<E> vertex : graph.vertices.values()) {
            vertex.dist = Integer.MAX_VALUE;
            vertex.color = Color.white;
            vertex.prev = null;
        }
    }

    public static <E> void printDistances(DirectedGraphAdjacencyList<E> graph) {
        for(Vertex<E> vertex : graph.vertices.values()) {
            System.out.println(vertex + ": " + vertex.dist);
        }
    }

}
