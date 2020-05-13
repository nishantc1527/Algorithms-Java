Dijkstra's shortest path algorithms is the faster single source shortest path algorithms that guarantees correct results. The downside, however, is that it doesn't
work if any negative weights are present. Dijkstra's Shortest Path algorithm is as follows: First initialize all the distances of the vertices to infinity because
you haven't calculated the path, except for the source vertex, which you know to be 0. Then, iterate V times, where V is the number of vertices, and pick out the
vertex with the smallest dist calculated so and wasn't visited yet. After picking it, relax all edges of that vertex. Implementation of this is simple, however the
part where you have to pick out the smallest vertex has lot's of improvements. You have to get a minimum priority queue with the fastest time to achieve the optimal
running time. It also has to support these operations: add element (in the beelining you add all the vertices), extract min (every iteration you remove the
minimum), and decrease-key (when relaxing an edge, if you find this new edge is optimal, you have to reduce the distance). The data structure that gets the fastest
technical running time is Fibonacci Heap, however in practice Fibonacci Heap's are really slow. So, the next best option is a min heap. Even when you don't use a min
heap, Dijkstra's shortest path algorithm is the fastest when there are no negative weights. Because of this no negative weight constraint, it can't detect negative
weight cycles.