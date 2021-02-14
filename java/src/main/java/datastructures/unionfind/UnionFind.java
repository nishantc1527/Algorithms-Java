package datastructures.unionfind;

public class UnionFind {

  private final int[] parent;

  public UnionFind(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException();
    }

    parent = new int[size];

    for (int i = 0; i < size; i++) {
      parent[i] = i;
    }
  }

  public int find(int element) {
    if (parent[element] == element) {
      return element;
    } else {
      return parent[element] = find(parent[element]);
    }
  }

  public void union(int element1, int element2) {
    int root1 = find(element1);
    int root2 = find(element2);

    if (root1 == root2) {
      return;
    }

    parent[root1] = root2;
  }

  public boolean sameGroup(int element1, int element2) {
    return find(element1) == find(element2);
  }
}
