package Algorithms.DataStructures.BinarySearchTrees.AVLTree;

import Algorithms.DataStructures.BinarySearchTrees.RedBlackTree.RedBlackTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        new AVLTree<>();
        AVLTree<Integer> myTree;
        List<Integer> treeVals;
        int insertCorrect = 0, deleteCorrect = 0, trials = 10000, heightAvg = 0;

        for (int i = 0; i < trials; i++) {
            myTree = new AVLTree<>();
            treeVals = new LinkedList<>();

            for (int j = 0; j < 8; j++) {
                int a = (int) (Math.random() * 1000 - 500);
                treeVals.add(a);
                myTree.insert(a);
            }

            heightAvg += myTree.maxHeight();

            boolean correct1 = myTree.isValid();
            if (correct1) insertCorrect++;

            for (int j = 0; j < 7; j++) {
                int a = (int) (Math.random() * treeVals.size());
                myTree.delete(treeVals.remove(a));
            }

            boolean correct2 = myTree.isValid();
            if (correct2) deleteCorrect++;
        }

        System.out.println("Insertion correct percentage: " + insertCorrect * 100.0 / trials + "%");
        System.out.println("Deletion correct percentage: " + deleteCorrect * 100.0 / trials + "%");
        System.out.println("Average height: " + heightAvg * 1.0 / trials);
    }
}
