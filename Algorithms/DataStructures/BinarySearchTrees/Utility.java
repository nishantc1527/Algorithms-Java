package Algorithms.DataStructures.BinarySearchTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utility {

    /**
     * Prints a tree in preorder traversal.
     *
     * @param tree The tree to traverse.
     * @param <E> The type parameter of the tree.
     */

    public static <E extends Comparable<E>> void printInPreorder(BinaryTree<E> tree) {
        printInPreorder(tree.getRoot());
        System.out.println();
    }

    /**
     * Prints a tree in inorder traversal.
     *
     * @param tree The tree to traverse.
     * @param <E> The type parameter of the tree.
     */

    public static <E extends Comparable<E>> void printInInorder(BinaryTree<E> tree) {
        printInInorder(tree.getRoot());
        System.out.println();
    }

    /**
     * Prints a tree in post order traversal.
     *
     * @param tree The tree to traverse.
     * @param <E> The type parameter of the tree.
     */

    public static <E extends Comparable<E>> void printInPostOrder(BinaryTree<E> tree) {
        printInPostOrder(tree.getRoot());
        System.out.println();
    }

    /**
     * Helper method to print in preorder traversal.
     *
     * @param root The root node of the tree.
     * @param <E> The type parameter of the tree.
     */

    private static <E extends Comparable<E>> void printInPreorder(Node<E> root) {
        if (root == null) {
            return;
        }

        System.out.print(root.getVal() + " ");
        printInPreorder(root.getLeft());
        printInPreorder(root.getRight());
    }

    /**
     * Helper method to print in inorder traversal.
     *
     * @param root The root node of the tree.
     * @param <E> The type parameter of the tree.
     */

    private static <E extends Comparable<E>> void printInInorder(Node<E> root) {
        if (root == null) {
            return;
        }

        printInInorder(root.getLeft());
        System.out.print(root.getVal() == null ? "" : root.getVal() + " ");
        printInInorder(root.getRight());
    }

    /**
     * Helper method to print in post order traversal.
     *
     * @param root The root node of the tree.
     * @param <E> The type parameter of the tree.
     */

    private static <E extends Comparable<E>> void printInPostOrder(Node<E> root) {
        if (root == null) {
            return;
        }

        printInPostOrder(root.getLeft());
        printInPostOrder(root.getRight());
        System.out.print(root.getVal() + " ");
    }

    /**
     * Creates a tree with random values.
     *
     * @param tree The tree who's values you are filling.
     * @param size The size of the tree.
     * @param max The maximum of every node in the new tree, negative and positive.
     */

    public static void createTree(BinaryTree<Integer> tree, int size, int max) {
        for (int i = 0; i < size; i++) {
            tree.insert(Math.random() > 0.5 ? -(int) (Math.random() * max) : (int) (Math.random() * max));
        }
    }

    public static <E extends Comparable<E>> void printTree(BinaryTree<E> tree) {
        printNode(tree.getRoot());
    }

    public static <E extends Comparable<E>> void printNode(Node<E> root) {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <E extends Comparable<E>> void printNodeInternal(List<Node<E>> nodes, int level, int maxLevel) {
        if(nodes.isEmpty() || isAllElementsNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node<E>> newNodes = new ArrayList<>();
        for(Node<E> node : nodes) {
            if(node != null) {
                System.out.print(node.getVal());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for(int i = 1; i <= edgeLines; i++) {
            for(Node<E> node : nodes) {
                printWhitespaces(firstSpaces - i);
                if(node == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if(node.getLeft() != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(i + i - 1);

                if(node.getRight() != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println();
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for(int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static <E extends Comparable<E>> int maxLevel(Node<E> node) {
        if(node == null) {
            return 0;
        }

        return Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for(T object : list) {
            if (object != null) {
                return false;
            }
        }

        return true;
    }

}