package datastructures.unionfind;

public class UnionFind {

  /** Holds the parent node for each element. The parent of root nodes is itself. */
  private final int[] parent;

  /**
   * Constructs a {@link UnionFind} with a given size.
   *
   * @param size The size of the {@link UnionFind}.
   */
  public UnionFind(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("Can't Have Size Of 0 Or Negative");
    }

    parent = new int[size];

    // Initially every node is a root, so set the parent to itself.
    for (int i = 0; i < size; i++) {
      parent[i] = i;
    }
  }

  /**
   * Finds the group number of an element.
   *
   * @param element The element that you're trying to find the group of.
   * @return The group number of the element.
   */
  public int find(int element) {
    if (parent[element]
        == element) { // Parent is itself means that it's a root, meaning that is the group number.
      return element;
    } else {
      parent[element] =
          find(
              parent[
                  element]); // Path compression: set the parent of this element to the root of the
      // tree (the find method gets the root).
      return parent[element]; // The parent is now the root, so return the parent.
    }
  }

  /**
   * Merges two groups together.
   *
   * @param element1 The first group, which is the group of the element given.
   * @param element2 The second group, which is the group of the element given.
   */
  public void union(int element1, int element2) {
    int root1 = find(element1);
    int root2 = find(element2);

    if (root1 == root2) { // They are already in the same group.
      return;
    }

    parent[root1] = root2; // Merge the two trees.
  }

  /**
   * Checks if two elements are in the same group.
   *
   * @param element1 The first element.
   * @param element2 The second element.
   * @return True if they are part of the same group, false if they are not.
   */
  public boolean sameGroup(int element1, int element2) {
    return find(element1) == find(element2);
  }

  /**
   * Checks if the {@link UnionFind} is currently path compressed. That means that every tree must
   * have only two levels.
   *
   * @return True if the {@link UnionFind} is path compressed.
   */
  public boolean isPathCompressed() {
    for (int j : parent) {
      if (j != parent[j]) {
        return false;
      }
    }

    return true;
  }
}
