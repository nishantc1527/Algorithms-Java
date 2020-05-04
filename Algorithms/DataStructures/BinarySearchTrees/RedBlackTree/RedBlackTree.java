package Algorithms.DataStructures.BinarySearchTrees.RedBlackTree;

import Algorithms.DataStructures.BinarySearchTrees.BinaryTree;
import Algorithms.DataStructures.BinarySearchTrees.Node;
import Algorithms.DataStructures.BinarySearchTrees.Utility;

import java.util.*;

public class RedBlackTree<E extends Comparable<E>> implements BinaryTree<E>, Iterable<Node<E>> {
    private RBTreeNode root;
    private final RBTreeNode NIL= new RBTreeNode(null, Color.BLACK, null, null, null);

    public RedBlackTree () {
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
            }
            else x = x.right;
        }

        RBTreeNode z = new RBTreeNode(val, Color.RED, y, NIL, NIL);

        if (y == NIL) {
            root = z;
        }
        else if (z.getVal().compareTo(y.getVal()) < 0) {
            y.left = z;
        }
        else {
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
                }
                else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    }
                    z.parent.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    rightRotate(z.parent.parent);
                }
            }

            else {
                y = z.parent.parent.left;
                if (y.color == Color.RED) {
                    z.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    z = z.parent.parent;
                }
                else {
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
        root.color = Color.BLACK;
        NIL.parent = null;
    }

    private void leftRotate(RBTreeNode x) {
        RBTreeNode y = x.right;
        x.right = y.left;
        if (y.left != NIL) y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == NIL) root = y;
        if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        y.left = x;
        x.parent = y;
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
        if((z = search(key, root))==null) return;
        RBTreeNode x;
        RBTreeNode y = z; // temporary reference y
        Color y_original_color = y.color;

        if(z.left == NIL){
            x = z.right;
            transplant(z, z.right);
        }else if(z.right == NIL){
            x = z.left;
            transplant(z, z.left);
        }else{
            y = successor(z.right);
            y_original_color = y.color;
            x = y.right;
            if(y.parent == z)
                x.parent = y;
            else{
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if(y_original_color==Color.BLACK)
            deleteFix(x);
    }

    private void deleteFix(RBTreeNode x) {
        while(x!=root && x.color == Color.BLACK){
            if(x == x.parent.left){
                RBTreeNode w = x.parent.right;
                if(w.color == Color.RED){
                    w.color = Color.BLACK;
                    x.parent.color = Color.RED;
                    leftRotate(x.parent);
                    w = x.parent.right;
                }
                if(w.left.color == Color.BLACK && w.right.color == Color.BLACK){
                    w.color = Color.RED;
                    x = x.parent;
                    continue;
                }
                else if(w.right.color == Color.BLACK){
                    w.left.color = Color.BLACK;
                    w.color = Color.RED;
                    rightRotate(w);
                    w = x.parent.right;
                }
                if(w.right.color == Color.RED){
                    w.color = x.parent.color;
                    x.parent.color = Color.BLACK;
                    w.right.color = Color.BLACK;
                    leftRotate(x.parent);
                    x = root;
                }
            }else{
                RBTreeNode w = x.parent.left;
                if(w.color == Color.RED){
                    w.color = Color.BLACK;
                    x.parent.color = Color.RED;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }
                if(w.right.color == Color.BLACK && w.left.color == Color.BLACK){
                    w.color = Color.RED;
                    x = x.parent;
                    continue;
                }
                else if(w.left.color == Color.BLACK){
                    w.right.color = Color.BLACK;
                    w.color = Color.RED;
                    leftRotate(w);
                    w = x.parent.left;
                }
                if(w.left.color == Color.RED){
                    w.color = x.parent.color;
                    x.parent.color = Color.BLACK;
                    w.left.color = Color.BLACK;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = Color.BLACK;
    }

    private RBTreeNode successor(RBTreeNode root) {
        if (root == NIL || root.left == NIL) return root;
        else return successor(root.left);
    }

    private void transplant(RBTreeNode u, RBTreeNode v) {
//        if (u.parent == null) System.out.println(u);
        if(u.parent == NIL){
            root = v;
        }else if(u == u.parent.left){
            u.parent.left = v;
        }else
            u.parent.right = v;
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

    private RBTreeNode search(E val, RBTreeNode root) {
        if (root == NIL) return NIL;
        else if (root.getVal().equals(val)) return root;
        else if (root.getVal().compareTo(val) < 0) return search(val, root.right);
        else return search(val, root.left);
    }

    public boolean isValidRBTree() {
        return root.color == Color.BLACK && checkAdjacentReds() && checkBlackHeights();
    }

    private boolean checkAdjacentReds() {
        for (Node<E> node : this) {
            RBTreeNode current = ((RBTreeNode) node);
            if (current == NIL) continue;
            if (current.color == Color.RED) {
                if (current.parent.color == Color.RED || current.getLeft().color == Color.RED
                        || current.getRight().color == Color.RED) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkBlackHeights() {
        for (Node<E> node : this) {
            if (node == NIL) continue;
            if (countBlacks(root.getLeft()) != countBlacks(root.getRight()))
                return false;
        }

        return true;
    }

    private int countBlacks(RBTreeNode root) {
        if (root == NIL) {
            return 1;
        }
        return (root.color == Color.BLACK ? 1 : 0) + Math.max(countBlacks(root.getLeft()),
                countBlacks(root.getRight()));
    }

    public Iterator<Node<E>> iterator() {
        Queue<RBTreeNode> queue = new LinkedList<>();
        List<Node<E>> res = new LinkedList<>();
        queue.offer(root);
        RBTreeNode current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current == NIL) {
                res.add(NIL);
            }
            else {
                res.add(current);
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
        return res.iterator();
    }

    private class RBTreeNode implements Node<E>{
        E val;
        RBTreeNode left, right, parent;
        Color color;

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
            return "{" +
                    val +
                    ", " + color +
                    '}';
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
    }

    private enum Color {RED, BLACK}

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

            boolean correct1 = myTree.isValidRBTree() && myTree.NIL.parent == null;
            if (correct1) insertCorrect++;

            for (int j = 0; j < 10; j++) {
                int a = (int) (Math.random() * treeVals.size());
                myTree.delete(treeVals.remove(a));
            }

            boolean correct2 = myTree.isValidRBTree();
            if (correct2) deleteCorrect++;
        }

        System.out.println("Insertion correct percentage: " + (((double) insertCorrect) / trials * 100) + "%");
        System.out.println("Deletion correct percentage: " + (((double) deleteCorrect) / trials * 100) + "%");
    }
}
