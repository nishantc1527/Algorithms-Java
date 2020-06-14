package datastructures.trees.binarysearchtrees.binarysearchtree;

import datastructures.trees.binarysearchtrees.BinaryTree;
import datastructures.trees.binarysearchtrees.Color;
import datastructures.trees.binarysearchtrees.Node;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> implements BinaryTree<E> {

    /**
     * Parent of the root, just used to simplify insertion and deletion algorithms
     */
    private final BSTNode rootParent;
    /**
     * The root of the binary search tree.
     */
    private BSTNode root;

    /**
     * Default constructor of this tree
     */
    public BinarySearchTree() {
        root = null;
        rootParent = new BSTNode(null);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> myTree;
        List<Integer> treeVals;
        int insertCorrect = 0, deleteCorrect = 0, trials = 10000;

        for (int i = 0; i < trials; i++) {
            myTree = new BinarySearchTree<>();
            treeVals = new LinkedList<>();

            for (int j = 0; j < 31; j++) {
                int a = (int) (Math.random() * 100);
                treeVals.add(a);
                myTree.insert(a);
            }

            boolean correct1 = myTree.isValid();
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

    /**
     * Gets the root of the binary tree.
     *
     * @return The root of the tree.
     */
    @Override
    public Node<E> getRoot() {
        return root;
    }

    /**
     * Inserts a node into the binary tree. After inserting, the tree still has to follow the binary
     * search tree guidelines.
     *
     * @param val The value of the new node.
     */
    @Override
    public void insert(E val) {
        if (root == null) {
            root = new BSTNode(val);
            root.parent = rootParent;
            rootParent.left = root;
        } else {
            Node<E> dummy = root;

            while (true) {
                if (val.compareTo(dummy.getVal()) >= 0) {
                    if (dummy.getRight() == null) {
                        dummy.setRight(new BSTNode(val));
                        dummy.getRight().setParent(dummy);
                        break;
                    }

                    dummy = dummy.getRight();
                } else {
                    if (dummy.getLeft() == null) {
                        dummy.setLeft(new BSTNode(val));
                        dummy.getLeft().setParent(dummy);
                        break;
                    }

                    dummy = dummy.getLeft();
                }
            }
        }
    }

    /**
     * Deletes a node from the binary search tree. After deletion, the binary tree still has to follow
     * the binary search tree guidelines. If the element doesn't exist, just returns.
     *
     * @param val The value of the new node.
     */
    @Override
    public void delete(E val) {
        //        Node<E> dummy = root;
        //
        //        if(dummy == null) {
        //            return;
        //        }
        //
        //        while(!dummy.getVal().equals(val)) {
        //            if(val.compareTo(dummy.getVal()) > 0) {
        //                dummy = dummy.getRight();
        //            } else {
        //                dummy = dummy.getLeft();
        //            }
        //
        //            if(dummy == null) {
        //                return;
        //            }
        //        }
        //
        //        if(dummy.getLeft() == null && dummy.getRight() == null) { // case 1
        //            if(dummy == dummy.getParent().getLeft()) {
        //                dummy.getParent().setLeft(null);
        //            } else {
        //                dummy.getParent().setRight(null);
        //            }
        //        } else if(dummy.getLeft() == null || dummy.getRight() == null) { // case 2
        //            if(dummy.getParent() == null) {
        //                if(dummy.getLeft() == null) {
        //                    root = root.right;
        //                } else {
        //                    root = root.left;
        //                }
        //            } else if(dummy == dummy.getParent().getLeft()) {
        //                if(dummy.getLeft() == null) {
        //                    dummy.getParent().setLeft(dummy.getRight());
        //                } else {
        //                    dummy.getParent().setLeft(dummy.getLeft());
        //                }
        //            } else {
        //                if(dummy.getLeft() == null) {
        //                    dummy.getParent().setRight(dummy.getRight());
        //                } else {
        //                    dummy.getParent().setRight(dummy.getLeft());
        //                }
        //            }
        //        } else { // case 3
        //            Node<E> largestInLeft = dummy.getLeft();
        //
        //            while(largestInLeft.getRight() != null) {
        //                largestInLeft = largestInLeft.getRight();
        //            }
        //
        //            largestInLeft.getParent().setRight(largestInLeft.getLeft());
        //            dummy.setVal(largestInLeft.getVal());
        //        }

        BSTNode deletion = root, successor;
        if (deletion == null) return;
        int comparison = deletion.val.compareTo(val);
        while (comparison != 0) {
            if (comparison > 0) deletion = deletion.left;
            else deletion = deletion.right;
            if (deletion == null) return;
            comparison = deletion.val.compareTo(val);
        }

        if (deletion.left == null && deletion.right == null) {
            if (deletion == deletion.parent.left) deletion.parent.left = null;
            else deletion.parent.right = null;
        } else if (deletion.left == null) {
            successor = deletion.right;
            if (deletion == deletion.parent.left) deletion.parent.left = successor;
            else deletion.parent.right = successor;
            successor.parent = deletion.parent;
        } else if (deletion.right == null) {
            successor = deletion.left;
            if (deletion == deletion.parent.left) deletion.parent.left = successor;
            else deletion.parent.right = successor;
            successor.parent = deletion.parent;
        } else {
            successor = minimum(deletion.right);
            BSTNode rightSide = successor.right, update;
            if (rightSide == null) {
                if (successor.parent == deletion) update = successor;
                else update = successor.parent;
            } else update = rightSide;
            if (successor == successor.parent.right) successor.parent.right = rightSide;
            else successor.parent.left = rightSide;
            if (rightSide != null) rightSide.parent = successor.parent;

            successor.parent = deletion.parent;
            if (deletion == deletion.parent.left) successor.parent.left = successor;
            else successor.parent.right = successor;
            successor.left = deletion.left;
            assert successor.left != null;
            successor.left.parent = successor;
            successor.right = deletion.right;
            if (successor.right != null) successor.right.parent = successor;
        }
        root = rootParent.left;
    }

    private BSTNode minimum(BSTNode root) {
        if (root == null || root.left == null) {
            return root;
        } else return minimum(root.left);
    }

    public int getHeight() {
        return getHeight(getRoot());
    }

    public boolean isValid() {
        return isValid(root);
    }

    private boolean isValid(BSTNode root) {
        if (root == null) return true;
        if (root.left != null && root.left.parent != root) return false;
        if (root.right != null && root.right.parent != root) return false;
        if (root.parent != null && (root.parent.left != root && root.parent.right != root))
            return false;
        if (root.left != null && root.val.compareTo(root.left.val) <= 0) return false;
        if (root.right != null && root.val.compareTo(root.right.val) > 0) return false;
        return isValid(root.left) && isValid(root.right);
    }

    private int getHeight(Node<E> root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
    }

    /**
     * Searches for a node in the tree.
     *
     * @param val The value of the node you are searching for.
     * @return True if the node exists, false otherwise.
     */
    @Override
    public boolean contains(E val) {
        BSTNode dummy = root;

        while (dummy != null) {
            if (dummy.val.equals(val)) {
                return true;
            } else {
                if (val.compareTo(dummy.val) > 0) {
                    dummy = dummy.right;
                } else {
                    dummy = dummy.left;
                }
            }
        }

        return false;
    }

    protected Node<E> search(E val) {
        if (!contains(val)) return null;
        BSTNode dummy = root;

        while (dummy != null) {
            if (dummy.val.equals(val)) {
                return dummy;
            } else {
                if (val.compareTo(dummy.val) > 0) {
                    dummy = dummy.right;
                } else {
                    dummy = dummy.left;
                }
            }
        }

        return null;
    }

    @Override
    public int numNodes() {
        return numNodes(root);
    }

    private int numNodes(BSTNode root) {
        if (root == null) return 0;
        else return numNodes(root.left) + numNodes(root.right) + 1;
    }

    @Override
    public Iterator<Node<E>> iterator() {

        List<Node<E>> res = new LinkedList<>();
        Queue<BSTNode> q = new LinkedList<>();
        if (root != null) q.add(root);
        BSTNode current;
        while (!q.isEmpty()) {
            current = q.remove();
            res.add(current);
            if (current.left != null) q.add(current.left);
            if (current.right != null) q.add(current.right);
        }
        return res.iterator();
    }

    /**
     * A standard binary search tree node. It has the basic necessities like val, left, right, and
     * parent.
     */
    protected class BSTNode implements Node<E> {

        /**
         * The value of this binary search tree node.
         */
        private E val;

        /**
         * The left, right, and parent of this node, respectively.
         */
        private BSTNode left, right, parent;

        /**
         * Creates a new node with a certain value.
         *
         * @param val The value of this node.
         */
        public BSTNode(E val) {
            this.val = val;
        }

        /**
         * Gets the value of this node.
         *
         * @return The value of this node.
         */
        @Override
        public E getVal() {
            return val;
        }

        /**
         * Sets the value of this node.
         *
         * @param newVal This node's new value.
         */
        @Override
        public void setVal(E newVal) {
            val = newVal;
        }

        /**
         * Gets the left child of this node.
         *
         * @return The left child of this node.
         */
        @Override
        public Node<E> getLeft() {
            return left;
        }

        /**
         * Sets the left child of this node.
         *
         * @param newNode This node's new left child.
         */
        @Override
        public void setLeft(Node<E> newNode) {
            left = (BSTNode) newNode;
        }

        /**
         * Gets the right child of this node.
         *
         * @return The right child of this node.
         */
        @Override
        public Node<E> getRight() {
            return right;
        }

        /**
         * Sets the right child of this node.
         *
         * @param newNode The node's new right child.
         */
        @Override
        public void setRight(Node<E> newNode) {
            right = (BSTNode) newNode;
        }

        /**
         * Gets the parent of this node.
         *
         * @return The parent of this node.
         */
        @Override
        public Node<E> getParent() {
            return parent;
        }

        /**
         * Sets the parent of this node.
         *
         * @param newNode The node's new parent.
         */
        @Override
        public void setParent(Node<E> newNode) {
            parent = (BSTNode) newNode;
        }

        /**
         * Checks if this node is null.
         *
         * @return If this node is null.
         */
        @Override
        public boolean isNull() {
            return false;
        }

        /**
         * Binary search trees don't have colored nodes.
         */
        @Override
        public Color getColor() {
            return null;
        }

        /**
         * Binary search trees don't have colored nodes.
         */
        @Override
        public void setColor(Color newColor) {
        }
    }
}
