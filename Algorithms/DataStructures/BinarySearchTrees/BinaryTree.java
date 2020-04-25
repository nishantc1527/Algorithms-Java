package Algorithms.DataStructures.BinarySearchTrees;

public interface BinaryTree<E extends Comparable<E>> {

    /**
     * Gets the root of the binary tree.
     *
     * @return The root of the tree.
     */

    Node<E> getRoot();

    /**
     * Inserts a node into the binary tree. After
     * inserting, the tree still has to follow the binary
     * search tree guidelines.
     *
     * @param val The value of the new node.
     */

    void insert(E val);

    /**
     * Deletes a node from the binary search tree.
     * After deletion, the binary tree still has to
     * follow the binary search tree guidelines.
     *
     * @param val The value of the new node.
     */

    void delete(E val);

    /**
     * Searches for a node in the tree.
     *
     * @param val The value of the node you are searching for.
     * @return True if the node exists, false otherwise.
     */

    boolean contains(E val);

}
