package graphtheory.implementations.adjacencymatrix;

import graphtheory.implementations.Pair;

public class WeightedGraphAdjacencyMatrix implements GraphAdjacencyMatrix {

  public int[][] adjacencyMatrix;

  /**
   * Creates an empty weighted graph with a certain amount of vertices.
   *
   * @param size The amount of vertices this graph can hold.
   */
  public WeightedGraphAdjacencyMatrix(int size) {
    adjacencyMatrix = new int[size][size];
  }

  /**
   * Checks whether there is an edge connecting two vertices.
   *
   * @param edge The two vertices which might have an edge.
   * @return True if there is an edge connecting them, false otherwise.
   */
  @Override
  public boolean hasEdge(Pair<Integer, Integer> edge) {
    if (edge.first < 0
        || edge.first >= adjacencyMatrix.length
        || edge.second < 0
        || edge.second >= adjacencyMatrix.length) {
      throw new IllegalArgumentException("Vertex Does Not Exist");
    }

    return adjacencyMatrix[edge.first][edge.second] != 0;
  }

  /**
   * Get's the weight of the edge connecting these two vertices.
   *
   * @param edge The two vertices with an edge of previously unknown weight.
   * @return The weight of the edge.
   */
  @Override
  public int weight(Pair<Integer, Integer> edge) {
    if (edge.first < 0
        || edge.first >= adjacencyMatrix.length
        || edge.second < 0
        || edge.second >= adjacencyMatrix.length) {
      throw new IllegalArgumentException("Vertex Does Not Exist");
    }

    return adjacencyMatrix[edge.first][edge.second];
  }

  /**
   * Creates an edge between two vertices. The weight of the edge is the sum of all weights given.
   * If an edge is already present, overrides the edge with the new weight.
   *
   * @param edge The two vertices where an edge is being made.
   * @param weight The weight of the new edge. If more than one weight is given, total weight is the
   *     sum of all weights given.
   */
  @Override
  public void setEdge(Pair<Integer, Integer> edge, int... weight) {
    if (edge.first < 0
        || edge.first >= adjacencyMatrix.length
        || edge.second < 0
        || edge.second >= adjacencyMatrix.length) {
      throw new IllegalArgumentException("Vertex Does Not Exist");
    }

    int totalWeight = 0;

    for (int i : weight) {
      totalWeight += i;
    }

    adjacencyMatrix[edge.first][edge.second] = totalWeight;
  }
}
