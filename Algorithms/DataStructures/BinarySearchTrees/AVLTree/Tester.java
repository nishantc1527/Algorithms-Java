package Algorithms.DataStructures.BinarySearchTrees.AVLTree;

import java.util.LinkedList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        new AVLTree<>();
        AVLTree<Integer> myTree, treeClone;
        List<Integer> treeVals;
        int insertCorrect = 0, deleteCorrect = 0, trials = 10000, heightAvg = 0;

        for (int i = 0; i < trials; i++) {
            myTree = new AVLTree<>();
            treeClone = new AVLTree<>();
            treeVals = new LinkedList<>();

            for (int j = 0; j < 63; j++) {
                int a = (int) (Math.random() * 1000 - 500);
                treeVals.add(a);
                myTree.insert(a);
                if (!myTree.isValid())
                    System.out.println("Face");
                treeClone.insert(j);
            }

            heightAvg += myTree.maxHeight();

            boolean correct1 = myTree.isValid();
            if (correct1) insertCorrect++;

            for (int j = 0; j < 31; j++) {
                int a = (int) (Math.random() * treeVals.size());
                myTree.delete(treeVals.remove(a));
            }

            boolean correct2 = myTree.isValid();
            if (correct2) deleteCorrect++;
        }

        System.out.println("Insertion correct percentage: " + insertCorrect * 100.0 / trials + "%");
        System.out.println("Deletion correct percentage: " + deleteCorrect * 100.0 / trials + "%");
        System.out.println("Average height: " + heightAvg * 1.0 / trials);

        myTree = new AVLTree<>();
        myTree.insert(371);
        myTree.insert(-364);
        myTree.insert(-322);
        myTree.insert(451);
        myTree.insert(384);
        myTree.insert(401);
        myTree.insert(-257);
        System.out.println(myTree.isValid());
        System.out.println(myTree.getHeight());
    }
}
