package com.nishant.algorithms.DataStructures.Trees.Trie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

  private Trie trie;

  @Before
  public void setup() {
    trie = new Trie();
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
