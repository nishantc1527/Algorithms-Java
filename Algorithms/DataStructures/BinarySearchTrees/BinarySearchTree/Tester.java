package Algorithms.DataStructures.BinarySearchTrees.BinarySearchTree;

import Algorithms.DataStructures.BinarySearchTrees.Utility;

public class Tester {

    public static void main(String[] args) {
        BinarySearchTree<Integer> otherTree = new BinarySearchTree<>();
        Utility.createTree(otherTree, 10, 10);
        Utility.printTree(otherTree);
    }

}
