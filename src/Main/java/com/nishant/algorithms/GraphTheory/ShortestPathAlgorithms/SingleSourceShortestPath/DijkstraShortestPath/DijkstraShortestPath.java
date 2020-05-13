package com.nishant.algorithms.GraphTheory.ShortestPathAlgorithms.SingleSourceShortestPath.DijkstraShortestPath;

import com.nishant.algorithms.GraphTheory.Implementations.AdjacencyList.WeightedGraphAdjacencyList;
import com.nishant.algorithms.GraphTheory.Implementations.Edge;
import com.nishant.algorithms.GraphTheory.Implementations.Vertex;

import java.util.LinkedList;

public class DijkstraShortestPath {

  public static <E> void shortestPath(WeightedGraphAdjacencyList<E> graph, E source) {
    Vertex<E> sourceVertex = graph.get(source);
    MinHeap<E> heap = new MinHeap<>(graph.vertices.size());
    for (Vertex<E> vertex : graph.vertices.values()) {
      if (vertex.equals(sourceVertex)) {
        heap.add(vertex, 0);
        sourceVertex.dist = 0;
      } else {
        heap.add(vertex, Integer.MAX_VALUE);
        vertex.dist = Integer.MAX_VALUE;
      }

      vertex.prev = null;
    }

    while (!heap.isEmpty()) {
      Vertex<E> minVertex = heap.extractMin();

      LinkedList<Vertex<E>> neighbors = graph.adjacencyList.get(minVertex.val);

      for (Vertex<E> vertex : neighbors) {
        Edge<Vertex<E>> edge = graph.get(minVertex.val, vertex.val);
        Vertex<E> from = edge.from;
        Vertex<E> to = edge.to;

        if (from.dist + edge.weight < to.dist) {
          to.dist = (int) (from.dist + edge.weight);
          to.prev = from;
          heap.decreaseKey(to, to.dist);
        }
      }
    }
  }

  public static void main(String[] args) {
    WeightedGraphAdjacencyList<Character> graph = new WeightedGraphAdjacencyList<>();

    graph.addVertex('a');
    graph.addVertex('b');
    graph.addVertex('c');
    graph.addVertex('d');
    graph.addVertex('e');

    graph.connect('a', 'b', 6);
    graph.connect('a', 'e', 1);
    graph.connect('e', 'b', 1);
    graph.connect('b', 'c', 7);
    graph.connect('d', 'c', 2);
    graph.connect('e', 'd', 4);

    System.out.println(
            "a -> b: 6\n"
                    + "a -> e: 1\n"
                    + "e -> b: 1\n"
                    + "b -> c: 7\n"
                    + "d -> c: 2\n"
                    + "e -> d: 4\n"
                    + "\n"
                    + "a -> b ↘\n"
                    + "↓ ↗     c\n"
                    + "e -> d ↗"
                    + "\n\n\n");
    DijkstraShortestPath.shortestPath(graph, 'a');

    for (Vertex<Character> vertex : graph.vertices.values()) {
      Vertex<Character> temp = vertex;
      StringBuilder sb = new StringBuilder();

      while (vertex.val != 'a') {
        sb.append(vertex).append(" >- ");
        vertex = vertex.prev;
      }

      System.out.println(
              'a' + " -> " + temp + ": " + sb.append('a').reverse() + ", weight: " + temp.dist);
    }
  }
}
