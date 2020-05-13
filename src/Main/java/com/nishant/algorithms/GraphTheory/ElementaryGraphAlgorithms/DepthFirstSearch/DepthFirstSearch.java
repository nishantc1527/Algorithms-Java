package com.nishant.algorithms.graphtheory.elementarygraphalgorithms.depthfirstsearch;

import com.nishant.algorithms.graphtheory.elementarygraphalgorithms.Utility;
import com.nishant.algorithms.graphtheory.implementations.Color;
import com.nishant.algorithms.graphtheory.implementations.Vertex;
import com.nishant.algorithms.graphtheory.implementations.adjacencylist.DirectedGraphAdjacencyList;

import java.util.LinkedList;

public class DepthFirstSearch {

  public static <E> void search(DirectedGraphAdjacencyList<E> graph) {
    Utility.initializeTraversal(graph);

    for (Vertex<E> vertex : graph.vertices.values()) {
      if (vertex.color == Color.white) {
        search(graph, vertex);
      }
    }
  }

  private static <E> void search(DirectedGraphAdjacencyList<E> graph, Vertex<E> source) {
    source.color = Color.grey;
    LinkedList<Vertex<E>> neighbors = graph.adjacencyList.get(source);

    System.out.print(source.val + " ( ");

    for (Vertex<E> vertex : neighbors) {
      if (vertex.color == Color.white) {
        search(graph, vertex);
      }
    }

    System.out.print(" ) ");

    source.color = Color.black;
  }
}
