#include "BreadthFirstSearch.h"
#include "../GraphMaker.h"

std::vector<int> breadthFirstSearch(std::vector<std::list<int>> graph, int start) {
  enum State {WHITE, GREY, BLACK};
  std::vector<State> states(graph.size(), State::WHITE);

  std::queue<int> q;
  q.push(start);

  int next;
  std::vector<int> res;  

  while (!q.empty()) {
    next = q.front();
    q.pop();
    states[next] = BLACK;
    res.push_back(next);

    for (int neighbor : graph[next]) {
      if (states[neighbor] == WHITE) {
	states[neighbor] = GREY;
	q.push(neighbor);
      }
    }
  }

  return res;
}

int main() {
  std::vector<std::list<int>> graph = makeGraphAdjList(5, {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {0, 4}, {1, 4}});

  std::vector<int> searched = breadthFirstSearch(graph, 0);
  for (auto it = searched.begin(); it != searched.end(); ++it) {
    std::cout << *it << " ";
  }

  std::cout << std::endl;
}
