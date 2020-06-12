#ifndef BINARY_TREE
#define BINARY_TREE

#include <iostream>
#include <queue>

template <typename T>
struct TreeNode {
  const T& val;

  TreeNode<T>* parent;
  TreeNode<T>* left;
  TreeNode<T>* right;

  TreeNode(const T& val) : TreeNode(val, nullptr) {}
  
  TreeNode(const T& value, TreeNode<T> *parent_)
    : val(value), parent(parent_), left(nullptr), right(nullptr) {}

  ~TreeNode() {
    if (left != nullptr) {
      delete left;
    }
    
    if (right != nullptr) {
      delete right;
    }
  }

  TreeNode* getParent() const {
    return parent;
  }
  
  TreeNode* getLeft() const {
    return left;
  }
  
  TreeNode* getRight() const {
    return right;
  }
  
  const T& getValue() const {
    return val;
  }

  void setParent(TreeNode* parent_) {
    this->parent = parent_;
  }

  void setLeft(TreeNode* left_) {
    this->left = left_;
  }

  void setRight(TreeNode* right_) {
    this->right = right_;
  }
};

template <typename T>
class BinaryTree {
protected:
  TreeNode<T> *root, *rootParent;

public:
  BinaryTree(TreeNode<T> *root_, TreeNode<T> *rootParent_)
    : root(root_), rootParent(rootParent_){}
  
  virtual ~BinaryTree() {}

  // inserts the given value into the tree
  virtual void insert(const T& value) = 0;
  // removes the given value from the tree
  virtual bool remove(const T& value) = 0;
  // checks if the given value exists inside the tree
  virtual bool contains(const T& value) const = 0;
  // gets the root of the tree as a TreeNode object
  virtual const TreeNode<T>& getRoot() const = 0;
  // gets the max height of the tree
  virtual unsigned int getHeight() const = 0;
  // gets whether the tree is valid
  virtual bool isValid() const = 0;
  // gets the number of nodes in the tree
  virtual unsigned int numNodes() const = 0;

  // prints the tree to console
  void print() {
    print(root, "");
  }

private:
  void print(TreeNode<T>* node, std::string prefix) {
    if (!node) return;

    print(node->left, prefix + "  ");
    std::cout << prefix << " + " << node->val << std::endl;
    print(node->right, prefix + "  ");
  }

};

#endif
