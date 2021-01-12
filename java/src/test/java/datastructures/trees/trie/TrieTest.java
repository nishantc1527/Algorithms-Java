package datastructures.trees.trie;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

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
