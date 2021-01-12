#ifndef AVL_TREE
#define AVL_TREE

template <typename T>
class AVLTree {
private:
  template<typename>
  class AVLTreeNode {
  private:
    std::size_t height;
    int balanceFactor;
    int val;
    
    AVLTreeNode<T> *parent;
    AVLTreeNode<T> *left;
    AVLTreeNode<T> *right;

    AVLTreeNode(const T *val_)
      : val(val_), parent(nullptr), left(nullptr), right(nullptr) {}
  
    AVLTreeNode(const T& val_, AVLTreeNode<T> *parent_, AVLTreeNode<T> *left_, AVLTreeNode<T> *right_)
      : parent(parent_), left(left_), right(right_) {}
  
    ~AVLTreeNode() {
      if (left)
	delete left;
      if (right)
	delete right;
    }

    void print() const {
      std::cout << *this->getVal() << std::endl;
    }
  
  public:
    AVLTreeNode<T>* getParent() const override {
      return parent;
    }

    AVLTreeNode<T>* getLeft() const override {
      return left;
    }

    AVLTreeNode<T>* getRight() const override {
      return right;
    }
  
    const T& getValue() const override {
      return *this->getVal();
    }

    int getBalanceFactor() const {
      return balanceFactor;
    }

    int getVal() const {
      return val;
    }
  };

  AVLTreeNode<T> *rootParent, *root;

public:
  AVLTree() {
    rootParent = new AVLTreeNode<T>(nullptr);
    root = nullptr;
  }

  ~AVLTree() {
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
      if (val == *current->getVal())
	return;
      
      else if (val < *current->getVal()) 
        current = current->left;
      
      else 
        current = current->right;
    }

    AVLTreeNode<T> *insertion;
    if (val < *parent->getVal()) {
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

    while (*deletion->getVal() != val) {
      if (val < *deletion->getVal())
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

      // delete deletion;
    }
    
    else if (!deletion->left) {
      successor = deletion->right;
      
      if (deletion == deletion->parent->left)
	deletion->parent->left = successor;
      else
	deletion->parent->right = successor;
      
      successor->parent = deletion->parent;
      
      updateBalanceFactorsAndHeights(deletion->parent);

      /*
      deletion->right = nullptr;
      delete deletion;
      */
    }
    else if (!deletion->right) {
      successor = deletion->left;
      
      if (deletion == deletion->parent->left)
	deletion->parent->left = successor;
      else
	deletion->parent->right = successor;
      
      successor->parent = deletion->parent;
      
      updateBalanceFactorsAndHeights(deletion->parent);

      /*
      deletion->left = nullptr;
      delete deletion;
      */
      
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
      if (*current->getVal() == val)
	return true;
      else if (*current->getVal() < val)
	current = current->right;
      else
	current = current->left;
    }

    return false;
  }

  bool isValid() const {
    // calcBalanceFactor(root);
    return isValidBST(root) && isValidAVLTree(root);
  }

  const AVLTreeNode<T>& getRoot() const override {
    return *this->root;
  }
  
  unsigned int getHeight() const {
    return getHeight(root);
  }

  std::size_t numNodes() const {
    return numNodes(root);
  }

  void print() const {
    print(root, "");
  }

private:
  
  bool isValidBST(AVLTreeNode<T> *root) const {
    if (!root)
      return true;
    
    if (root->getLeft() && root->getLeft()->parent != root)
      return false;
    
    if (root->getRight() && root->getRight()->parent != root)
      return false;
    
    if (root->parent->left != root && root->parent->right != root)
      return false;
    
    if (root->getLeft() && root->getVal() < *root->getLeft()->getVal())
      return false;

    if (root->getRight() && *root->getRight()->getVal() < root->getVal())
      return false;
    
    return isValidBST(root->getLeft()) && isValidBST(root->getRight());
  }

  bool isValidAVLTree(AVLTreeNode<T> *root) const {
    if (!root) return true;
    return std::abs(root->getBalanceFactor()) <= 1
        && isValidAVLTree(root->getLeft())
        && isValidAVLTree(root->getRight());
  }
  
  void fixTree(AVLTreeNode<T> *root) {
    if (!root || (!root->getLeft() && !root->getRight())) return;
    fixTree(root->getLeft());
    fixTree(root->getRight());

    int bf = root->getBalanceFactor();
    if (abs(bf) < 2) return;
    if (bf >= 2) {
      bool lr = root->getLeft()->balanceFactor < 0;
      if (lr)
	leftRotate(root->getLeft());

      rightRotate(root);
    }
    else if (bf <= 2) {
      bool rl = root->getRight()->balanceFactor > 0;
      if (rl)
	rightRotate(root->getRight());
      leftRotate(root);
    }

    this->root = rootParent->left;
  }

  void rightRotate(AVLTreeNode<T> *root) {
    AVLTreeNode<T> *leftSide = root->getLeft();
    if (root == root->parent->left) {
      root->parent->left = leftSide;
    }
    else {
      root->parent->right = leftSide;
    }
    leftSide->parent = root->parent;

    root->getLeft() = leftSide->right;
    if (leftSide->right) leftSide->right->parent = root;
    leftSide->right = root;
    root->parent = leftSide;

    updateBalanceFactorsAndHeights(root);
  }

  void leftRotate(AVLTreeNode<T> *root) {
    AVLTreeNode<T> *rightSide = root->getRight();
    if (root == root->parent->left) {
      root->parent->left = rightSide;
    } else {
      root->parent->right = rightSide;
    }
    rightSide->parent = root->parent;

    root->getRight() = rightSide->left;
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
    calcBalanceFactor(root->getLeft());
    calcBalanceFactor(root->getRight());
    setBalanceFactors(root);
  }

  void setBalanceFactors(AVLTreeNode<T> *root) {
    if (!root->getLeft() && !root->getRight()) {
      root->height = 1;
      root->getBalanceFactor() = 0;
    } else if (!root->getRight()) {
      root->height = root->getLeft()->height + 1;
      root->getBalanceFactor() = root->getLeft()->height;
    } else if (!root->getLeft()) {
      root->height = root->getRight()->height + 1;
      root->getBalanceFactor() = -root->getRight()->height;
    } else {
      root->height = std::max(root->getLeft()->height, root->getRight()->height) + 1;
      root->getBalanceFactor() = root->getLeft()->height - root->getRight()->height;
    }
  }

  void calcHeights(AVLTreeNode<T> *root) {
    if (root) {
      if (!root->getLeft() && !root->getRight()) {
        root->height = 1;
      } else if (!root->getLeft()) {
        calcHeights(root->getRight());
        root->height = root->getRight()->height + 1;
      } else if (!root->getRight()) {
        calcHeights(root->getLeft());
        root->height = root->getLeft()->height + 1;
      } else {
        calcHeights(root->getLeft());
        calcHeights(root->getRight());
        root->height = std::max(root->getLeft()->height, root->getRight()->height) + 1;
      }
    }
  }
  
  void print(AVLTreeNode<T> *node, std::string prefix) const {
    if (!node) return;

    print(node->right, prefix + "  ");
    std::cout << prefix << " + " << *node->getVal() << std::endl;
    print(node->left, prefix + "  ");
  }

  AVLTreeNode<T>* minimum(AVLTreeNode<T> *root) const {
    if (!root || !root->getLeft())
      return root;
    else
      return minimum(root->getLeft());
  }

  std::size_t getHeight(AVLTreeNode<T> *root) const {
    if (!root) return 0;
    else return  1 + std::max(getHeight(root->getLeft()), getHeight(root->getRight()));
  }

  std::size_t numNodes(AVLTreeNode<T> *root) const {
    if (!root) return 0;
    else return 1 + numNodes(root->getLeft()) + numNodes(root->getRight());
  }
};

#endif
