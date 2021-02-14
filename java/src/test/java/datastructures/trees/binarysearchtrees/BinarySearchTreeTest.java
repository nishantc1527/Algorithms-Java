package datastructures.trees.binarysearchtrees;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import datastructures.trees.binarysearchtrees.binarysearchtree.BinarySearchTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

  private BinarySearchTree<Integer> tree;

  @BeforeEach
  public void setup() {
    tree = new BinarySearchTree<>();
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
