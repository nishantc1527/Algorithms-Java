package Algorithms.GraphTheory.Implementations.AdjacencyList;

import Algorithms.GraphTheory.Implementations.Vertex;

import java.util.HashMap;
import java.util.LinkedList;

public class DirectedGraph<E> implements GraphAdjacencyList<E> {

    private HashMap<Vertex<E>, LinkedList<Vertex<E>>> adjacencyList;
    private HashMap<E, Vertex<E>> vertices;

    public DirectedGraph() {
        adjacencyList = new HashMap<>();
        vertices = new HashMap<>();
    }

    @Override
    public void addVertex(E val) {
        if(vertices.containsKey(val)) {
            throw new IllegalArgumentException("Vertex " + val + " Already Exists");
        }

        Vertex<E> vertexForm = new Vertex<>(val);
        vertices.put(val, vertexForm);
    }

    @Override
    public void connect(E vertex1, E vertex2) {
        Vertex<E> v1 = vertices.get(vertex1);
        Vertex<E> v2 = vertices.get(vertex2);

        if(v1 == null) {
            throw new IllegalArgumentException("Vertex " + vertex1 + " Doesn't Exist");
        }

        if(v2 == null) {
            throw new IllegalArgumentException("Vertex " + vertex2 + " Doesn't Exist");
        }

        adjacencyList.get(v1).add(v2);
    }

    @Override
    public Vertex<E> get(E val) {
        Vertex<E> toReturn = vertices.get(val);

        if(toReturn == null) {
            throw new IllegalArgumentException("Vertex " + val + " Doesn't Exist");
        }

        return toReturn;
    }
}
