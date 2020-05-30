package graphtheory.implementations;

public class Edge<E> {

  public E from, to;
  public long weight;

  public Edge(E from, E to, int weight) {
    this.from = from;
    this.to = to;
    this.weight = weight;
  }
}
