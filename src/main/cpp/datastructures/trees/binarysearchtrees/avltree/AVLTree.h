#ifndef AVL_TREE
#define AVL_TREE

#include "../BinaryTree.h"

template <typename T>
class AVLTree : public BinaryTree<T> {
private:
  template<typename>
  class AVLTreeNode : public TreeNode<T> {
    template<typename> friend class AVLTree<T>;
  private:
    std::size_t height;
    int balanceFactor;
    
    AVLTreeNode<T> *parent;
    AVLTreeNode<T> *left;
    AVLTreeNode<T> *right;

    AVLTreeNode(const T *val_)
      : TreeNode<T>(val_), parent(nullptr), left(nullptr), right(nullptr) {}
  
    AVLTreeNode(const T& val_, AVLTreeNode<T> *parent_, AVLTreeNode<T> *left_, AVLTreeNode<T> *right_)
      : TreeNode<T>(val_), parent(parent_), left(left_), right(right_) {}
  
    ~AVLTreeNode() override {
      if (left)
	delete left;
      if (right)
	delete right;
    }

    void print() const {
      std::cout << *this->val << std::endl;
    }
  
  public:
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

  AVLTreeNode<T> *rootParent, *root;

public:
  AVLTree() {
    rootParent = new AVLTreeNode<T>(nullptr);
    root = nullptr;
  }

  ~AVLTree() override {
    delete rootParent;
  }

  void insert(const T& val) override {
    if (!root) {
      root = new AVLTreeNode<T>(val, rootParent, nullptr, nullptr);
      rootParent->left = root;
      calcBalanceFactor(root);
      return;
    }

    AVLTreeNode<T> *parent = root, *current = root;
    while (current) {
      parent = current;
      if (val == *current->val)
	return;
      
      else if (val < *current->val) 
        current = current->left;
      
      else 
        current = current->right;
    }

    AVLTreeNode<T> *insertion;
    if (val < *parent->val) {
      insertion = parent->left = new AVLTreeNode<T>(val, parent, nullptr, nullptr);
    } else {
      insertion = parent->right = new AVLTreeNode<T>(val, parent, nullptr, nullptr);
    }

    updateBalanceFactorsAndHeights(insertion);

    fixTree(root);
  }

  bool remove(const T& val) override {
    AVLTreeNode<T> *deletion = root, *successor;
    
    if (!deletion)
      return false;

    while (*deletion->val != val) {
      if (val < *deletion->val)
	deletion = deletion->left;
      else
	deletion = deletion->right;
      
      if (!deletion)
	return false;  
    }

    if (!deletion->left && !deletion->right) {
      if (deletion == deletion->parent->left)
	deletion->parent->left = nullptr;
      else
	deletion->parent->right = nullptr;
      
      updateBalanceFactorsAndHeights(deletion->parent);
    }
    
    else if (!deletion->left) {
      successor = deletion->right;
      
      if (deletion == deletion->parent->left)
	deletion->parent->left = successor;
      else
	deletion->parent->right = successor;
      
      successor->parent = deletion->parent;
      
      updateBalanceFactorsAndHeights(deletion->parent);
    }
    else if (!deletion->right) {
      successor = deletion->left;
      
      if (deletion == deletion->parent->left)
	deletion->parent->left = successor;
      else
	deletion->parent->right = successor;
      
      successor->parent = deletion->parent;
      
      updateBalanceFactorsAndHeights(deletion->parent);
    }
    else {
      successor = minimum(deletion->right);
      AVLTreeNode<T> *rightSide = successor->right, *update;
      
      if (!rightSide) {
	if (successor->parent == deletion) {
	  update = successor;
	}
	else {
	  update = successor->parent;
	}
      }
      else {
	update = rightSide;
      }
      
      if (successor == successor->parent->right) {
	successor->parent->right = rightSide;
      }
      else {
	successor->parent->left = rightSide;
      }
      
      if (rightSide) {
	rightSide->parent = successor->parent;
      }

      successor->parent = deletion->parent;

      if (deletion == deletion->parent->left) successor->parent->left = successor;
      else successor->parent->right = successor;

      successor->left = deletion->left;

      successor->left->parent = successor;
      successor->right = deletion->right;

      if (successor->right) {
	successor->right->parent = successor;
      }

      updateBalanceFactorsAndHeights(update);
    }
    
    root = rootParent->left;
    fixTree(root);

    return true;
  }

  bool contains(const T& val) const override {
    AVLTreeNode<T> *current = root;
    while (current) {
      if (*current->val == val)
	return true;
      else if (*current->val < val)
	current = current->right;
      else
	current = current->left;
    }

    return false;
  }

  bool isValid() const override {
    // calcBalanceFactor(root);
    return isValidBST(root) && isValidAVLTree(root);
  }

  const TreeNode<T>& getRoot() const override {
    return *this->root;
  }
  
  unsigned int getHeight() const override {
    return getHeight(root);
  }

  std::size_t numNodes() const override {
    return numNodes(root);
  }

  void print() const override {
    print(root, "");
  }

private:
  
  bool isValidBST(AVLTreeNode<T> *root) const {
    if (!root)
      return true;
    
    if (root->left && root->left->parent != root)
      return false;
    
    if (root->right && root->right->parent != root)
      return false;
    
    if (root->parent->left != root && root->parent->right != root)
      return false;
    
    if (root->left && *root->val < *root->left->val)
      return false;

    if (root->right && *root->right->val < *root->val)
      return false;
    
    return isValidBST(root->left) && isValidBST(root->right);
  }

  bool isValidAVLTree(AVLTreeNode<T> *root) const {
    if (!root) return true;
    return std::abs(root->balanceFactor) <= 1
        && isValidAVLTree(root->left)
        && isValidAVLTree(root->right);
  }
  
  void fixTree(AVLTreeNode<T> *root) {
    if (!root || (!root->left && !root->right)) return;
    fixTree(root->left);
    fixTree(root->right);

    int bf = root->balanceFactor;
    if (abs(bf) < 2) return;
    if (bf >= 2) {
      bool lr = root->left->balanceFactor < 0;
      if (lr)
	leftRotate(root->left);

      rightRotate(root);
    }
    else if (bf <= 2) {
      bool rl = root->right->balanceFactor > 0;
      if (rl)
	rightRotate(root->right);
      leftRotate(root);
    }

    this->root = rootParent->left;
  }

  void rightRotate(AVLTreeNode<T> *root) {
    AVLTreeNode<T> *leftSide = root->left;
    if (root == root->parent->left) {
      root->parent->left = leftSide;
    }
    else {
      root->parent->right = leftSide;
    }
    leftSide->parent = root->parent;

    root->left = leftSide->right;
    if (leftSide->right) leftSide->right->parent = root;
    leftSide->right = root;
    root->parent = leftSide;

    updateBalanceFactorsAndHeights(root);
  }

  void leftRotate(AVLTreeNode<T> *root) {
    AVLTreeNode<T> *rightSide = root->right;
    if (root == root->parent->left) {
      root->parent->left = rightSide;
    } else {
      root->parent->right = rightSide;
    }
    rightSide->parent = root->parent;

    root->right = rightSide->left;
    if (rightSide->left) rightSide->left->parent = root;
    rightSide->left = root;
    root->parent = rightSide;

    updateBalanceFactorsAndHeights(root);
  }

  void updateBalanceFactorsAndHeights(AVLTreeNode<T> *root) {
    if (!root || !this->root) return;
    while (root != rootParent) {
      setBalanceFactors(root);
      root = root->parent;
    }
  }

  void calcBalanceFactor(AVLTreeNode<T> *root) {
    if (!root) return;
    calcBalanceFactor(root->left);
    calcBalanceFactor(root->right);
    setBalanceFactors(root);
  }

  void setBalanceFactors(AVLTreeNode<T> *root) {
    if (!root->left && !root->right) {
      root->height = 1;
      root->balanceFactor = 0;
    } else if (!root->right) {
      root->height = root->left->height + 1;
      root->balanceFactor = root->left->height;
    } else if (!root->left) {
      root->height = root->right->height + 1;
      root->balanceFactor = -root->right->height;
    } else {
      root->height = std::max(root->left->height, root->right->height) + 1;
      root->balanceFactor = root->left->height - root->right->height;
    }
  }

  void calcHeights(AVLTreeNode<T> *root) {
    if (root) {
      if (!root->left && !root->right) {
        root->height = 1;
      } else if (!root->left) {
        calcHeights(root->right);
        root->height = root->right->height + 1;
      } else if (!root->right) {
        calcHeights(root->left);
        root->height = root->left->height + 1;
      } else {
        calcHeights(root->left);
        calcHeights(root->right);
        root->height = std::max(root->left->height, root->right->height) + 1;
      }
    }
  }
  
  void print(AVLTreeNode<T> *node, std::string prefix) const {
    if (!node) return;

    print(node->right, prefix + "  ");
    std::cout << prefix << " + " << *node->val << std::endl;
    print(node->left, prefix + "  ");
  }

  AVLTreeNode<T>* minimum(AVLTreeNode<T> *root) const {
    if (!root || !root->left)
      return root;
    else
      return minimum(root->left);
  }

  std::size_t getHeight(AVLTreeNode<T> *root) const {
    if (!root) return 0;
    else return  1 + std::max(getHeight(root->left), getHeight(root->right));
  }

  std::size_t numNodes(AVLTreeNode<T> *root) const {
    if (!root) return 0;
    else return 1 + numNodes(root->left) + numNodes(root->right);
  }
};

#endif
