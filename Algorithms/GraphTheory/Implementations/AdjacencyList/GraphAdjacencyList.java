package Algorithms.GraphTheory.Implementations.AdjacencyList;

import Algorithms.GraphTheory.Implementations.Edge;
import Algorithms.GraphTheory.Implementations.Vertex;

public interface GraphAdjacencyList<E> {

    void addVertex(E val);
    void connect(E vertex1, E vertex2, int... weight);
    Vertex<E> get(E val);
    Edge<Vertex<E>> get(E vertex1, E vertex2);

}
