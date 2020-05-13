package com.nishant.algorithms.graphtheory.implementations.adjacencylist;

import com.nishant.algorithms.graphtheory.implementations.Edge;
import com.nishant.algorithms.graphtheory.implementations.Pair;
import com.nishant.algorithms.graphtheory.implementations.Vertex;

import java.util.HashMap;
import java.util.LinkedList;

public class WeightedGraphAdjacencyList<E> implements GraphAdjacencyList<E> {

    public final HashMap<E, LinkedList<Vertex<E>>> adjacencyList;
    public final HashMap<E, Vertex<E>> vertices;
    public final HashMap<Pair<E, E>, Edge<Vertex<E>>> edges;

    /**
     * Initializes an empty weighted graph.
     */

    public WeightedGraphAdjacencyList() {
        adjacencyList = new HashMap<>();
        vertices = new HashMap<>();
        edges = new HashMap<>();
    }

    /**
     * Adds a vertex to the graph.
     *
     * @param val The value of the new vertex.
     */

    @Override
    public void addVertex(E val) {
        if(vertices.containsKey(val)) {
            throw new IllegalArgumentException("Vertex " + val + " Already Exists");
        }

        Vertex<E> vertexForm = new Vertex<>(val);
        vertices.put(val, vertexForm);
        adjacencyList.put(val, new LinkedList<>());
    }

    /**
     * Connects two vertices together. The weight of the
     * edge is the sum of all weights given.
     *
     * @param vertex1 The source vertex in the edge.
     * @param vertex2 The target vertex in the edge.
     * @param weight The weight connecting vertex1 to vertex2. If more than one weight is given, the weight will be the sum of all the weights given.
     */

    @Override
    public void connect(E vertex1, E vertex2, int... weight) {
        if(weight.length == 0) {
            throw new IllegalArgumentException("No Weight Given");
        }

        int totalWeight = 0;

        for(int i : weight) {
            totalWeight += i;
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

        adjacencyList.get(vertex1).add(v2);
        edges.put(edge, new Edge<>(v1, v2, totalWeight));
    }

    /**
     * Given a value, gets the reference of the vertex with that value.
     *
     * @param val The value of the vertex.
     * @return The reference to the vertex with this value.
     */

    @Override
    public Vertex<E> get(E val) {
        Vertex<E> toReturn = vertices.get(val);

        if(toReturn == null) {
            throw new IllegalArgumentException("Vertex " + val + " Doesn't Exist");
        }

        return toReturn;
    }

    /**
     * Given two vertices, returns the edge connecting them.
     *
     * @param vertex1 The source vertex in the edge.
     * @param vertex2 The target vertex in the edge.
     * @return The reference of the edge connecting vertex1 to vertex2.
     */

    @Override
    public Edge<Vertex<E>> get(E vertex1, E vertex2) {
        Edge<Vertex<E>> edge = edges.get(new Pair<>(vertex1, vertex2));

        if(edge == null) {
            throw new IllegalArgumentException("Edge " + vertex1 + " -> " + vertex2 + " Doesn't Exist");
        }

        return edge;
    }

}
