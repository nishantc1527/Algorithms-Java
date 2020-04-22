package Algorithms.GraphTheory.Implementations.AdjacencyMatrix;

import Algorithms.GraphTheory.Implementations.Pair;

public class DirectedGraphAdjacencyMatrix implements GraphAdjacencyMatrix {

    boolean[][] adjacencyMatrix;

    public DirectedGraphAdjacencyMatrix(int size) {
        adjacencyMatrix = new boolean[size][size];
    }

    @Override
    public boolean hasEdge(Pair<Integer, Integer> edge) {
        if(edge.first < 0 || edge.first >= adjacencyMatrix.length || edge.second < 0 || edge.second >= adjacencyMatrix.length) {
            throw new IllegalArgumentException("Vertex Does Not Exist");
        }

        return adjacencyMatrix[edge.first][edge.second];
    }

    @Override
    public int weight(Pair<Integer, Integer> edge) {
        return 0;
    }

    @Override
    public void setEdge(Pair<Integer, Integer> edge, int... weight) {

    }

}
