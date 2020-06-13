package graphtheory.traversals.depthfirstsearch;

import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch {

    public static LinkedList<Integer>[] makeGraph(int V, int[][] E) {
        LinkedList[] graph = new LinkedList[V];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList();
        }

        for (int[] edge : E) {
            graph[edge[0]].add(edge[1]);
        }

        return graph;
    }

    public static void depthFirstSearch(LinkedList<Integer>[] graph, int start) {
        int[] state = new int[graph.length];
        Stack<Integer> queue = new Stack<>();
        queue.push(start);
        state[start] = 1;

        while (!queue.isEmpty()) {
            int next = queue.pop();
            state[start] = 2;
            System.out.print(next + " ");

            for (int neighbor : graph[next]) {
                if (state[neighbor] == 0) {
                    state[neighbor] = 1;
                    queue.push(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 0 -> 1 ↘
        // ⬇  ↙    2
        // 4 <- 3 ↙

        LinkedList<Integer>[] graph = makeGraph(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {0, 4}, {1, 4}});
        depthFirstSearch(graph, 0);
    }

}
