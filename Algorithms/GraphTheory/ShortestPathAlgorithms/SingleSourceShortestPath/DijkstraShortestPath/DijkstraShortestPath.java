package Algorithms.GraphTheory.ShortestPathAlgorithms.SingleSourceShortestPath.DijkstraShortestPath;

import Algorithms.GraphTheory.Implementations.AdjacencyList.WeightedGraphAdjacencyList;
import Algorithms.GraphTheory.Implementations.Vertex;
import Algorithms.GraphTheory.ShortestPathAlgorithms.SingleSourceShortestPath.Utility;

import java.util.LinkedList;

public class DijkstraShortestPath {

    public static <E> void shortestPath(WeightedGraphAdjacencyList<E> graph, E source) {
        Vertex<E> sourceVertex = graph.get(source);
        MinHeap<E> heap = new MinHeap<>(graph.vertices.size());
        Utility.initializeSingleSource(graph, sourceVertex, heap);

        while(!heap.isEmpty()) {
            Vertex<E> minVertex = heap.extractMin();

            LinkedList<Vertex<E>> neighbors = graph.adjacencyList.get(minVertex.val);

            for(Vertex<E> vertex : neighbors) {
                Utility.relax(graph, graph.get(minVertex.val, vertex.val), heap);
            }
        }
    }

}
