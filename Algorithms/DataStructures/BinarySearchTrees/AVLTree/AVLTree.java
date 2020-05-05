package Algorithms.DataStructures.BinarySearchTrees.AVLTree;

import Algorithms.DataStructures.BinarySearchTrees.BinaryTree;
import Algorithms.DataStructures.BinarySearchTrees.Color;
import Algorithms.DataStructures.BinarySearchTrees.Node;

import java.util.*;

public class AVLTree<E extends Comparable<E>> implements BinaryTree<E>, Iterable<Node<E>> {
    private AVLTreeNode root, rootParent;

    /**
     * Creates a default, empty AVL tree with a null root
     */
    public AVLTree () {
        rootParent = new AVLTreeNode((E) null);
        rootParent.left = null;
    }

    /**
     * Creates a clone of another AVL tree, with clones of each respective tree node in the other AVL tree
     * @param other The AVL tree to clone
     */
    public AVLTree (AVLTree<E> other) {
        this.root = new AVLTreeNode(other.root);
        rootParent = new AVLTreeNode((E) null);
        rootParent.left = root;
    }

    /**
     * Finds and returns the root node of the tree
     * @return The root node
     */
    public Node<E> getRoot() {
        AVLTreeNode res = new AVLTreeNode(root.val);
        res.left = root.left;
        res.right = root.right;
        return res;
    }

    /**
     * Fixes the tree after an insertion or deletion
     * Assuming the balance factors are correct in all of the tree nodes,
     * the tree is fixed using the following rules:
     * 1. First have to fix both the left and right subtrees
     * 2. There is no need to fix the current tree node if the balance factor of the
     * current node belongs to the set of {-1, 0, 1}.
     * 3. If the balance factor is greater than or equal to 2 (the left subtree
     * is heavier than the right subtree) then do the following:
     *      a. If the current node's left child's balance factor is negative (the right
     *      subtree of the current node's left subtree is heavier than the left of the
     *      left of the current) then first have to rotate the current node's left subtree
     *      to the left
     *      b. Rotate the current node to the right
     * 4. If the balance factor of the current node is less than or equal to -2,
     * then perform the mirror image of step #3 on the current node
     * @param root The "current" node to fix
     */
    private void fixTree(AVLTreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        fixTree(root.left);
        fixTree(root.right);

        int bf = root.balanceFactor; // root.balanceFactor = root.left.height - root.right.height
        if (Math.abs(bf) < 2) return;
        if (bf >= 2) {
            boolean lr = root.left.balanceFactor < 0;
            if (lr) {
                leftRotate(root.left);
            }
            rightRotate(root);
        } else if (bf <= -2) {
            boolean rl = root.right.balanceFactor > 0;
            if (rl) {
                rightRotate(root.right);
            }
            leftRotate(root);
        }
        this.root = rootParent.left;
    }

    /**
     * Rotates the 'root' tree node to the right side, used in the fixTree() method
     * This rotation preserves the binary search tree property, but is used to reduce
     * the maximum height of the tree
     * @param root The tree node to be rotated to the right
     */
    private void rightRotate(AVLTreeNode root) {
        AVLTreeNode leftSide = root.left;
        if (root == root.parent.left) {
            root.parent.left = leftSide;
        }
        else {
            root.parent.right = leftSide;
        }
        leftSide.parent = root.parent;

        root.left = leftSide.right;
        if (leftSide.right != null) leftSide.right.parent = root;
        leftSide.right = root;
        root.parent = leftSide;

        updateBalanceFactorsAndHeights(root);
    }

    /**
     * Rotates the 'root' tree node to the left side, used in the fixTree() method
     * This rotation preserves the binary search tree property, but is used to reduce
     * the maximum height of the tree
     * @param root The tree node to be rotated to the left
     */
    private void leftRotate(AVLTreeNode root) {
        AVLTreeNode rightSide = root.right;
        if (root == root.parent.left) {
            root.parent.left = rightSide;
        }
        else {
            root.parent.right = rightSide;
        }
        rightSide.parent = root.parent;

        root.right = rightSide.left;
        if (rightSide.left != null) rightSide.left.parent = root;
        rightSide.left = root;
        root.parent = rightSide;

        updateBalanceFactorsAndHeights(root);
    }

    /**
     * Inserts the value 'val' into the tree using the following steps:
     * 1. Insert the value as though inserting into a regular binary search tree
     * 2. Fix the tree, starting from the root node (see fixTree(AVLTreeNode) for how this works)
     * @param val The value to insert into the tree
     */
    public void insert(E val) {
        AVLTreeNode insertion = new AVLTreeNode(val), parent = root;
        if (root == null) {
            root = insertion;
            root.parent = rootParent;
            rootParent.left = root;
            calcBalanceFactor(root);
            return;
        }

        int comparison = val.compareTo(parent.val);

        while ((comparison < 0 && parent.left != null) ||
                (comparison >= 0 && parent.right != null)) {
            if (comparison < 0) {
                parent = parent.left;
            }
            else {
                parent = parent.right;
            }
            comparison = val.compareTo(parent.val);
        }

        if (comparison < 0) {
            parent.left = insertion;
        }
        else {
            parent.right = insertion;
        }
        insertion.parent = parent;

        updateBalanceFactorsAndHeights(insertion);

        fixTree(root);
    }

    /**
     * Deletes the value 'val' from this tree, in 2 steps
     * First, delete the value as if this tree were a regular binary search tree
     * Second, fix the tree, using the same fixing method as the insertion
     * @param val The value to be deleted
     */
    public void delete(E val) {
        AVLTreeNode deletion = root, successor;
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
            updateBalanceFactorsAndHeights(deletion.parent);
        }
        else if (deletion.left == null) {
            successor = deletion.right;
            if (deletion == deletion.parent.left) deletion.parent.left = successor;
            else deletion.parent.right = successor;
            successor.parent = deletion.parent;
            updateBalanceFactorsAndHeights(deletion.parent);
        }
        else if (deletion.right == null) {
            successor = deletion.left;
            if (deletion == deletion.parent.left) deletion.parent.left = successor;
            else deletion.parent.right = successor;
            successor.parent = deletion.parent;
            updateBalanceFactorsAndHeights(deletion.parent);
        }
        else {
            successor = minimum(deletion.right);
            AVLTreeNode rightSide = successor.right, update;
            if (rightSide == null) {
                if (successor.parent == deletion) update = successor;
                else update = successor.parent;
            }
            else update = rightSide;
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
            if (successor.right != null)
                successor.right.parent = successor;
            updateBalanceFactorsAndHeights(update);
        }
        root = rootParent.left;
        fixTree(root);
    }

    /**
     * Gets the tree node with the minimum value in the subtree of the given node
     * @param root The subtree to search in
     * @return The node with minimum value in the subtree
     */
    private AVLTreeNode minimum(AVLTreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        else return minimum(root.left);
    }

    public int getHeight() {
        return getHeight(getRoot());
    }

    private int getHeight(Node<E> root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
    }

    /**
     * Checks if the tree contains a specified value, same logic as a binary search tree search
     *
     * Time complexity: O(log n)
     * @param val the value to check
     * @return if the tree contains the value
     */
    public boolean contains(E val) {
        return contains(val, root);
    }

    private boolean contains(E val, AVLTreeNode root) {
        if (root == null) return false;
        else if (root.val == val) return true;
        else {
            if (root.val.compareTo(val) > 0) return contains(val, root.left);
            else return contains(val, root.right);
        }
    }

    private void updateBalanceFactorsAndHeights(AVLTreeNode root) {
        if (root == null || this.root == null) return;
        while (root != rootParent) {
            if (root.left == null && root.right == null) {
                root.height = 1;
                root.balanceFactor = 0;
            }
            else if (root.right == null) {
                root.height = root.left.height + 1;
                root.balanceFactor = root.left.height;
            }
            else if (root.left == null) {
                root.height = root.right.height + 1;
                root.balanceFactor = -root.right.height;
            }
            else {
                root.height = Math.max(root.left.height, root.right.height) + 1;
                root.balanceFactor = root.left.height - root.right.height;
            }
            root = root.parent;
        }
    }

    /**
     * Calculates the balance factor of each node in the subtree
     * The balance factor of a given node is calculated by taking the difference
     * of the maximum height of the left and right subtrees
     * The balance factor of a leaf node is 0
     * @param root The subtree in which to calculate the balance factors
     */
    private void calcBalanceFactor(AVLTreeNode root) {
        if (root == null) return;
        calcBalanceFactor(root.left);
        calcBalanceFactor(root.right);
        if (root.left == null && root.right == null) {
            root.height = 1;
            root.balanceFactor = 0;
        }
        else if (root.right == null) {
            root.height = root.left.height + 1;
            root.balanceFactor = root.left.height;
        }
        else if (root.left == null) {
            root.height = root.right.height + 1;
            root.balanceFactor = -root.right.height;
        }
        else {
            root.height = Math.max(root.left.height, root.right.height) + 1;
            root.balanceFactor = root.left.height - root.right.height;
        }

    }

    /**
     * Calculates the maximum height in each of the nodes, starting from the given node
     * The maximum height of a node is calculated by taking the maximum of the heights of
     * the current node's left and right subtrees, and adding 1
     * The height of a leaf node is 1
     * @param root The node to start calculating heights from
     */
    private void calcHeights(AVLTreeNode root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                root.height = 1;
            } else if (root.left == null) {
                calcHeights(root.right);
                root.height = root.right.height + 1;
            } else if (root.right == null) {
                calcHeights(root.left);
                root.height = root.left.height + 1;
            } else {
                calcHeights(root.left);
                calcHeights(root.right);
                root.height = Math.max(root.left.height, root.right.height) + 1;
            }
        }
    }

    @Override
    public int numNodes() {
        return numNodes(root);
    }

    private int numNodes(AVLTreeNode root) {
        if (root == null) return 0;
        else return numNodes(root.left) + numNodes(root.right) + 1;
    }

    /**
     * Gets the maximum height of the whole tree
     * @return The maximum height of the whole tree
     */
    public int maxHeight() {
        return root.height;
    }

    /**
     * Checks if the AVL tree is valid, which means the tree has to conform to the following rules:
     * 1. The tree must retain the standard binary search tree properties
     * 2. The balance factor of any node has to belong to the set of {-1, 0, 1} (see
     * calcBalanceFactor(AVLTreeNode root) for definition of balance factor)
     * @return Whether this tree is a valid AVL tree
     */
    public boolean isValid() {
        calcBalanceFactor(root);
        return isValidBST(root) && isValidAVLTree(root);
    }

    private boolean isValidBST(AVLTreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.left.parent != root) return false;
        if (root.right != null && root.right.parent != root) return false;
        if (root.parent.left != root && root.parent.right != root) return false;
        if (root.left != null && root.val.compareTo(root.left.val) < 0) return false;
        if (root.right != null && root.val.compareTo(root.right.val) > 0) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean isValidAVLTree(AVLTreeNode root) {
        if (root == null) return true;
        return Math.abs(root.balanceFactor) <= 1 && isValidAVLTree(root.left) && isValidAVLTree(root.right);
    }

    /**
     * Checks if this tree is logically equal to another tree
     * The two trees are considered equal iff all of the values are same between both trees
     * and the order of each value is same between both trees
     * @param o The other AVL tree to check equality
     * @return Whether this tree is equal to the other given AVL tree
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AVLTree)) return false;
        AVLTree<?> avlTree = (AVLTree<?>) o;
        return Objects.equals(root, avlTree.root);
    }

    public int hashCode() {
        return Objects.hash(root);
    }

    /**
     * Iterates through the values in this tree in and inorder traversal
     * @return An iterator that iterates through the values in this tree in and inorder traversal
     */
    private Iterator<E> valIterator() {
        Iterator<Node<E>> nodeIterator = iterator();
        List<E> res = new LinkedList<>();
        nodeIterator.forEachRemaining((Node<E> node) -> res.add(node.getVal()));
        return res.iterator();
    }

    /**
     * Iterates through the nodes in this tree in and inorder traversal
     * @return An iterator that iterates through the nodes in this tree in and inorder traversal
     */
    public Iterator<Node<E>> iterator() {
        List<Node<E>> res = new LinkedList<>();
        Queue<AVLTreeNode> q = new LinkedList<>();
        if (root != null) q.add(root);
        AVLTreeNode current;
        while (!q.isEmpty()) {
            current = q.remove();
            res.add(current);
            if (current.left != null) q.add(current.left);
            if (current.right != null) q.add(current.right);
        }
        return res.iterator();
    }

    /**
     * Definition of a tree node held by an AVL tree
     * Contains a value, parent node, left node, right node, height, and balance factor
     * Height and balance factor are updated every time a node is inserted or deleted from the tree
     */
    private class AVLTreeNode implements Node<E> {
        public String toString() {
            return "{" +
                    "val=" + val +
                    '}';
        }

        /**
         * The value of this binary search tree node.
         */

        private E val;

        /**
         * The height of this tree node
         */
        private int height;

        /**
         * The balance factor of this tree node, used in balancing the tree
         */
        private int balanceFactor;

        /**
         * The left, right, and parent of this node, respectively.
         */

        private AVLTreeNode left, right, parent;

        /**
         * Creates a new node with a certain value.
         *
         * @param val The value of this node.
         */

        public AVLTreeNode(E val) {
            this.val = val;
        }

        /**
         * Creates a node with copied values from the other AVL tree node
         * @param other The other node to be copied
         */
        public AVLTreeNode(AVLTreeNode other) {
            if (other == null) return;
            this.val = other.val;
            if (other.left != null) {
                this.left = new AVLTreeNode(other.left);
                this.left.parent = this;
            }
            if (other.right != null) {
                this.right = new AVLTreeNode(other.right);
                this.right.parent = this;
            }
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
            left = (AVLTreeNode) newNode;
        }

        /**
         * Sets the right child of this node.
         *
         * @param newNode The node's new right child.
         */

        @Override
        public void setRight(Node<E> newNode) {
            right = (AVLTreeNode) newNode;
        }

        /**
         * Sets the parent of this node.
         *
         * @param newNode The node's new parent.
         */

        @Override
        public void setParent(Node<E> newNode) {
            parent = (AVLTreeNode) newNode;
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

        @Override
        public Color getColor() {
            return null;
        }

        @Override
        public void setColor(Color newColor) { }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof AVLTree.AVLTreeNode)) return false;
            AVLTreeNode that = (AVLTreeNode) o;
            return Objects.equals(val, that.val) &&
                    Objects.equals(left, that.left) &&
                    Objects.equals(right, that.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right, parent);
        }
    }
}
