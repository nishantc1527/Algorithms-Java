package com.nishant.algorithms.DataStructures.BinarySearchTrees.BinarySearchTree;

import com.nishant.algorithms.DataStructures.BinarySearchTrees.Utility;

public class Tester {

    public static void main(String[] args) {
        BinarySearchTree<Integer> otherTree = new BinarySearchTree<>();
        Utility.createTree(otherTree, 10, 10);
        Utility.printTree(otherTree);
    }

}
