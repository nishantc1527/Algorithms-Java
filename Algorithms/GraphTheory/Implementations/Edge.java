package Algorithms.GraphTheory.Implementations;

public class Edge<E> {

    public E from, to;
    public int weight;

    public Edge(E from, E to, int weight) {
        this.weight = weight;
    }

}
