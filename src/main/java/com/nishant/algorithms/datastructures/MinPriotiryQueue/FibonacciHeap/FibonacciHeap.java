package com.nishant.algorithms.datastructures.minpriotiryqueue.fibonacciheap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class FibonacciHeap {

  private final HashMap<Integer, Node> references;
  private Node min;
  public FibonacciHeap() {
    references = new HashMap<>();
  }

  public static void main(String[] args) {
    FibonacciHeap h = new FibonacciHeap();

    for (int i = 0; i < 10; i++) {
      h.insert(i);
    }

    h.delete(5);

    while (!h.isEmpty()) {
      System.out.println(h.extractMin());
    }

    System.out.println(h);
  }

  public void insert(int val) {
    Node newNode = new Node(val);
    references.put(val, newNode);

    if (min == null) {
      min = newNode;
      min.left = min;
      min.right = min;
    } else {
      min.insert(newNode);
      if (newNode.val < min.val) {
        min = newNode;
      }
    }
  }

  public int extractMin() {
    int toReturn = min.val;
    references.remove(toReturn);

    if (min.left == min && min.child == null) {
      min = null;
    } else {
      min.safeUnlink();
      min = min.left;
      consolidate();
    }

    return toReturn;
  }

  public void delete(int val) {
    Node nodeForm = references.get(val);
    nodeForm.val = Integer.MIN_VALUE;
    min = nodeForm;
    extractMin();
  }

  public boolean isEmpty() {
    return min == null;
  }

  private void consolidate() {
    Node[] degrees = new Node[45];
    Node dummy = min;
    HashSet<Node> visited = new HashSet<>();

    do {
      if (visited.contains(dummy)) {
        break;
      }

      if (dummy.val < min.val) {
        min = dummy;
      }

      while (degrees[dummy.degree] != null) {
        Node other = degrees[dummy.degree];

        if (other.val < dummy.val) {
          Node temp = other;
          other = dummy;
          dummy = temp;
        }

        dummy.link(other);
        degrees[dummy.degree - 1] = null;
      }

      degrees[dummy.degree] = dummy;
      visited.add(dummy);
      dummy = dummy.right;
    } while (dummy != min);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    if (min != null) {
      Node dummy = min;

      do {
        sb.append(dummy.val).append(" ");
        dummy = dummy.right;
      } while (dummy != min);
    }

    return sb.toString();
  }

  private static class Node {

    public int val;
    public Node left, right, child;
    public int degree;
    public boolean mark;

    public Node(int _val) {
      val = _val;
    }

    public void insert(Node other) {
      if (left == this) {
        left = other;
        right = other;
        left.right = this;
        left.left = this;
      } else {
        Node temp = left;
        left = other;
        left.right = this;
        left.left = temp;
        temp.right = left;
      }
    }

    public void unlink() {
      left.right = right;
      right.left = left;
    }

    public void safeUnlink() {
      saveChildren();
      unlink();
    }

    public void link(Node other) {
      other.unlink();
      if (child == null) {
        child = new Node(other.val);
        child.left = child;
        child.right = child;
      } else {
        child.insert(other);
      }

      other.mark = false;
      degree++;
    }

    public void saveChildren() {
      if (child != null) {
        Node dummy = child;

        do {
          Node tempNext = dummy.right;
          insert(dummy);
          dummy = tempNext;
        } while (dummy != child);

        child = null;
      }
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Node node = (Node) o;
      return val == node.val
          && degree == node.degree
          && mark == node.mark
          && Objects.equals(left, node.left)
          && Objects.equals(right, node.right)
          && Objects.equals(child, node.child);
    }

    @Override
    public int hashCode() {
      return Objects.hash(val);
    }

    @Override
    public String toString() {
      return val + "";
    }
  }
}
