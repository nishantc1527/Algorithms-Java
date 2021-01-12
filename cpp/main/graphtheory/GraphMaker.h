#include <vector>
#include <list>

std::vector<std::list<int>> makeGraphAdjList(int V, std::vector<std::pair<int, int>> E) {
  std::vector<std::list<int>> graph(V, std::list<int>());

  for (std::pair<int, int> edge : E) {
    graph[edge.first].push_back(edge.second);
  }

  return graph;
}

std::vector<std::list<std::pair<int, double>>> makeGraphAdjListWeighted(int V, std::vector<std::pair<std::pair<int, int>, double>> E) {
  std::vector<std::list<std::pair<int, double>>> graph(V, std::list<std::pair<int, double>>());

  for (std::pair<std::pair<int, int>, double> edge : E) {
    graph[edge.first.first].push_back({edge.first.second, edge.second});
  }

  return graph;
}

std::vector<std::vector<int>> makeGraphAdjMat(int V, std::vector<std::pair<int, int>> E) {
  std::vector<std::vector<int>> res(V, std::vector<int>(V));

  for (int i = 0; i < E.size(); i++) {
    res[E[i].first][E[i].second] = 1;
  }

  return res;
}
