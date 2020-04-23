package Algorithms.DataStructures.BinarySearchTrees;

public class Utility {

    public static <E extends Comparable<E>> void printInPreorder(BinaryTree<E> tree) {
        printInPreorder(tree.getRoot());
        System.out.println();
    }

    public static <E extends Comparable<E>> void printInInorder(BinaryTree<E> tree) {
        printInInorder(tree.getRoot());
        System.out.println();
    }

    public static <E extends Comparable<E>> void printInPostOrder(BinaryTree<E> tree) {
        printInPostOrder(tree.getRoot());
        System.out.println();
    }

    private static <E extends Comparable<E>> void printInPreorder(Node<E> root) {
        if(root == null) {
            return;
        }

        System.out.print(root.getVal() + " ");
        printInPreorder(root.getLeft());
        printInPreorder(root.getRight());
    }

    private static <E extends Comparable<E>> void printInInorder(Node<E> root) {
        if(root == null) {
            return;
        }

        printInInorder(root.getLeft());
        System.out.print(root.getVal() == null ? "" : root.getVal() + " ");
        printInInorder(root.getRight());
    }

    private static <E extends Comparable<E>> void printInPostOrder(Node<E> root) {
        if(root == null) {
            return;
        }

        printInPostOrder(root.getLeft());
        printInPostOrder(root.getRight());
        System.out.print(root.getVal() + " ");
    }

    public static void createTree(BinaryTree<Integer> tree, int size, int max) {
        for(int i = 0; i < size; i ++) {
            tree.insert(Math.random() > 0.5 ? -(int) (Math.random() * max) : (int) (Math.random() * max));
        }
    }

}
