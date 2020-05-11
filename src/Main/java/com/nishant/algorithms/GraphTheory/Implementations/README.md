There are two main implementations of graphs: Adjacency List and Adjacency Matrix. Adjacency Lists are the more used form and is more useful in most scenarios.
Adjacency Lists is a map from a vertex to a list of all it's neighbors. For example, for this graph:

1 -> 2 ↘
⬆       3
5 ➡ 4 ↗

The adjacency list would look like this:

1: 2
2: 3
3:
4: 3
5: 1, 4

An adjacency matrix is a 2d matrix where each square represents the intersection of two nodes. You can fill in that value as the weight of the edge if it has an
edge, or just put 1 if it is a directed graph. For example, for the graph in the previous example, the matrix would look like this:

   1  2  3  4  5
   -------------
1| 0  1  0  0  0
2| 0  0  1  0  0
3| 0  0  0  0  0
4| 0  0  1  0  0
5| 1  0  0  1  0

A 1 represents an edge is present, while 0 represents there is no edge there.