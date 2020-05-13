package com.nishant.algorithms.datastructures.trees.trie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

  private com.nishant.algorithms.DataStructures.Trees.Trie.Trie trie;

  @Before
  public void setup() {
    trie = new com.nishant.algorithms.DataStructures.Trees.Trie.Trie();
  }

  @Test
  public void testInsertAndContains() {
    trie.insert("app");
    trie.insert("apple");

    assertTrue(trie.contains("app"));
    assertFalse(trie.contains("appl"));
    assertTrue(trie.contains("apple"));
  }
}
