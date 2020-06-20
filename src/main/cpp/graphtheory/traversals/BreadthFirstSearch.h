#ifndef BREADTH_FIRST_SEARCH
#define BREADTH_FIRST_SEARCH

#include <vector>
#include <list>
#include <queue>

/**
 * Traverses over all nodes in the graph, adding each
 * finished node to a vector
 */
std::vector<int> breadthFirstSearch(std::vector<std::list<int>> graph, int startVertex);


#endif
