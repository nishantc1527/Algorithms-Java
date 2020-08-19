#include <vector>

#include "redblacktree/RedBlackTree.h"
#include "binarysearchtree/BinarySearchTree.h"
#include "../../../my_utils.h"

int main() {
  std::cout << std::endl << std::endl << std::endl;
  
  std::vector<int> rands = my_utils::createRandVector(20, 1, 50);

  BinarySearchTree<int> tree;
  for (unsigned int i = 0; i < rands.size(); i++) {
    tree.insert(rands[i]);
  }
  tree.print();
  std::cout << "Number of nodes: " << tree.numNodes() << std::endl;
  std::cout << "Height of tree: " << tree.getHeight() << std::endl; 
  
  std::cout << "Finished inserting" << std::endl;

  std::cout << std::endl;

  std::vector<int> containers = my_utils::createRandVector(20, 1, 50);

  for (auto it : containers) {
    std::cout << "Contains " << it << "?: " << (tree.contains(it) ? "true" : "false") << std::endl;
  }
  
  std::cout << std::endl;

  for (unsigned int i = 0; i < rands.size(); i++) {
    if (!tree.remove(rands[i]))
      std::cout << "Fail!!!!!" << std::endl;
    tree.print();
    std::cout << std::endl;
  }
  
  std::cout << std::endl << std::endl << std::endl;
}
