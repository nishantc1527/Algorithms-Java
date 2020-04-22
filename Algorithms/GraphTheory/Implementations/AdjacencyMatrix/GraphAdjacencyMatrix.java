package Algorithms.GraphTheory.Implementations.AdjacencyMatrix;

import Algorithms.GraphTheory.Implementations.Pair;

public interface GraphAdjacencyMatrix {

    boolean hasEdge(Pair<Integer, Integer> edge);
    int weight(Pair<Integer, Integer> edge);
    void setEdge(Pair<Integer, Integer> edge, int... weight);

}
