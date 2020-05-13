package com.nishant.algorithms.graphtheory.implementations.adjacencymatrix;

import com.nishant.algorithms.graphtheory.implementations.Pair;

public interface GraphAdjacencyMatrix {

    /**
     * Checks whether there is an edge connecting two
     * vertices.
     *
     * @param edge The two vertices which might have an edge.
     * @return True if there is an edge connecting them, false otherwise.
     */

    boolean hasEdge(Pair<Integer, Integer> edge);

    /**
     * If it is a weighted graph, returns the weight of the edge connecting
     * these two vertices.
     *
     * @param edge The two vertices with an edge of previously unknown weight.
     * @return The weight of the edge.
     */

    int weight(Pair<Integer, Integer> edge);

    /**
     * Creates an edge between two vertices. If it is a weighted graph, the
     * weight of the edge is the sum of all weights given. If an edge is
     * already present, overrides the edge with the new weight.
     *
     * @param edge The two vertices where an edge is being made.
     * @param weight The weight of the new edge. If more than one weight is given, total weight is the sum of all weights given.
     */

    void setEdge(Pair<Integer, Integer> edge, int... weight);

}
