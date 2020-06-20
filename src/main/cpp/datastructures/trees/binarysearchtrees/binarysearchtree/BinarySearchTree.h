#ifndef BINARY_SEARCH_TREE
#define BINARY_SEARCH_TREE

#include <algorithm>
#include <iostream>

#include "../BinaryTree.h"

template<typename T>
class BinarySearchTree : public BinaryTree<T> {
public:
  BinarySearchTree() : BinaryTree<T>(nullptr, nullptr) {
    this->root = nullptr;
  }

  ~BinarySearchTree() override {
    std::cout << "Deleting" << "\n";

    if (this->rootParent) delete this->rootParent;
  }

  void insert(const T& val) override {
    if (this->rootParent == nullptr) {
      this->rootParent = new TreeNode<T>(val);
    }
    
    if (this->root == nullptr) {
      this->root = new TreeNode<T>(val, this->rootParent);
      this->rootParent->left = this->root;
      return;
    }

    TreeNode<T> *dummy = this->root;

    while (true) {
      if (val < dummy->val) {
	if (dummy->left == nullptr) {
	  dummy->left = new TreeNode<T>(val, dummy);
	  return;
	}

	dummy = dummy->left;
      }
      else {
	if (dummy->right == nullptr) {
	  dummy->right = new TreeNode<T>(val, dummy);
	  return;
	}

	dummy = dummy->right;
      }
    }
  }

  bool remove(const T& value) override {
    TreeNode<T> *deletion = find(value);
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
      TreeNode<T> *successor = minimum(deletion->right);

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

      if (deletion == this->root) this->root = successor;
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
    return getHeight(this->root);
  }

  bool isValid() const override {
    return isValid(this->root);
  }

  unsigned int numNodes() const override {
    return numNodes(this->root);
  }


private:
  bool isValid(TreeNode<T>* rootNode) const {
    if (!rootNode) return true;
    else if (!rootNode->left && !rootNode->right) return true;
    bool result = true;
    if (rootNode->left) result = result && rootNode->left->val <= rootNode->val;
    if (rootNode->right) result = result && rootNode->right->val >= rootNode->val;
    return result && isValid(rootNode->left) && isValid(rootNode->right);
  }
  
  unsigned int getHeight(TreeNode<T>* rootNode) const {
    if (!rootNode) return 0;
    else return 1 + std::max(getHeight(rootNode->left), getHeight(rootNode->right));
  }
  
  unsigned int numNodes(TreeNode<T>* rootNode) const {
    if (!rootNode) return 0;
    else return 1 + numNodes(rootNode->left) + numNodes(rootNode->right);
  }
  
  TreeNode<T>* minimum(TreeNode<T>* rootNode) const {
    while (true) {
      if (rootNode == nullptr) return nullptr;
      else if (!rootNode->left) return rootNode;
      else rootNode = rootNode->left;
    }
  }

  TreeNode<T>* find(const T& val) const {
    if (this->root == nullptr) return nullptr;
    
    TreeNode<T> *dummy = this->root;

    while (dummy != nullptr) {
      if (val < dummy->val) {
	dummy = dummy->left;
      } else if (val > dummy->val) {
	dummy = dummy->right;
      } else {
	return dummy;
      }
    }
    
    return nullptr;
  }

};


#endif
