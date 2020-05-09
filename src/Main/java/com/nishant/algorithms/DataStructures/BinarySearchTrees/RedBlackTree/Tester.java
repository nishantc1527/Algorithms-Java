package com.nishant.algorithms.DataStructures.BinarySearchTrees.RedBlackTree;

import com.nishant.algorithms.DataStructures.BinarySearchTrees.Node;
import com.nishant.algorithms.DataStructures.BinarySearchTrees.Utility;

import java.util.LinkedList;
import java.util.List;

public class Tester {

    public static void main(String[] args) {
        RedBlackTree<Integer> myTree = new RedBlackTree<>();
        List<Integer> treeVals;
        int insertCorrect = 0, deleteCorrect = 0, trials = 10000;

        for (int i = 0; i < trials; i++) {
            treeVals = new LinkedList<>();

            for (int j = 0; j < 25; j++) {
                int a = (int) (Math.random() * 100);
                treeVals.add(a);
                myTree.insert(a);
            }

            boolean correct1 = myTree.isValid() && ((Node<Integer>) myTree.NIL).getParent() == null;
            if (correct1) insertCorrect++;

            for (int j = 0; j < 20; j++) {
                int a = (int) (Math.random() * treeVals.size());
                myTree.delete(treeVals.remove(a));
            }

            boolean correct2 = myTree.isValid();
            if (correct2) {
                deleteCorrect++;
            }

            myTree = new RedBlackTree<>();
        }

        System.out.println("Insertion correct percentage: " + (((double) insertCorrect) / trials * 100) + "%");
        System.out.println("Deletion correct percentage: " + (((double) deleteCorrect) / trials * 100) + "%");
        System.out.print("\n\n\n");
        RedBlackTree<Integer> otherTree = new RedBlackTree<>();
        Utility.createTree(otherTree, 10, 10);
        Utility.printTree(otherTree);
    }

}
