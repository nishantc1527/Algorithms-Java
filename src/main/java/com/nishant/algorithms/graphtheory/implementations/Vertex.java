package com.nishant.algorithms.graphtheory.implementations;

import java.util.Objects;

public class Vertex<E> {

  /** The value of this vertex. */
  public E val;

  /**
   * Used in shortest path algorithms. When the shortest path algorithm is finished, the prev value
   * will point to the previous value in the shortest path.
   */
  public Vertex<E> prev;

  /**
   * Used in shortest path algorithms. When the shortest path algorithm is finished, the dist value
   * will be the total weight of the shortest path.
   */
  public int dist;

  /**
   * Used in graph traversals. White means this vertex is not visited, grey means it is visited but
   * it didn't visit all it's neighbors yet, and black means it's visited and all of it's neighbors
   * is visited.
   */
  public Color color;

  public Vertex(E val) {
    this.val = val;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Vertex<?> vertex = (Vertex<?>) o;
    return Objects.equals(val, vertex.val);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val);
  }

  @Override
  public String toString() {
    return val + "";
  }
}
