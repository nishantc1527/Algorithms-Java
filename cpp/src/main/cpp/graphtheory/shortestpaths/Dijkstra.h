#ifndef DIJKSTRA
#define DIJKSTRA

#include <vector>
#include <algorithm>
#include <list>

class Dijkstra {
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
  

};

#endif
