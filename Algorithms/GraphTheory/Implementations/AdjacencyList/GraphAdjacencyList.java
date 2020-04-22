package Algorithms.GraphTheory.Implementations.AdjacencyList;

import Algorithms.GraphTheory.Implementations.Vertex;

public interface GraphAdjacencyList<E> {

    void addVertex(E val);
    void connect(E vertex1, E vertex2);
    Vertex<E> get(E val);

}
