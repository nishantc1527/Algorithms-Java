#ifndef BINARY_SEARCH_TREE
#define BINARY_SEARCH_TREE

#include <algorithm>
#include <iostream>

#include "../BinaryTree.h"

template<typename T>
class BinarySearchTree : public BinaryTree<T> {
private:
  template<typename>
  class BSTNode : public TreeNode<T> {
    template<typename> friend class BinarySearchTree<T>;
  public:
    BSTNode<T> *parent, *left, *right;

    BSTNode(const T *val)
      : TreeNode<T>(val), parent(nullptr), left(nullptr), right(nullptr) {}

    BSTNode(const T &val_)
      : BSTNode(val_, nullptr) {}

    BSTNode(const T& val_, BSTNode<T> *parent_)
      : TreeNode<T>(val_), parent(parent_), left(nullptr), right(nullptr) {}

    ~BSTNode() override {
      if (left)
	delete left;

      if (right)
	delete right;
    }
    
    TreeNode<T>* getParent() const override {
      return parent;
    }

    TreeNode<T>* getLeft() const override {
      return left;
    }
  
    TreeNode<T>* getRight() const override {
      return right;
    }
  };
  
  BSTNode<T>  *rootParent, *root;
public:
  BinarySearchTree() : rootParent(new BSTNode<T>(nullptr)), root(nullptr) {}

  ~BinarySearchTree() override {
    delete rootParent;
  }

  void insert(const T& val) override {
    if (!root) {
      root = new BSTNode<T>(val, rootParent);
      rootParent->left = root;
    } else if (contains(val)) {
      return;
    } else {
      BSTNode<T> *dummy = root;

      while (dummy) {
	if (val < *dummy->val) {
	  if (!dummy->left) {
	    dummy->left = new BSTNode<T>(val, dummy);
	    return;
	  }

	  dummy = dummy->left;
	}
	else {
	  if (!dummy->right) {
	    dummy->right = new BSTNode<T>(val, dummy);
	    return;
	  }

	  dummy = dummy->right;
	}
      }
    }
  }

  bool remove(const T& value) override {
    BSTNode<T> *deletion = find(value);
    if (!deletion) return false;
    
    bool rightChild = (deletion == deletion->parent->right);
    
    if (!deletion->left && !deletion->right) {
      if (rightChild)
	deletion->parent->right = nullptr;
      else
	deletion->parent->left = nullptr;

      if (deletion == this->root) this->root = nullptr;
    }
    else if (!deletion->left) {
      if (rightChild)
	deletion->parent->right = deletion->right;
      else deletion->parent->left = deletion->right;

      if (deletion == this->root) this->root = deletion->right;
    }
    else if (!deletion->right) {
      if (rightChild)
	deletion->parent->right = deletion->left;
      else deletion->parent->left = deletion->left;

      if (deletion == this->root) this->root = deletion->left;
    }
    else {
      // find the inorder successor of deletion
      BSTNode<T> *successor = minimum(deletion->right);

      if (successor == deletion->right) {
	successor->left = deletion->left;
	successor->left->parent = successor;
      }
      else {
	// take successor out
	successor->parent->left = successor->right;
	if (successor->right) successor->right->parent = successor->parent;

	// put successor in where deletion was
	successor->left = deletion->left;
	successor->left->parent = successor;

	successor->right = deletion->right;
	successor->right->parent = successor;
      }

      // fix successor's parent
      successor->parent = deletion->parent;
      if (rightChild) successor->parent->right = successor;
      else successor->parent->left = successor;

      if (deletion == root) root = successor;
    }

    return true;
  }

  bool contains(const T& val) const override {
    return find(val);
  }

  const TreeNode<T>& getRoot() const override {
    return *this->root;
  }
  
  unsigned int getHeight() const override {
    return getHeight(root);
  }

  bool isValid() const override {
    return isValid(root);
  }

  std::size_t numNodes() const override {
    return numNodes(root);
  }

  void print() const override {
    print(root, "");
  }

private:
  void print(BSTNode<T> *node, std::string prefix) const {
    if (!node) return;

    print(node->right, prefix + "  ");
    std::cout << prefix << " + " << *node->val << std::endl;
    print(node->left, prefix + "  ");
  }
  
  bool isValid(BSTNode<T>* rootNode) const {
    if (!rootNode) return true;
    else if (!rootNode->left && !rootNode->right) return true;
    bool result = true;
    if (rootNode->left) result = result && *rootNode->left->val <= *rootNode->val;
    if (rootNode->right) result = result && *rootNode->right->val >= *rootNode->val;
    return result && isValid(rootNode->left) && isValid(rootNode->right);
  }
  
  unsigned int getHeight(BSTNode<T>* rootNode) const {
    if (!rootNode) return 0;
    else return 1 + std::max(getHeight(rootNode->left), getHeight(rootNode->right));
  }
  
  unsigned int numNodes(BSTNode<T>* rootNode) const {
    if (!rootNode) return 0;
    else return 1 + numNodes(rootNode->left) + numNodes(rootNode->right);
  }
  
  BSTNode<T>* minimum(BSTNode<T>* rootNode) const {
    while (true) {
      if (rootNode == nullptr) return nullptr;
      else if (!rootNode->left) return rootNode;
      else rootNode = rootNode->left;
    }
  }

  BSTNode<T>* find(const T& val) const {
    if (!root) return nullptr;
    
    BSTNode<T> *dummy = this->root;

    while (dummy != nullptr) {
      if (val < *dummy->val) {
	dummy = dummy->left;
      } else if (val > *dummy->val) {
	dummy = dummy->right;
      } else {
	return dummy;
      }
    }
    
    return nullptr;
  }

};


#endif
