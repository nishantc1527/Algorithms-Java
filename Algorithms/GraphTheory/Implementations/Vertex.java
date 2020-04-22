package Algorithms.GraphTheory.Implementations;

import java.util.Objects;

public class Vertex<E> {

    public E val;
    public Vertex<E> prev;
    public int dist;
    public Color color;

    public Vertex(E val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return dist == vertex.dist &&
                Objects.equals(val, vertex.val) &&
                Objects.equals(prev, vertex.prev) &&
                color == vertex.color;
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
