#include "BellmanFord.h"

#include <climits>
#include <iostream>

#include "../GraphMaker.h"

void BellmanFord::shortestPaths(int V, edgeListType &edgeList, bool &negWeightCycle) {
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

void BellmanFord::relaxEdge(vertex &u, vertex &v, double weight) {
  if (v.d > u.d + weight) {
    v.d = u.d + weight;
    v.pred = u.id;
  }
}

BellmanFord::returnType BellmanFord::shortestPaths(inputAdjListType adjList, int s, bool &negWeightCycle) {
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

int main() {
  std::vector<std::list<std::pair<int, double>>> graph = makeGraphAdjListWeighted(6, {{{0, 1}, 4}, {{1, 2}, 5}, {{1, 3}, 2}, {{2, 3}, 7}, {{0, 2}, 3}, {{3, 4}, 2}, {{4, 0}, 4}, {{4, 1}, 4}, {{4, 5}, 6}});
  bool negWeightCycle;
  std::vector<std::pair<int, int>> res = BellmanFord::shortestPaths(graph, 0, negWeightCycle);
  for (int i = 0; i < res.size(); i++) {
    std::cout << std::to_string(i) << ": Predecessor = " << res[i].first << ", Distance from source = " << res[i].second << std::endl;
  }

  std::cout << "Negative weight cycle? " << (negWeightCycle ? "true" : "false") << std::endl;
}
