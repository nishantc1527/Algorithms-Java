package graphtheory.shortestpathalgorithms.singlesourceshortestpath.bellmanfordshortestpath;

import graphtheory.implementations.Edge;
import graphtheory.implementations.Vertex;
import graphtheory.implementations.adjacencylist.WeightedGraphAdjacencyList;

public class BellmanFordShortestPath {

  public static <E> boolean shortestPath(WeightedGraphAdjacencyList<E> graph, E source) {
    for (Vertex<E> vertex : graph.vertices.values()) {
      if (vertex.equals(source)) {
        vertex.dist = 0;
      } else {
        vertex.dist = Integer.MAX_VALUE;
      }

      vertex.prev = null;
    }
    graph.get(source).dist = 0;

    int V = graph.vertices.size();

    for (int i = 0; i < V - 1; i++) {
      for (Edge<Vertex<E>> edge : graph.edges.values()) {
        Vertex<E> from = edge.from;
        Vertex<E> to = edge.to;
        if (from.dist + edge.weight < to.dist) {
          to.dist = (int) (from.dist + edge.weight);
          to.prev = from;
        }
      }
    }

    for (Edge<Vertex<E>> edge : graph.edges.values()) {
      Vertex<E> from = edge.from;
      Vertex<E> to = edge.to;
      if (from.dist + edge.weight < to.dist) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    WeightedGraphAdjacencyList<Character> graph = new WeightedGraphAdjacencyList<>();

    graph.addVertex('a');
    graph.addVertex('b');
    graph.addVertex('c');
    graph.addVertex('d');
    graph.addVertex('e');

    graph.connect('b', 'a', -6);
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
            + "a <- b ↘\n"
            + "↓ ↗     c\n"
            + "e -> d ↗"
            + "\n\n\n");
    System.out.println(BellmanFordShortestPath.shortestPath(graph, 'e'));

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
