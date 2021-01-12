package DataStructures.Trees.BinarySearchTrees;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import datastructures.trees.binarysearchtrees.avltree.AVLTree;
import org.junit.Before;
import org.junit.Test;

public class AVLTreeTest {

  private AVLTree<Integer> tree;

  @Before
  public void setup() {
    tree = new AVLTree<>();
  }

  @Test
  public void insertTest() {
    assertFalse(tree.contains(5));
    tree.insert(5);
    assertTrue(tree.contains(5));

    for (int i = 0; i < 100; i++) {
      tree.insert((int) (Math.random() * 100));
      assertTrue(tree.isValid());
    }
  }

  @Test
  public void deleteTest() {
    tree.insert(5);
    assertTrue(tree.contains(5));
    tree.delete(5);
    assertFalse(tree.contains(5));

    int[] values = new int[100];

    for (int i = 0; i < values.length; i++) {
      values[i] = (int) (Math.random() * 100);
      tree.insert(values[i]);
    }

    for (int i : values) {
      tree.delete(i);
      assertTrue(tree.isValid());
    }
  }
}
