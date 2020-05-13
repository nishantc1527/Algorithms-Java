package com.nishant.algorithms.DataStructures.Trees.BinarySearchTrees.RedBlackTree;

import com.nishant.algorithms.DataStructures.Trees.BinarySearchTrees.BinaryTree;
import com.nishant.algorithms.DataStructures.Trees.BinarySearchTrees.Color;
import com.nishant.algorithms.DataStructures.Trees.BinarySearchTrees.Node;

import java.util.*;

public class RedBlackTree<E extends Comparable<E>> implements BinaryTree<E>, Iterable<Node<E>> {
  private RBTreeNode root;
  public final RBTreeNode NIL = new RBTreeNode(null, Color.BLACK, null, null, null);

  public RedBlackTree() {
    root = NIL;
  }

  public Node<E> getRoot() {
    return root;
  }

  public void insert(E val) {
    RBTreeNode x = root, y = NIL;

    while (x != NIL) {
      y = x;

      if (x.getVal().compareTo(val) > 0) {
        x = x.left;
      } else x = x.right;
    }

    RBTreeNode z = new RBTreeNode(val, Color.RED, y, NIL, NIL);

    if (y == NIL) {
      root = z;
    } else if (z.getVal().compareTo(y.getVal()) < 0) {
      y.left = z;
    } else {
      y.right = z;
    }
    insertFix(z);
  }

  private void insertFix(RBTreeNode z) {
    RBTreeNode y;
    while (z.parent.color == Color.RED) {
      if (z.parent == z.parent.parent.left) {
        y = z.parent.parent.right;
        if (y.color == Color.RED) {
          z.parent.color = Color.BLACK;
          y.color = Color.BLACK;
          z.parent.parent.color = Color.RED;
          z = z.parent.parent;
        } else {
          if (z == z.parent.right) {
            z = z.parent;
            leftRotate(z);
          }
          z.parent.color = Color.BLACK;
          z.parent.parent.color = Color.RED;
          rightRotate(z.parent.parent);
        }
      } else {
        y = z.parent.parent.left;
        if (y.color == Color.RED) {
          z.parent.color = Color.BLACK;
          y.color = Color.BLACK;
          z.parent.parent.color = Color.RED;
          z = z.parent.parent;
        } else {
          if (z == z.parent.left) {
            z = z.parent;
            rightRotate(z);
          }
          z.parent.color = Color.BLACK;
          z.parent.parent.color = Color.RED;
          leftRotate(z.parent.parent);
        }
      }
    }
    root.setColor(Color.BLACK);
    NIL.setParent(null);
  }

  private void leftRotate(RBTreeNode x) {
    RBTreeNode y = x.right;
    x.setRight(y.getLeft());
    if (y.getLeft() != NIL) y.getLeft().setParent(x);
    y.setParent(x.getParent());
    if (x.getParent() == NIL) root = y;
    if (x == x.getParent().getLeft()) x.getParent().setLeft(y);
    else x.getParent().setRight(y);
    y.setLeft(x);
    x.setParent(y);
  }

  private void rightRotate(RBTreeNode y) {
    RBTreeNode x = y.left;
    y.left = x.right;
    if (x.right != NIL) x.right.parent = y;
    x.parent = y.parent;
    if (y.parent == NIL) root = x;
    if (y == y.parent.left) y.parent.left = x;
    else y.parent.right = x;
    x.right = y;
    y.parent = x;
  }

  public void delete(E key) {
    RBTreeNode z;
    if ((z = ((RBTreeNode) search(key, root))) == null) return;
    RBTreeNode x;
    RBTreeNode y = z; // temporary reference y
    Color y_original_color = y.getColor();

    if (z.getLeft() == NIL) {
      x = z.getRight();
      transplant(z, z.getRight());
    } else if (z.getRight() == NIL) {
      x = z.getLeft();
      transplant(z, z.getLeft());
    } else {
      y = successor(z.getRight());
      y_original_color = y.getColor();
      x = y.getRight();
      if (y.getParent() == z) x.setParent(y);
      else {
        transplant(y, y.getRight());
        y.setRight(z.getRight());
        y.getRight().setParent(y);
      }
      transplant(z, y);
      y.setLeft(z.getLeft());
      y.getLeft().setParent(y);
      y.setColor(z.getColor());
    }
    if (y_original_color == Color.BLACK) deleteFix(x);
  }

  private void deleteFix(RBTreeNode x) {
    while (x != root && x.getColor() == Color.BLACK) {
      if (x == x.getParent().getLeft()) {
        RBTreeNode w = x.getParent().getRight();
        if (w.getColor() == Color.RED) {
          w.setColor(Color.BLACK);
          x.getParent().setColor(Color.RED);
          leftRotate(x.parent);
          w = x.getParent().getRight();
        }
        if (w.getLeft().getColor() == Color.BLACK && w.getRight().getColor() == Color.BLACK) {
          w.setColor(Color.RED);
          x = x.getParent();
          continue;
        } else if (w.getRight().getColor() == Color.BLACK) {
          w.getLeft().setColor(Color.BLACK);
          w.setColor(Color.RED);
          rightRotate(w);
          w = x.getParent().getRight();
        }
        if (w.getRight().getColor() == Color.RED) {
          w.setColor(x.getParent().getColor());
          x.getParent().setColor(Color.BLACK);
          w.getRight().setColor(Color.BLACK);
          leftRotate(x.getParent());
          x = root;
        }
      } else {
        RBTreeNode w = (x.getParent().getLeft());
        if (w.color == Color.RED) {
          w.color = Color.BLACK;
          x.getParent().setColor(Color.RED);
          rightRotate(x.getParent());
          w = (x.getParent()).getLeft();
        }
        if (w.right.color == Color.BLACK && w.left.color == Color.BLACK) {
          w.color = Color.RED;
          x = x.getParent();
          continue;
        } else if (w.left.color == Color.BLACK) {
          w.right.color = Color.BLACK;
          w.color = Color.RED;
          leftRotate(w);
          w = (x.getParent().getLeft());
        }
        if (w.left.color == Color.RED) {
          w.color = x.getParent().getColor();
          x.getParent().setColor(Color.BLACK);
          w.left.color = Color.BLACK;
          rightRotate(x.getParent());
          x = root;
        }
      }
    }
    x.setColor(Color.BLACK);
  }

  private RBTreeNode successor(RBTreeNode root) {
    if (root == NIL || root.left == NIL) return root;
    else return successor(root.left);
  }

  private void transplant(RBTreeNode u, RBTreeNode v) {
    //        if (u.parent == null) System.out.println(u);
    if (u.parent == NIL) {
      root = v;
    } else if (u == u.parent.left) {
      u.parent.left = v;
    } else u.parent.right = v;
    v.parent = u.parent;
  }

  public boolean contains(E val) {
    return contains(val, root);
  }

  private boolean contains(E val, RBTreeNode root) {
    if (root == NIL) return false;
    else if (root.getVal().equals(val)) return true;
    else if (root.getVal().compareTo(val) < 0) return contains(val, root.right);
    else return contains(val, root.left);
  }

  private Node<E> search(E val, RBTreeNode root) {
    if (root == NIL) return NIL;
    else if (root.getVal().equals(val)) return root;
    else if (root.getVal().compareTo(val) < 0) return search(val, root.right);
    else return search(val, root.left);
  }

  public boolean isValid() {
    return root.getColor() == Color.BLACK && checkAdjacentReds() && checkBlackHeights();
  }

  private boolean checkAdjacentReds() {
    for (Node<E> node : this) {
      RBTreeNode current = ((RBTreeNode) node);
      if (current == NIL) continue;
      if (current.color == Color.RED) {
        if (current.parent.color == Color.RED
                || current.getLeft().color == Color.RED
                || current.getRight().color == Color.RED) {
          return false;
        }
      }
    }

    return true;
  }

  public int getHeight() {
    return getHeight(getRoot());
  }

  private int getHeight(Node<E> root) {
    if (root == null || root.isNull()) {
      return 0;
    }

    return 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
  }

  private boolean checkBlackHeights() {
    for (Node<E> node : this) {
      if (node == NIL) continue;
      if (countBlacks(root.getLeft()) != countBlacks(root.getRight())) return false;
    }

    return true;
  }

  private int countBlacks(RBTreeNode root) {
    if (root == NIL) {
      return 1;
    }
    return (root.color == Color.BLACK ? 1 : 0)
            + Math.max(countBlacks(root.getLeft()), countBlacks(root.getRight()));
  }

  public Iterator<Node<E>> iterator() {
    Queue<Node<E>> queue = new LinkedList<>();
    List<Node<E>> res = new LinkedList<>();
    queue.offer(root);
    Node<E> current;
    while (!queue.isEmpty()) {
      current = queue.poll();
      if (current == NIL) {
        res.add(NIL);
      } else {
        res.add(current);
        queue.offer(current.getLeft());
        queue.offer(current.getRight());
      }
    }
    return res.iterator();
  }

  private class RBTreeNode implements Node<E> {
    public E val;
    public RBTreeNode left, right, parent;
    public Color color;

    RBTreeNode(E key, Color color, RBTreeNode parent, RBTreeNode left, RBTreeNode right) {
      this.val = key;
      this.color = color;

      if (parent == null && left == null && right == null) {
        parent = this;
        left = this;
        right = this;
      }

      this.parent = parent;
      this.left = left;
      this.right = right;
    }

    public String toString() {
      return "{" + val + ", " + color + '}';
    }

    public E getVal() {
      return val;
    }

    public void setVal(E val) {
      this.val = val;
    }

    public boolean isNull() {
      return this == NIL;
    }

    public RBTreeNode getLeft() {
      return left;
    }

    public void setLeft(Node<E> left) {
      this.left = ((RBTreeNode) left);
    }

    public RBTreeNode getRight() {
      return right;
    }

    public void setRight(Node<E> right) {
      this.right = ((RBTreeNode) right);
    }

    public RBTreeNode getParent() {
      return parent;
    }

    public void setParent(Node<E> parent) {
      this.parent = ((RBTreeNode) parent);
    }

    @Override
    public Color getColor() {
      return color;
    }

    @Override
    public void setColor(Color newColor) {
      color = newColor;
    }

    @Override
    public int hashCode() {
      if (this == NIL) return 0;
      return Objects.hash(val, left, right, color);
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    int length = 0;
    sb.append("[");
    for (Node<E> node : this) {
      sb.append(node).append(", ");
      length += node.toString().length();
      if (length >= 40) {
        sb.append("\n");
        length = 0;
      }
    }
    sb.deleteCharAt(sb.length() - 1);
    sb.append("]");
    return sb.toString();
  }

  @Override
  public int numNodes() {
    return numNodes(root);
  }

  private int numNodes(RBTreeNode root) {
    if (root == null) return 0;
    else return numNodes(root.left) + numNodes(root.right) + 1;
  }

  public static void main(String[] args) {
    RedBlackTree<Integer> myTree;
    List<Integer> treeVals;
    int insertCorrect = 0, deleteCorrect = 0, trials = 10000;

    for (int i = 0; i < trials; i++) {
      myTree = new RedBlackTree<>();
      treeVals = new LinkedList<>();

      for (int j = 0; j < 31; j++) {
        int a = (int) (Math.random() * 100);
        treeVals.add(a);
        myTree.insert(a);
      }

      boolean correct1 = myTree.isValid() && myTree.NIL.getParent() == null;
      if (correct1) insertCorrect++;

      for (int j = 0; j < 10; j++) {
        int a = (int) (Math.random() * treeVals.size());
        myTree.delete(treeVals.remove(a));
      }

      boolean correct2 = myTree.isValid();
      if (correct2) deleteCorrect++;
    }

    System.out.println(
            "Insertion correct percentage: " + (((double) insertCorrect) / trials * 100) + "%");
    System.out.println(
            "Deletion correct percentage: " + (((double) deleteCorrect) / trials * 100) + "%");
  }
}
