#ifndef RED_BLACK_TREE
#define RED_BLACK_TREE

#include <vector>
#include <algorithm>

#include "../BinaryTree.h"

template<typename T>
class RedBlackTree : public BinaryTree<T> {
private:
  

  enum Color {RED=0, BLACK};

  template<typename>
  class RBTreeNode : public TreeNode<T> {
    template<typename> friend class RedBlackTree<T>;
  private:
    Color color;

    RBTreeNode<T>* parent;
    RBTreeNode<T>* left;
    RBTreeNode<T>* right;

    RBTreeNode(const T *val_, Color color_)
      : TreeNode<T>(val_), color(color_), parent(nullptr), left(nullptr), right(nullptr) {}
  
    RBTreeNode(const T& val_, Color color_, RBTreeNode<T> *parent_, RBTreeNode<T> *left_, RBTreeNode<T> *right_)
      : TreeNode<T>(val_), color(color_), parent(parent_), left(left_), right(right_) {}
  
    ~RBTreeNode() override {}

    void print() {
      std::cout << *this->val << ", " << color << std::endl;
    }
  
  public:
    const Color& getColor() const {
      return color;
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
  
    const T& getValue() const override {
      return *this->val;
    }
  };


  
  RBTreeNode<T> *NIL, *root;
  
public:
  RedBlackTree() : NIL(new RBTreeNode<T>(nullptr, Color::BLACK)), root(NIL) { }

  ~RedBlackTree() override {
    std::vector<RBTreeNode<T>*> nodes;
    toArray(root, nodes);
    for (auto &i : nodes) {
      delete i;
    }
    delete NIL;
  }

  void insert(const T& val) {
    RBTreeNode<T> *x = root, *y = NIL;
    
    while (x != NIL) {
      y = x;

      if (*x->val == val)
	return;

      if (*x->val > val)
	x = x->left;
      
      else
	x = x->right;
    }
    
    RBTreeNode<T> *z = new RBTreeNode<T>(val, Color::RED, y, NIL, NIL);
    if (y == NIL)
      root = z;
    else if (*z->val < *y->val)
      y->left = z;
    else
      y->right = z;
    insertFix(z);
  }

  void insertFix(RBTreeNode<T> *z) {
    RBTreeNode<T> *y;
    while (z->parent->color == Color::RED) {
      if (z->parent == z->parent->parent->left) {
	y = z->parent->parent->right;
	if (y->color == Color::RED) {
	  z->parent->color = Color::BLACK;
	  y->color = Color::BLACK;
	  z->parent->parent->color = Color::RED;
	  z = z->parent->parent;
	} else {
	  if (z == z->parent->right) {
	    z = z->parent;
	    leftRotate(z);
	  }
	  z->parent->color = Color::BLACK;
	  z->parent->parent->color = Color::RED;
	  rightRotate(z->parent->parent);
	}
      } else {
	y = z->parent->parent->left;
	if (y->color == Color::RED) {
	  z->parent->color = Color::BLACK;
	  y->color = Color::BLACK;
	  z->parent->parent->color = Color::RED;
	  z = z->parent->parent;
	} else {
	  if (z == z->parent->left) {
	    z = z->parent;
	    rightRotate(z);
	  }
	  z->parent->color = Color::BLACK;
	  z->parent->parent->color = Color::RED;
	  leftRotate(z->parent->parent);
	}
      }
    }
    root->color = Color::BLACK;
    NIL->parent = nullptr;
  }

  // removes the given value from the tree
  bool remove(const T& value) {
    RBTreeNode<T> *z = find(value, root);
    if (z == NIL) return false;
    RBTreeNode<T> *x;
    RBTreeNode<T> *y = z;
    Color y_orig_color = y->color;

    if (z->left == NIL) {
      x = z->right;
      transplant(z, z->right);
    } else if (z->right == NIL) {
      x = z->left;
      transplant(z, z->left);
    } else {
      y = successor(z->right);
      y_orig_color = y->color;
      x = y->right;
      if (y->parent == z) x->parent = y;
      else {
	transplant(y, y->right);
	y->right = z->right;
	y->right->parent = y;
      }
      transplant(z, y);
      y->left = z->left;
      y->left->parent = y;
      y->color = z->color;
    }
    if (y_orig_color == Color::BLACK) deleteFix(x);

    return true;
  }

  void deleteFix(RBTreeNode<T> *x) {
    while (x != root && x->color == Color::BLACK) {
      if (x == x->parent->left) {
	RBTreeNode<T> *w = x->parent->right;
	if (w->color == Color::RED) {
	  w->color = Color::BLACK;
	  x->parent->color = Color::RED;
	  leftRotate(x->parent);
	  w = x->parent->right;
	}
	if (w->left->color == Color::BLACK && w->right->color == Color::BLACK) {
	  w->color = Color::RED;
	  x = x->parent;
	  continue;
	} else if (w->right->color == Color::BLACK) {
	  w->left->color = Color::BLACK;
	  w->color = Color::RED;
	  rightRotate(w);
	  w = x->parent->right;
	}
	if (w->right->color == Color::RED) {
	  w->color = x->parent->color;
	  x->parent->color = Color::BLACK;
	  w->right->color = Color::BLACK;
	  leftRotate(x->parent);
	  x = root;
	}
      } else {
	RBTreeNode<T> *w = x->parent->left;
	if (w->color == Color::RED) {
	  w->color = Color::BLACK;
	  x->parent->color = Color::RED;
	  rightRotate(x->parent);
	  w = x->parent->left;
	}
	if (w->right->color == Color::BLACK && w->left->color == Color::BLACK) {
	  w->color = Color::RED;
	  x = x->parent;
	  continue;
	} else if (w->left->color == Color::BLACK) {
	  w->right->color = Color::BLACK;
	  w->color = Color::RED;
	  leftRotate(w);
	  w = x->parent->left;
	}
	if (w->left->color == Color::RED) {
	  w->color = x->parent->color;
	  x->parent->color = Color::BLACK;
	  w->left->color = Color::BLACK;
	  rightRotate(x->parent);
	  x = root;
	}
      }
    }
    x->color = Color::BLACK;
  }

  // checks if the given value exists inside the tree
  bool contains(const T& key) const override {
    RBTreeNode<T> *current = root;
    while (current != NIL) {
      const T &val = current->getValue();
      if (val == key)
	return true;
      else if (val < key)
	current = current->right;
      else
	current = current->left;
    }

    return false;
  }

  // gets the root of the tree as a TreeNode object
  const TreeNode<T>& getRoot() const override {
    return *root;
  }

  // gets the max height of the tree
  unsigned int getHeight() const override {
    return getHeight(root);
  }

  // gets whether the tree is valid
  bool isValid() const override {
    std::vector<RBTreeNode<T>*> nodes;
    toArray(root, nodes);
    return root->color == Color::BLACK && checkAdjacentReds(nodes) && checkBlackHeights(nodes);
  }

  // gets the number of nodes in the tree
  std::size_t numNodes() const {
    std::vector<RBTreeNode<T>*> vec;
    toArray(root, vec);
    return vec.size();
  }

  void print() const {
    print(this->root, "");
  }
  
private:
  void print(RBTreeNode<T>* node, std::string prefix) const {
    if (node == NIL) return;

    print(node->right, prefix + "  ");
    std::cout << prefix << " + " << *node->val << std::endl;
    print(node->left, prefix + "  ");
  }

  bool checkBlackHeights(const std::vector<RBTreeNode<T>*>& nodes) const {
    for (const RBTreeNode<T> *current : nodes) {
      if (current == NIL) continue;
      if (blackHeight(current->left) != blackHeight(current->right))
	return false;
    }

    return true;
  }

  unsigned int blackHeight(RBTreeNode<T> *rootNode) const {
    if (rootNode == NIL) return 1;
    else return (rootNode->color == Color::BLACK ? 1 : 0)
	   + std::max(blackHeight(rootNode->left), blackHeight(rootNode->right));
  }
  
  bool checkAdjacentReds(const std::vector<RBTreeNode<T>*>& nodes) const {
    for (RBTreeNode<T> *current : nodes) {
      if (current == NIL) continue;
      if (current->color == Color::RED) {
	if (current->parent->color == Color::RED
	    || current->left->color == Color::RED
	    || current->right->color == Color::RED) {
	  return false;
	}
      }
    }

    return true;
  }
  
  void toArray(RBTreeNode<T> *rootNode, std::vector<RBTreeNode<T>*>& result) const {
    traverse(rootNode, result);
  }

  void traverse(RBTreeNode<T> *rootNode, std::vector<RBTreeNode<T>*>& result) const {
    if (rootNode == NIL) return;
    result.push_back(rootNode);
    traverse(rootNode->left, result);
    traverse(rootNode->right, result);
  }
  
  unsigned int getHeight(RBTreeNode<T> *rootNode) const {
    if (rootNode == NIL) return 0;
    else return 1 + std::max(getHeight(rootNode->left), getHeight(rootNode->right));
  }
  
  RBTreeNode<T>* find(const T& val, RBTreeNode<T> *rootNode) const {
    if (rootNode == NIL || !rootNode->left || !rootNode->right) return NIL;
    else if (*rootNode->val == val) return rootNode;
    else if (*rootNode->val < val) return find(val, rootNode->right);
    else return find(val, rootNode->left);
  }

  RBTreeNode<T>* successor(RBTreeNode<T> *root) {
    if (root == NIL || root->left == NIL) return root;
    else return successor(root->left);
  }

  void transplant(RBTreeNode<T> *u, RBTreeNode<T> *v) {
    if (u->parent == NIL) 
      root = v;
    else if (u == u->parent->left) 
      u->parent->left = v;
    else 
      u->parent->right = v;
    
    v->parent = u->parent;
  }
  
  void leftRotate(RBTreeNode<T> *x) {
    RBTreeNode<T> *y = x->right;
    x->right = y->left;
    if (y->left != NIL) y->left->parent = x;
    y->parent = x->parent;
    if (x->parent == NIL) root = y;
    if (x == x->parent->left) x->parent->left = y;
    else x->parent->right = y;
    y->left = x;
    x->parent = y;
  }

  void rightRotate(RBTreeNode<T> *y) {
    RBTreeNode<T> *x = y->left;
    y->left = x->right;
    if (x->right != NIL) x->right->parent = y;
    x->parent = y->parent;
    if (y->parent == NIL) root = x;
    if (y == y->parent->left) y->parent->left = x;
    else y->parent->right = x;
    x->right = y;
    y->parent = x;
  }
};

#endif
 
