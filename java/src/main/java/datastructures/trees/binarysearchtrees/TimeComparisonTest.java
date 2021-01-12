package datastructures.trees.binarysearchtrees;

import datastructures.trees.binarysearchtrees.avltree.AVLTree;
import datastructures.trees.binarysearchtrees.binarysearchtree.BinarySearchTree;
import datastructures.trees.binarysearchtrees.redblacktree.RedBlackTree;
import java.util.ArrayList;
import java.util.List;

public class TimeComparisonTest {
  public static void main(String[] args) {
    BinaryTree<Integer> rbtree = new RedBlackTree<>(),
        avltree = new AVLTree<>(),
        binarySearchTree = new BinarySearchTree<>();
    List<Integer> rbTreeVals = new ArrayList<>(),
        avlTreeVals = new ArrayList<>(),
        bstVals = new ArrayList<>();
    int n = 15000;
    for (int i = 0; i < n; i++) {
      int newVal = (int) (Math.random() * n * 2 - n);
      rbTreeVals.add(newVal);
      avlTreeVals.add(newVal);
      bstVals.add(newVal);
    }

    long rbTimeStart, rbTimeFinish, avlTimeStart, avlTimeFinish, bstTimeStart, bstTimeFinish;

    rbTimeStart = System.nanoTime();
    for (Integer rbTreeVal : rbTreeVals) {
      rbtree.insert(rbTreeVal);
    }
    rbTimeFinish = System.nanoTime();

    avlTimeStart = System.nanoTime();
    for (Integer avlTreeVal : avlTreeVals) {
      avltree.insert(avlTreeVal);
    }
    avlTimeFinish = System.nanoTime();

    bstTimeStart = System.nanoTime();
    for (Integer bstTreeVal : bstVals) {
      binarySearchTree.insert(bstTreeVal);
    }
    bstTimeFinish = System.nanoTime();

    System.out.printf(
        "%-40s %d values: %-5d milliseconds\n",
        "Red Black Tree insertion time for", n, ((rbTimeFinish - rbTimeStart) / 1000000));
    System.out.printf(
        "%-40s %d values: %-5d milliseconds\n",
        "AVL Tree insertion time for", n, ((avlTimeFinish - avlTimeStart) / 1000000));
    System.out.printf(
        "%-40s %d values: %-5d milliseconds\n",
        "Binary Search Tree insertion time for", n, ((bstTimeFinish - bstTimeStart) / 1000000));

    System.out.println("\n");

    System.out.printf("%-45s%-4d\n", "Red Black Tree height after insertion: ", rbtree.getHeight());
    System.out.printf("%-45s%-4d\n", "AVL Tree height after insertion: ", avltree.getHeight());
    System.out.printf(
        "%-45s%-4d\n", "Binary Search Tree height after insertion: ", binarySearchTree.getHeight());

    System.out.println("\n");

    int searchN = n * 200;

    rbTimeStart = System.nanoTime();
    for (int i = -searchN; i < searchN; i++) {
      rbtree.contains(i);
    }
    rbTimeFinish = System.nanoTime();

    avlTimeStart = System.nanoTime();
    for (int i = -searchN; i < searchN; i++) {
      avltree.contains(i);
    }
    avlTimeFinish = System.nanoTime();

    bstTimeStart = System.nanoTime();
    for (int i = -searchN; i < searchN; i++) {
      binarySearchTree.contains(i);
    }
    bstTimeFinish = System.nanoTime();

    System.out.printf(
        "%-40s %d values: %-5d milliseconds\n",
        "Red Black Tree search time for", searchN, ((rbTimeFinish - rbTimeStart) / 1000000));
    System.out.printf(
        "%-40s %d values: %-5d milliseconds\n",
        "AVL Tree search time for", searchN, ((avlTimeFinish - avlTimeStart) / 1000000));
    System.out.printf(
        "%-40s %d values: %-5d milliseconds\n",
        "Binary Search Tree search time for", searchN, ((bstTimeFinish - bstTimeStart) / 1000000));

    System.out.println("\n");

    rbTimeStart = System.nanoTime();
    for (int i = 0; i < n; i++) {
      rbtree.delete(rbTreeVals.remove(0));
    }
    rbTimeFinish = System.nanoTime();

    avlTimeStart = System.nanoTime();
    for (int i = 0; i < n; i++) {
      avltree.delete(avlTreeVals.remove(0));
    }
    avlTimeFinish = System.nanoTime();

    bstTimeStart = System.nanoTime();
    for (int i = 0; i < n; i++) {
      binarySearchTree.delete(bstVals.remove(0));
    }
    bstTimeFinish = System.nanoTime();

    System.out.printf(
        "%-40s %d values: %-5d milliseconds\n",
        "Red Black Tree deletion time for", n, ((rbTimeFinish - rbTimeStart) / 1000000));
    System.out.printf(
        "%-40s %d values: %-5d milliseconds\n",
        "AVL Tree deletion time for", n, ((avlTimeFinish - avlTimeStart) / 1000000));
    System.out.printf(
        "%-40s %d values: %-5d milliseconds\n",
        "Binary Search Tree deletion time for", n, ((bstTimeFinish - bstTimeStart) / 1000000));
  }
}
