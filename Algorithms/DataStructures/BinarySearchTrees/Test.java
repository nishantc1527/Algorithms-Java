package Algorithms.DataStructures.BinarySearchTrees;

import Algorithms.DataStructures.BinarySearchTrees.AVLTree.AVLTree;
import Algorithms.DataStructures.BinarySearchTrees.BinarySearchTree.BinarySearchTree;
import Algorithms.DataStructures.BinarySearchTrees.RedBlackTree.RedBlackTree;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        BinaryTree<Integer> rbtree = new RedBlackTree<>(), avltree = new AVLTree<>(),
                binarySearchTree = new BinarySearchTree<>();
        List<Integer> rbTreeVals = new ArrayList<>(),
                avlTreeVals = new ArrayList<>(), bstVals = new ArrayList<>();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            int newVal = (int) (Math.random() * n * 2 - n);
            rbTreeVals.add(newVal);
            avlTreeVals.add(newVal);
            bstVals.add(newVal);
        }

        long rbTimeStart, rbTimeFinish, avlTimeStart, avlTimeFinish, bstTimeStart, bstTimeFinish;

        rbTimeStart = System.currentTimeMillis();
        for (Integer rbTreeVal : rbTreeVals) {
            rbtree.insert(rbTreeVal);
        }
        rbTimeFinish = System.currentTimeMillis();

        avlTimeStart = System.currentTimeMillis();
        for (Integer avlTreeVal : avlTreeVals) {
            avltree.insert(avlTreeVal);
        }
        avlTimeFinish = System.currentTimeMillis();

        bstTimeStart = System.currentTimeMillis();
        for (Integer bstTreeVal : bstVals) {
            binarySearchTree.insert(bstTreeVal);
        }
        bstTimeFinish = System.currentTimeMillis();

        System.out.println("Red Black Tree insertion time for " + n + " values: " +
                ((rbTimeFinish - rbTimeStart)) + " milliseconds");
        System.out.println("AVL Tree insertion time for " + n + " values: " +
                ((avlTimeFinish - avlTimeStart)) + " milliseconds");
        System.out.println("Binary Search Tree insertion time for " + n + " values: " +
                ((bstTimeFinish - bstTimeStart)) + " milliseconds");

        System.out.println("\n");

        rbTimeStart = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            rbtree.delete(rbTreeVals.remove(0));
        }
        rbTimeFinish = System.currentTimeMillis();

        avlTimeStart = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            avltree.delete(avlTreeVals.remove(0));
        }
        avlTimeFinish = System.currentTimeMillis();

        bstTimeStart = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            binarySearchTree.delete(bstVals.remove(0));
        }
        bstTimeFinish = System.currentTimeMillis();

        System.out.println("Red Black Tree deletion time for " + n + " values: " +
                ((rbTimeFinish - rbTimeStart)) + " milliseconds");
        System.out.println("AVL Tree deletion time for " + n + " values: " +
                ((avlTimeFinish - avlTimeStart)) + " milliseconds");
        System.out.println("Binary Search Tree deletion time for " + n + " values: " +
                ((bstTimeFinish - bstTimeStart)) + " milliseconds");

        System.out.println("\n");

        int newN = n * 200;

        rbTimeStart = System.currentTimeMillis();
        for (int i = -newN; i < newN; i++) {
            rbtree.contains(i);
        }
        rbTimeFinish = System.currentTimeMillis();

        avlTimeStart = System.currentTimeMillis();
        for (int i = -newN; i < newN; i++) {
            avltree.contains(i);
        }
        avlTimeFinish = System.currentTimeMillis();

        bstTimeStart = System.currentTimeMillis();
        for (int i = -newN; i < newN; i++) {
            binarySearchTree.contains(i);
        }
        bstTimeFinish = System.currentTimeMillis();

        System.out.println("Red Black Tree search time for searching " + (newN * 2) + " values: " +
                ((rbTimeFinish - rbTimeStart)) + " milliseconds");
        System.out.println("AVL Tree deletion search time for searching " + (newN * 2) + " values: " +
                ((avlTimeFinish - avlTimeStart)) + " milliseconds");
        System.out.println("Binary Search Tree search deletion time for searching " + (newN * 2) + " values: " +
                ((bstTimeFinish - bstTimeStart)) + " milliseconds");


    }
}
