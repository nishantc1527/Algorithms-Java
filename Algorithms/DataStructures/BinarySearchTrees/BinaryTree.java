package Algorithms.DataStructures.BinarySearchTrees;

public interface BinaryTree<E extends Comparable<E>> {

    Node<E> getRoot();
    void insert(E val);
    void delete(E val);
    boolean contains(E val);
    int getHeight();
    boolean isValid();

}
