package datastructures.trees.trie;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrieTest {

  private Trie trie;

  @BeforeEach
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
