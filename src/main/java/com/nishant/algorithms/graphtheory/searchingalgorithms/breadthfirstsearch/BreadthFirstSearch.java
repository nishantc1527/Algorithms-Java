package com.nishant.algorithms.graphtheory.elementarygraphalgorithms.breadthfirstsearch;

import com.nishant.algorithms.graphtheory.elementarygraphalgorithms.Utility;
import com.nishant.algorithms.graphtheory.implementations.Color;
import com.nishant.algorithms.graphtheory.implementations.Pair;
import com.nishant.algorithms.graphtheory.implementations.Vertex;
import com.nishant.algorithms.graphtheory.implementations.adjacencylist.DirectedGraphAdjacencyList;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

  public static <E> void search(DirectedGraphAdjacencyList<E> graph, E source) {
    Utility.initializeTraversal(graph);
    Queue<Pair<Vertex<E>, Integer>> queue = new LinkedList<>();
    queue.offer(new Pair<>(graph.get(source), 0));
    int depth = 0;

    while (!queue.isEmpty()) {
      Pair<Vertex<E>, Integer> next = queue.poll();
      Vertex<E> nextVertex = next.first;
      int nextDepth = next.second;
      nextVertex.color = Color.grey;

      if (depth != nextDepth) {
        System.out.println();
        depth++;
      }

      nextVertex.dist = depth;

      System.out.print(nextVertex + " ");

      for (Vertex<E> neighbor : graph.adjacencyList.get(nextVertex)) {
        if (neighbor.color == Color.white) {
          queue.offer(new Pair<>(neighbor, depth + 1));
        }
      }

      nextVertex.color = Color.black;
    }

    System.out.println();
  }
}
