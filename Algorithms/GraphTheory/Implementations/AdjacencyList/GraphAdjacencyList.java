package Algorithms.GraphTheory.Implementations.AdjacencyList;

import Algorithms.GraphTheory.Implementations.Edge;
import Algorithms.GraphTheory.Implementations.Vertex;

public interface GraphAdjacencyList<E> {

    /**
     * Adds a vertex to the graph.
     *
     * @param val The value of the new vertex.
     */

    void addVertex(E val);

    /**
     * Connects two vertices together. If it is a weighted
     * graph, specify the weight in an array form, where the
     * weight of the edge would be the sum of all weights in
     * the array.
     *
     * @param vertex1 The source vertex in the edge.
     * @param vertex2 The target vertex in the edge.
     * @param weight The weight connecting vertex1 to vertex2. If more than one weight is given, the weight will be the sum of all the weights given.
     */

    void connect(E vertex1, E vertex2, int... weight);

    /**
     * Given a value, gets the reference of the vertex with that value.
     *
     * @param val The value of the vertex.
     * @return The reference to the vertex with this value.
     */

    Vertex<E> get(E val);

    /**
     * Given two vertices, returns the edge connecting them.
     *
     * @param vertex1 The source vertex in the edge.
     * @param vertex2 The target vertex in the edge.
     * @return The reference of the edge connecting vertex1 to vertex2.
     */

    Edge<Vertex<E>> get(E vertex1, E vertex2);

}
