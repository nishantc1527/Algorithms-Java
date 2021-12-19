package graphtheory.shortestpathalgorithms.singlesource.dijkstrasshortestpath;

import datastructures.minpriorityqueue.minheap.MinHeap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class DijkstrasShortestPath {

  @SuppressWarnings("unchecked")
  public static LinkedList<int[]>[] makeGraph(int V, int[][] E) {
    LinkedList<int[]>[] graph = new LinkedList[V];

    for (int i = 0; i < graph.length; i++) {
      graph[i] = new LinkedList<>();
    }

    for (int[] edge : E) {
      graph[edge[0]].add(new int[] {edge[1], edge[2]});
    }

    return graph;
  }

  public static int[] dijkstrasShortestPath(LinkedList<int[]>[] graph, int source) {
    int[] weights = new int[graph.length];
    boolean[] states = new boolean[graph.length];

    Arrays.fill(weights, Integer.MAX_VALUE);
    weights[source] = 0;
    MinHeap<Integer> heap = new MinHeap<>(Comparator.comparingInt(i -> weights[i]));
    for (int i = 0; i < graph.length; i++) {
      heap.add(i);
    }

    while (!heap.isEmpty()) {
      int nextVertex = heap.extractMin();
      int nextWeight = weights[nextVertex];

      states[nextVertex] = true;

      for (int[] edge : graph[nextVertex]) {
        int neighbor = edge[0];
        int weight = edge[1];

        if (nextWeight + weight < weights[neighbor]) {
          weights[neighbor] = nextWeight + weight;

          if (!states[neighbor]) {
            heap.update(neighbor);
          }
        }
      }
    }

    return weights;
  }

  public static void main(String[] args) {
    // 0 -> 1 ↘
    // ⬇ ↗     3
    // 2 -> 4 ↗

    LinkedList<int[]>[] graph =
        makeGraph(
            5,
            new int[][] {
              {0, 1, 6},
              {0, 2, 1},
              {2, 1, 1},
              {1, 3, 7},
              {4, 3, 2},
              {2, 4, 3}
            });

    System.out.println(Arrays.toString(dijkstrasShortestPath(graph, 0)));
  }
}
