#ifndef GRAPH_MAKER
#define GRAPH_MAKER

#include <vector>
#include <list>

std::vector<std::list<int>> makeGraphAdjList(int V, std::vector<std::pair<int, int>> E);

std::vector<std::list<std::pair<int, double>>> makeGraphAdjListWeighted(int V, std::vector<std::pair<std::pair<int, int>, double>> E);

std::vector<std::vector<int>> makeGraphAdjMat(int V, std::vector<std::pair<int, int>> E);

#endif
