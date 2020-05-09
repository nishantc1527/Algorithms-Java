package com.nishant.algorithms.GraphTheory.ElementaryGraphAlgorithms.DepthFirstSearch;

import com.nishant.algorithms.GraphTheory.Implementations.AdjacencyList.DirectedGraphAdjacencyList;

public class Tester {

    public static void main(String[] args) {
        DirectedGraphAdjacencyList<Character> graph = new DirectedGraphAdjacencyList<>();

        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');

        graph.connect('a', 'b');
        graph.connect('a', 'e');
        graph.connect('e', 'd');
        graph.connect('b', 'c');
        graph.connect('d', 'a');

        System.out.println("a -> b -> c");
        System.out.println("↓  ↖  ");
        System.out.println("e -> d" + "\n\n");

        DepthFirstSearch.search(graph);
    }

}
