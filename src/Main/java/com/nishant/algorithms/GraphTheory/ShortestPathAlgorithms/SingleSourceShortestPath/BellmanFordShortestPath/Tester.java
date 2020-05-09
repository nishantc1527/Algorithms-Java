package com.nishant.algorithms.GraphTheory.ShortestPathAlgorithms.SingleSourceShortestPath.BellmanFordShortestPath;

import com.nishant.algorithms.GraphTheory.Implementations.AdjacencyList.WeightedGraphAdjacencyList;
import com.nishant.algorithms.GraphTheory.ShortestPathAlgorithms.SingleSourceShortestPath.Utility;

public class Tester {

    public static void main(String[] args) {
        WeightedGraphAdjacencyList<Character> graph = new WeightedGraphAdjacencyList<>();

        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');

        graph.connect('b', 'a', -6);
        graph.connect('a', 'e', 1);
        graph.connect('e', 'b', 1);
        graph.connect('b', 'c', 7);
        graph.connect('d', 'c', 2);
        graph.connect('e', 'd', 4);

        System.out.println("a -> b: 6\n" +
                "a -> e: 1\n" +
                "e -> b: 1\n" +
                "b -> c: 7\n" +
                "d -> c: 2\n" +
                "e -> d: 4\n" +
                "\n" +
                "a <- b ↘\n" +
                "↓ ↗     c\n" +
                "e -> d ↗" + "\n\n\n");
        System.out.println(BellmanFordShortestPath.shortestPath(graph, 'e'));
        Utility.printPathDistances(graph, 'e');
    }

}
