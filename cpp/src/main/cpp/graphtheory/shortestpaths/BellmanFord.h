#ifndef BELLMAN_FORD
#define BELLMAN_FORD

#include <vector>
#include <algorithm>
#include <list>
#include <climits>

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

  static void shortestPaths(int V, edgeListType &edgeList, bool &negWeightCycle) {
      for (int i = 0; i < V - 1; i++) {
          for (auto it : edgeList) {
              relaxEdge(*it.first.first, *it.first.second, it.second);
          }
      }

      negWeightCycle = false;
      for (auto it : edgeList) {
          if ((*it.first.second).d > (*it.first.first).d + it.second)
              negWeightCycle = true;
      }
  }

  static void relaxEdge(vertex &u, vertex &v, double weight) {
      if (v.d > u.d + weight) {
          v.d = u.d + weight;
          v.pred = u.id;
      }
  }
public:
  /*
   * @param adjacency list where each vertex has a list of pairs, where each pair is the vertex that is connected and weight of the edge
   * Returns a vector of pairs where each pair represents the predecessor of the vertex and the minimum weight distance from the source
   */
  static returnType shortestPaths(inputAdjListType adjList, int s, bool &negWeightCycle) {
      vertListType vertices(adjList.size());
      edgeListType edgeList;

      for (int i = 0; i < adjList.size(); ++i) {
          if (i == s) {
              vertices[i] = {i, -1, 0};
          }
          else vertices[i] = {i, -1, INT_MAX};
          for (auto it = adjList[i].begin(); it != adjList[i].end(); ++it) {
              edgeList.push_back({{&vertices[i], &vertices[(*it).first]}, (*it).second});
          }
      }

      shortestPaths(adjList.size(), edgeList, negWeightCycle);
      returnType res;
      for (int i = 0; i < vertices.size(); i++) {
          res.push_back({vertices[i].pred, vertices[i].d});
      }

      return res;
  }
};
#endif
