package graphtheory.traversals.breadthfirstsearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

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

    public static int[] depthFirstSearch(LinkedList<Integer>[] graph, int start) {
        int[] state = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        state[start] = 1;
        int k = 0;
        int[] res = new int[graph.length];

        while (!queue.isEmpty()) {
            int next = queue.poll();
            state[next] = 2;
            res[k++] = next;

            for (int neighbor : graph[next]) {
                if (state[neighbor] == 0) {
                    state[neighbor] = 1;
                    queue.offer(neighbor);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // 0 -> 1 ↘
        // ⬇  ↙    2
        // 4 <- 3 ↙

        LinkedList<Integer>[] graph = makeGraph(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {0, 4}, {1, 4}});
        int[] search = depthFirstSearch(graph, 0);
        System.out.println(Arrays.toString(search));
    }

}
