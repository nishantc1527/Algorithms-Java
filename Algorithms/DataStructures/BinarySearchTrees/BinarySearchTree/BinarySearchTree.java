package Algorithms.DataStructures.BinarySearchTrees.BinarySearchTree;

import Algorithms.DataStructures.BinarySearchTrees.BinaryTree;
import Algorithms.DataStructures.BinarySearchTrees.Color;
import Algorithms.DataStructures.BinarySearchTrees.Node;
import Algorithms.DataStructures.BinarySearchTrees.Utility;

public class BinarySearchTree<E extends Comparable<E>> implements BinaryTree<E> {

    /**
     * A standard binary search tree node. It has the basic necessities
     * like val, left, right, and parent.
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
         * Gets the left child of this node.
         *
         * @return The left child of this node.
         */

        @Override
        public Node<E> getLeft() {
            return left;
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
         * Gets the parent of this node.
         *
         * @return The parent of this node.
         */

        @Override
        public Node<E> getParent() {
            return parent;
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
         * Sets the right child of this node.
         *
         * @param newNode The node's new right child.
         */

        @Override
        public void setRight(Node<E> newNode) {
            right = (BSTNode) newNode;
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
         * Sets the value of this node.
         *
         * @param newVal This node's new value.
         */

        @Override
        public void setVal(E newVal) {
            val = newVal;
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
         * Binary search trees don't have
         * colored nodes.
         */

        @Override
        public Color getColor() {
            return null;
        }

        /**
         * Binary search trees don't have
         * colored nodes.
         */

        @Override
        public void setColor(Color newColor) { }

    }

    /**
     * The root of the binary search tree.
     */

    protected BSTNode root;

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
     * Inserts a node into the binary tree. After
     * inserting, the tree still has to follow the binary
     * search tree guidelines.
     *
     * @param val The value of the new node.
     */

    @Override
    public void insert(E val) {
        if(root == null) {
            root = new BSTNode(val);
        } else {
            Node<E> dummy = root;

            while(true) {
                if(val.compareTo(dummy.getVal()) > 0) {
                    if(dummy.getRight() == null) {
                        dummy.setRight(new BSTNode(val));
                        dummy.getRight().setParent(dummy);
                        break;
                    }

                    dummy = dummy.getRight();
                } else {
                    if(dummy.getLeft() == null) {
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
     * Deletes a node from the binary search tree.
     * After deletion, the binary tree still has to
     * follow the binary search tree guidelines. If
     * the element doesn't exist, just returns.
     *
     * @param val The value of the new node.
     */

    @Override
    public void delete(E val) {
        Node<E> dummy = root;

        if(dummy == null) {
            return;
        }

        while(!dummy.getVal().equals(val)) {
            if(val.compareTo(dummy.getVal()) > 0) {
                dummy = dummy.getRight();
            } else {
                dummy = dummy.getLeft();
            }

            if(dummy == null) {
                return;
            }
        }

        if(dummy.getLeft() == null && dummy.getRight() == null) { // case 1
            if(dummy == dummy.getParent().getLeft()) {
                dummy.getParent().setLeft(null);
            } else {
                dummy.getParent().setRight(null);
            }
        } else if(dummy.getLeft() == null || dummy.getRight() == null) { // case 2
            if(dummy.getParent() == null) {
                if(dummy.getLeft() == null) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            } else if(dummy == dummy.getParent().getLeft()) {
                if(dummy.getLeft() == null) {
                    dummy.getParent().setLeft(dummy.getRight());
                } else {
                    dummy.getParent().setLeft(dummy.getLeft());
                }
            } else {
                if(dummy.getLeft() == null) {
                    dummy.getParent().setRight(dummy.getRight());
                } else {
                    dummy.getParent().setRight(dummy.getLeft());
                }
            }
        } else { // case 3
            Node<E> largestInLeft = dummy.getLeft();

            while(largestInLeft.getRight() != null) {
                largestInLeft = largestInLeft.getRight();
            }

            largestInLeft.getParent().setRight(largestInLeft.getLeft());
            dummy.setVal(largestInLeft.getVal());
        }
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
        if (root.parent.left != root && root.parent.right != root) return false;
        if (root.left != null && root.val.compareTo(root.left.val) <= 0) return false;
        if (root.right != null && root.val.compareTo(root.right.val) > 0) return false;
        return isValid(root.left) && isValid(root.right);
    }

    private int getHeight(Node<E> root) {
        if(root == null) {
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

        while(dummy != null) {
            if(dummy.val.equals(val)) {
                return true;
            } else {
                if(val.compareTo(dummy.val) > 0) {
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

        while(dummy != null) {
            if(dummy.val.equals(val)) {
                return dummy;
            } else {
                if(val.compareTo(dummy.val) > 0) {
                    dummy = dummy.right;
                } else {
                    dummy = dummy.left;
                }
            }
        }

        return null;
    }
}
