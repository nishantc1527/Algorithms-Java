Bellman Ford's Shortest Path Algorithm is extremely simple, yet slower than Dijkstra's shortest path algorithm. The algorithm is this: you relax all the edges V - 1
times, where V is the number of vertices. That's it. After you do that, you have found the correct shortest path. The advantage over Dijkstra shortest path algorithm
is now you can detect negative weight cycles by simply iterating over the vertices again. If you find a new updated shortest path, then there is a negative weight
cycle and return true.