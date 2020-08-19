#ifndef BELLMAN_FORD
#define BELLMAN_FORD

#include <vector>
#include <algorithm>
#include <list>

class BellmanFord {
private:
  struct vertex {
    int id;
    int pred;
    double d;
  };
  
  // Each index represents predecessor and shortest path length to that vertex
  typedef std::vector<std::pair<int, double>> returnType;
  typedef std::vector<std::list<std::pair<int, double>>> inputAdjListType;
  typedef std::vector<std::list<std::pair<vertex, double>>> adjListType;
  typedef std::vector<vertex> vertListType;
  typedef std::vector<std::pair<std::pair<vertex*, vertex*>, double>> edgeListType;
  
  static void shortestPaths(int V, edgeListType &adjList, bool &negWeightCycle);
  static  void relaxEdge(vertex &u, vertex &v, double weight);
public:
  /*
   * @param adjacency list where each vertex has a list of pairs, where each pair is the vertex that is connected and weight of the edge
   * Returns a vector of pairs where each pair represents the predecessor of the vertex and the minimum weight distance from the source
   */
  static returnType shortestPaths(inputAdjListType adjList, int source, bool &negWeightCycle);
};
#endif
