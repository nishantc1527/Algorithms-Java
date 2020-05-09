Single Source Shortest Path algorithms are when given a weighted graph and a source vertex, find the shortest path from that vertex to all other vertices. For
example, given this graph and weights:

Weights:
a -> b: 6
a -> e: 1
e -> b: 1
b -> c: 7
d -> c: 2
e -> d: 4

Graph:
a -> b ↘
↓ ↗     c
e -> d ↗

The shortest paths will be as follows:

a -> a: 0
a -> b: 2
a -> c: 7
a -> d: 5
a -> e: 1

The hard part is that because the weights vary, the shortest direct path from one vertex to another isn't the shortest path when talking about the weights. Shortest
path algorithms consists of strategically relaxing edges edge by edge. Relaxing an edge is where you check if using that edge to get to a vertex is more optimal
than what previously calculated.

One key thing that makes some shortest path algorithms more used than others is being able to detect minimum weight cycles. Take this graph:

a -> b: 6
a -> e: 1
e -> b: 1
b -> c: 7
d -> c: 2
e -> d: 4

a <- b ↘
↓ ↗     c
e -> d ↗

When asked to calculate the shortest path from e -> a, the direct path e -> b -> a will get you a weight of -4. However, from a you take this path again: a -> b -> a
then you will get a smaller value. If you take this path forever, you will get an infinitely small weight. Some shortest path algorithms can detect negative weight
cycles and return true if there is one.