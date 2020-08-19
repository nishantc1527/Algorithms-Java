#ifndef EDGE
#define EDGE

#include "Vertex.h"

template <typename T>
class Edge {
private:
  Vertex<T> first, second;
  double weight;

public:
  Edge(Vertex<T> first_, Vertex<T> second_, double weight_) : first(first_), second(second_), weight(weight_) {}

  bool operator== (Edge<T> &other) {
    return first == other.first && second == other.second;
  }
};

#endif
