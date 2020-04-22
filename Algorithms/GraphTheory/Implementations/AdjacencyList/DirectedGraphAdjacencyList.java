package Algorithms.GraphTheory.Implementations.AdjacencyList;

import Algorithms.GraphTheory.Implementations.Edge;
import Algorithms.GraphTheory.Implementations.Pair;
import Algorithms.GraphTheory.Implementations.Vertex;

import java.util.HashMap;
import java.util.LinkedList;

public class DirectedGraphAdjacencyList<E> implements GraphAdjacencyList<E> {

    private final HashMap<Vertex<E>, LinkedList<Vertex<E>>> adjacencyList;
    private final HashMap<E, Vertex<E>> vertices;
    private final HashMap<Pair<E, E>, Edge<Vertex<E>>> edges;

    public DirectedGraphAdjacencyList() {
        adjacencyList = new HashMap<>();
        vertices = new HashMap<>();
        edges = new HashMap<>();
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
    public void connect(E vertex1, E vertex2, int... weight) {
        if(weight.length >= 1) {
            throw new IllegalArgumentException("Tried To Give A Weight To A Directed Graph");
        }

        Vertex<E> v1 = vertices.get(vertex1);
        Vertex<E> v2 = vertices.get(vertex2);
        Pair<E, E> edge = new Pair<>(vertex1, vertex2);

        if(v1 == null) {
            throw new IllegalArgumentException("Vertex " + vertex1 + " Doesn't Exist");
        }

        if(v2 == null) {
            throw new IllegalArgumentException("Vertex " + vertex2 + " Doesn't Exist");
        }

        if(edges.containsKey(edge)) {
            throw new IllegalArgumentException("Edge " + edge.first + " -> " + edge.second + " Already Exists");
        }

        adjacencyList.get(v1).add(v2);
        edges.put(edge, new Edge<>(v1, v2, 0));
    }

    @Override
    public Vertex<E> get(E val) {
        Vertex<E> toReturn = vertices.get(val);

        if(toReturn == null) {
            throw new IllegalArgumentException("Vertex " + val + " Doesn't Exist");
        }

        return toReturn;
    }

    @Override
    public Edge<Vertex<E>> get(E vertex1, E vertex2) {
        Edge<Vertex<E>> edge = edges.get(new Pair<>(vertex1, vertex2));

        if(edge == null) {
            throw new IllegalArgumentException("Edge " + vertex1 + " -> " + vertex2 + " Doesn't Exist");
        }

        return edge;
    }

}
