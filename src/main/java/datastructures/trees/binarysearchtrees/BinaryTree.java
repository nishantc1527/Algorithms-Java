package datastructures.trees.binarysearchtrees;

public interface BinaryTree<E extends Comparable<E>> extends Iterable<Node<E>> {

  Node<E> getRoot();

  void insert(E val);

  void delete(E val);

  boolean contains(E val);

  int getHeight();

  boolean isValid();

  int numNodes();
}
