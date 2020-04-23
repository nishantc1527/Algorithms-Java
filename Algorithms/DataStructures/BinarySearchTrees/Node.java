package Algorithms.DataStructures.BinarySearchTrees;

public interface Node<E extends Comparable<E>> {

    E getVal();
    Node<E> getLeft();
    Node<E> getRight();
    Node<E> getParent();
    void setLeft(Node<E> newNode);
    void setRight(Node<E> newNode);
    void setParent(Node<E> newNode);
    void setVal(E newVal);

}
