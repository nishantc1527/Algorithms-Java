package com.nishant.algorithms.GraphTheory.Implementations.AdjacencyMatrix;

import com.nishant.algorithms.GraphTheory.Implementations.Pair;

public class DirectedGraphAdjacencyMatrix implements GraphAdjacencyMatrix {

    public boolean[][] adjacencyMatrix;

    /**
     * Creates an empty directed graph with a certain amount of vertices.
     *
     * @param size The amount of vertices this graph can hold.
     */

    public DirectedGraphAdjacencyMatrix(int size) {
        adjacencyMatrix = new boolean[size][size];
    }

    /**
     * Checks whether there is an edge connecting two
     * vertices.
     *
     * @param edge The two vertices which might have an edge.
     * @return True if there is an edge connecting them, false otherwise.
     */

    @Override
    public boolean hasEdge(Pair<Integer, Integer> edge) {
        if(edge.first < 0 || edge.first >= adjacencyMatrix.length || edge.second < 0 || edge.second >= adjacencyMatrix.length) {
            throw new IllegalArgumentException("Vertex Does Not Exist");
        }

        return adjacencyMatrix[edge.first][edge.second];
    }

    /**
     * Not used in a directed graph.
     *
     * @param edge
     * @return
     */

    @Override
    public int weight(Pair<Integer, Integer> edge) {
        return 0;
    }

    /**
     * Creates an edge between two vertices.
     *
     * @param edge The two vertices where an edge is being made.
     * @param weight Not used in a weighted graph.
     */

    @Override
    public void setEdge(Pair<Integer, Integer> edge, int... weight) {
        if(edge.first < 0 || edge.first >= adjacencyMatrix.length || edge.second < 0 || edge.second >= adjacencyMatrix.length) {
            throw new IllegalArgumentException("Vertex Does Not Exist");
        }

        adjacencyMatrix[edge.first][edge.second] = true;
    }

}
