package Algorithms.GraphTheory.Implementations.AdjacencyMatrix;

import Algorithms.GraphTheory.Implementations.Pair;

public class WeightedGraphAdjacencyMatrix implements GraphAdjacencyMatrix {

    int[][] adjacencyMatrix;

    public WeightedGraphAdjacencyMatrix(int size) {
        adjacencyMatrix = new int[size][size];
    }

    @Override
    public boolean hasEdge(Pair<Integer, Integer> edge) {
        if(edge.first < 0 || edge.first >= adjacencyMatrix.length || edge.second < 0 || edge.second >= adjacencyMatrix.length) {
            throw new IllegalArgumentException("Vertex Does Not Exist");
        }

        return adjacencyMatrix[edge.first][edge.second] != 0;
    }

    @Override
    public int weight(Pair<Integer, Integer> edge) {
        if(edge.first < 0 || edge.first >= adjacencyMatrix.length || edge.second < 0 || edge.second >= adjacencyMatrix.length) {
            throw new IllegalArgumentException("Vertex Does Not Exist");
        }

        return adjacencyMatrix[edge.first][edge.second];
    }

    @Override
    public void setEdge(Pair<Integer, Integer> edge, int... weight) {
        if(edge.first < 0 || edge.first >= adjacencyMatrix.length || edge.second < 0 || edge.second >= adjacencyMatrix.length) {
            throw new IllegalArgumentException("Vertex Does Not Exist");
        }

        int totalWeight = 0;

        for(int i : weight) {
            totalWeight += i;
        }

        adjacencyMatrix[edge.first][edge.second] = totalWeight;
    }

}
