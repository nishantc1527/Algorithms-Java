#ifndef BINARY_TREE
#define BINARY_TREE

#include <iostream>
#include <queue>

template <typename T>
class TreeNode {
protected:
  const T *val;

  TreeNode(const T &val_)
    : val(new T(val_)) {}

  TreeNode(const T *val_)
    : val(val_) {}

  virtual ~TreeNode() {
    if (val) delete val;
  }
  
public:

  virtual TreeNode<T>* getParent() const = 0;
  
  virtual TreeNode<T>* getLeft() const = 0;
  
  virtual TreeNode<T>* getRight() const = 0;
  
  virtual const T& getValue() const {
    return *val;
  }
};

template <typename T>
class BinaryTree {
protected:
public:
  BinaryTree() = default;
  
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
  virtual std::size_t numNodes() const = 0;

  // prints the tree to console
  virtual void print() const {};
};

#endif
