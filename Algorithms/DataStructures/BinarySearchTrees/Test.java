package Algorithms.DataStructures.BinarySearchTrees;

import Algorithms.DataStructures.BinarySearchTrees.AVLTree.AVLTree;
import Algorithms.DataStructures.BinarySearchTrees.RedBlackTree.RedBlackTree;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        BinaryTree<Integer> rbtree = new RedBlackTree<>(), avltree = new AVLTree<>();
        List<Integer> rbTreeVals = new ArrayList<>(), avlTreeVals = new ArrayList<>();
        int n = 5000000;
        for (int i = 0; i < n; i++) {
            int newVal = (int) (Math.random() * 1000 - 500);
            rbTreeVals.add(newVal);
            avlTreeVals.add(newVal);
        }

        long rbTimeStart, rbTimeFinish, avlTimeStart, avlTimeFinish;

        rbTimeStart = System.currentTimeMillis();
        for (Integer rbTreeVal : rbTreeVals) {
            rbtree.insert(rbTreeVal);
        }
        rbTimeFinish = System.currentTimeMillis();

        avlTimeStart = System.currentTimeMillis();
        for (Integer avlTreeVal : avlTreeVals) {
            rbtree.insert(avlTreeVal);
        }
        avlTimeFinish = System.currentTimeMillis();

        System.out.println("Red Black Tree insertion time for " + n + " values: " +
                ((rbTimeFinish - rbTimeStart)) + " milliseconds");
        System.out.println("AVL Tree insertion time for " + n + " values: " +
                ((avlTimeFinish - avlTimeStart)) + " milliseconds");
    }
}
