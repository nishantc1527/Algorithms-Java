package com.nishant.algorithms.GraphTheory.ShortestPathAlgorithms.SingleSourceShortestPath;

import com.nishant.algorithms.GraphTheory.Implementations.AdjacencyList.WeightedGraphAdjacencyList;
import com.nishant.algorithms.GraphTheory.Implementations.Edge;
import com.nishant.algorithms.GraphTheory.Implementations.Vertex;
import com.nishant.algorithms.GraphTheory.ShortestPathAlgorithms.SingleSourceShortestPath.DijkstraShortestPath.MinHeap;

public class Utility {

    public static <E> void initializeSingleSource(WeightedGraphAdjacencyList<E> graph, Vertex<E> source) {
        for(Vertex<E> vertex : graph.vertices.values()) {
            if(vertex.equals(source)) {
                vertex.dist = 0;
            } else {
                vertex.dist = Integer.MAX_VALUE;
            }

            vertex.prev = null;
        }
    }

    public static <E> void initializeSingleSource(WeightedGraphAdjacencyList<E> graph, Vertex<E> source, MinHeap<E> heap) {
        for(Vertex<E> vertex : graph.vertices.values()) {
            if(vertex.equals(source)) {
                heap.add(vertex, 0);
                source.dist = 0;
            } else {
                heap.add(vertex, Integer.MAX_VALUE);
                vertex.dist = Integer.MAX_VALUE;
            }

            vertex.prev = null;
        }
    }

    public static <E> boolean relax(WeightedGraphAdjacencyList<E> graph, Edge<Vertex<E>> edge, MinHeap<E> heap) {
        Vertex<E> from = edge.from;
        Vertex<E> to = edge.to;
        if(from.dist + edge.weight < to.dist) {
            to.dist = (int) (from.dist + edge.weight);
            to.prev = from;
            heap.decreaseKey(to, to.dist);
            return true;
        }

        return false;
    }

    public static <E> boolean relax(WeightedGraphAdjacencyList<E> graph, Edge<Vertex<E>> edge) {
        Vertex<E> from = edge.from;
        Vertex<E> to = edge.to;
        if(from.dist + edge.weight < to.dist) {
            to.dist = (int) (from.dist + edge.weight);
            to.prev = from;
            return true;
        }

        return false;
    }

    public static <E> void printPathDistances(WeightedGraphAdjacencyList<E> graph, E source) {
        for(Vertex<E> vertex : graph.vertices.values()) {
            Vertex<E> temp = vertex;
            StringBuilder sb = new StringBuilder();

            while(vertex.val != source) {
                sb.append(vertex).append(" >- ");
                vertex = vertex.prev;
            }

            System.out.println(source + " -> " + temp + ": " + sb.append(source).reverse() + ", weight: " + temp.dist);
        }
    }

}
