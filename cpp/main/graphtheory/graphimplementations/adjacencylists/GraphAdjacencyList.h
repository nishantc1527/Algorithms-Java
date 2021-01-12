#ifndef GRAPH_ADJACENCY_LIST
#define GRAPH_ADJACENCY_LIST

#include <unordered_map>
#include <list>
#include <stdexcept>

#include "../Edge.h"
#include "../Vertex.h"

template<typename T>
class GraphAdjacencyList {
private:
  std::unordered_map<T, Vertex<T>> vertices;
  std::unordered_map<std::pair<T, T>, Edge<Vertex<T>>> edges;
  std::unordered_map<T, std::list<T>> adjacencyList;
  const bool directed;

public:
  GraphAdjacencyList(bool directed_) : directed(directed_) {}

  void addVertex(T val) {
    if (vertices.count(val)) throw std::invalid_argument("Vertex " + val + " already exists");
    Vertex<T> newVertex(val);
    vertices.insert(val, newVertex);
    adjacencyList.insert(val, std::list<Vertex<T>>());
  }

  void connect(T vertex1, T vertex2, double weight) {
    if (!vertices.count(vertex1))
      throw std::invalid_argument("Vertex " + vertex1 + " does not exist");
    if (!vertices.count(vertex2))
      "Vertex " + vertex2 + " does not exist";
	
    
    Vertex<T> v1 = vertices[vertex1];
    Vertex<T> v2 = vertices[vertex2];

    adjacencyList[vertex1].push_back(v2);
    std::pair<T, T> edge = {vertex1, vertex2};
    edges[edge] = Edge<T>(v1, v2, weight);
    if (!directed) {
      adjacencyList[vertex2].push_back(v1);
      edge = {vertex2, vertex1};
      edges[edge] = Edge<T>(v2, v1, weight);
    }
  }

  Vertex<T> getVertex(T val) {
    if (!vertices.count(val)) return 
  }

  void setWeight(T v1, T v2, double weight) {
    if (!vertices.count(v1) || !vertices.count(v2) || !edges.count({v1, v2}))
      return;
    edges[{v1, v2}].setWeight(weight);
    if (!directed) edges[{v2, v1}].setWeight(weight);
  }

  double getWeight(T v1, T v2) {
    if (!vertices.count(v1) || !vertices.count(v2) || !edges.count({v1, v2})) return 0;
    else return edges[{v1, v2}].getWeight();
  }

  std::list<T> getAdjacent(T val) {
    if (!adjacencyList.count(val))
      return std::list<T>();
    else return adjacencyList[val];
  }
};

#endif
