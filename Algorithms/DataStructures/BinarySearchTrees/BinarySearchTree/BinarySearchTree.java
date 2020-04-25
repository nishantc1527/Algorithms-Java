package Algorithms.DataStructures.BinarySearchTrees.BinarySearchTree;

import Algorithms.DataStructures.BinarySearchTrees.BinaryTree;
import Algorithms.DataStructures.BinarySearchTrees.Node;

public class BinarySearchTree<E extends Comparable<E>> implements BinaryTree<E> {

    private class BSTNode implements Node<E> {

        private E val;
        private BSTNode left, right, parent;

        public BSTNode(E val) {
            this.val = val;
        }

        @Override
        public E getVal() {
            return val;
        }

        @Override
        public Node<E> getLeft() {
            return left;
        }

        @Override
        public Node<E> getRight() {
            return right;
        }

        @Override
        public Node<E> getParent() {
            return parent;
        }

        @Override
        public void setLeft(Node<E> newNode) {
            left = (BSTNode) newNode;
        }

        @Override
        public void setRight(Node<E> newNode) {
            right = (BSTNode) newNode;
        }

        @Override
        public void setParent(Node<E> newNode) {
            parent = (BSTNode) newNode;
        }

        @Override
        public void setVal(E newVal) {
            val = newVal;
        }

    }

    private BSTNode root;

    @Override
    public Node<E> getRoot() {
        return root;
    }

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

    @Override
    public void delete(E val) {
        Node<E> dummy = root;

        while(!dummy.getVal().equals(val)) {
            if(val.compareTo(dummy.getVal()) > 0) {
                dummy = dummy.getRight();
            } else {
                dummy = dummy.getLeft();
            }
        }

        if(dummy.getLeft() == null && dummy.getRight() == null) { // case 1
            if(dummy == dummy.getParent().getLeft()) {
                dummy.getParent().setLeft(null);
            } else {
                dummy.getParent().setRight(null);
            }
        } else if(dummy.getLeft() == null || dummy.getRight() == null) { // case 2
            if(dummy == dummy.getParent().getLeft()) {
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

    @Override
    public boolean search(E val) {
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
}
