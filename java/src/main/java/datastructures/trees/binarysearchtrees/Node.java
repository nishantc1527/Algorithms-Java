package datastructures.trees.binarysearchtrees;

@SuppressWarnings("ALL")
public interface Node<E extends Comparable<E>> {

  /**
   * Gets the value of this node.
   *
   * @return The value of this node.
   */
  E getVal();

  /**
   * Sets the value of this node.
   *
   * @param newVal This node's new value.
   */
  void setVal(E newVal);

  /**
   * Gets the left child of this node.
   *
   * @return The left child of this node.
   */
  Node<E> getLeft();

  /**
   * Sets the left child of this node.
   *
   * @param newNode This node's new left child.
   */
  void setLeft(Node<E> newNode);

  /**
   * Gets the right child of this node.
   *
   * @return The right child of this node.
   */
  Node<E> getRight();

  /**
   * Sets the right child of this node.
   *
   * @param newNode The node's new right child.
   */
  void setRight(Node<E> newNode);

  /**
   * Gets the parent of this node.
   *
   * @return The parent of this node.
   */
  Node<E> getParent();

  /**
   * Sets the parent of this node.
   *
   * @param newNode The node's new parent.
   */
  void setParent(Node<E> newNode);

  /**
   * Checks if this node is null.
   *
   * @return If this node is null.
   */
  boolean isNull();

  /**
   * In red black trees, returns whether it's color is red or black.
   *
   * @return The color of this node.
   */
  Color getColor();

  /**
   * In red black trees, sets the color of this node to specified color.
   *
   * @param newColor The new color of this node.
   */
  void setColor(Color newColor);

  /** Hashing function */
  int hashCode();
}
