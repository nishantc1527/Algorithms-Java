package graphtheory.searchingalgorithms;

import graphtheory.implementations.Color;
import graphtheory.implementations.Vertex;
import graphtheory.implementations.adjacencylist.DirectedGraphAdjacencyList;

public class Utility {

  public static <E> void initializeTraversal(DirectedGraphAdjacencyList<E> graph) {
    for (Vertex<E> vertex : graph.vertices.values()) {
      vertex.dist = Integer.MAX_VALUE;
      vertex.color = Color.white;
      vertex.prev = null;
    }
  }

  public static <E> void printDistances(DirectedGraphAdjacencyList<E> graph) {
    for (Vertex<E> vertex : graph.vertices.values()) {
      System.out.println(vertex + ": " + vertex.dist);
    }
  }
}
