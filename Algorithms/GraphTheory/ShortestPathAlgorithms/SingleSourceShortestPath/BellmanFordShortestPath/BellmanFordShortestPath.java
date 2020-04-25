package Algorithms.GraphTheory.ShortestPathAlgorithms.SingleSourceShortestPath.BellmanFordShortestPath;

import Algorithms.GraphTheory.Implementations.AdjacencyList.WeightedGraphAdjacencyList;
import Algorithms.GraphTheory.Implementations.Edge;
import Algorithms.GraphTheory.Implementations.Vertex;
import Algorithms.GraphTheory.ShortestPathAlgorithms.SingleSourceShortestPath.Utility;

public class BellmanFordShortestPath {

    public static <E> boolean shortestPath(WeightedGraphAdjacencyList<E> graph, E source) {
        Utility.initializeSingleSource(graph, graph.get(source));
        int V = graph.vertices.size();

        for(int i = 0; i < V - 1; i ++) {
            for(Edge<Vertex<E>> e : graph.edges.values()) {
                Utility.relax(graph, e);
            }
        }

        for(Edge<Vertex<E>> e : graph.edges.values()) {
            if(Utility.relax(graph, e)) {
                return true;
            }
        }

        return false;
    }

}
