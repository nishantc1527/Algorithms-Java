package datastructures.trees.trie;

public class Trie {

  private final TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("app");
    trie.insert("apple");
    trie.insert("ap");

    System.out.println(trie.contains("app"));
    System.out.println(trie.contains("appl"));
  }

  public void insert(String s) {
    TrieNode curr = root;
    char[] chars = s.toCharArray();

    for (char aChar : chars) {
      int index = aChar - 'a';

      if (curr.children[index] == null) {
        curr.children[index] = new TrieNode();
      }

      curr = curr.children[index];
    }

    curr.count++;
  }

  public boolean contains(String s) {
    TrieNode curr = root;
    char[] chars = s.toCharArray();

    for (char aChar : chars) {
      int index = aChar - 'a';

      if (curr.children[index] == null) {
        return false;
      }

      curr = curr.children[index];
    }

    return curr.count > 0;
  }

  private static class TrieNode {
    public final TrieNode[] children;
    public int count;

    public TrieNode() {
      children = new TrieNode[26];
    }
  }
}
