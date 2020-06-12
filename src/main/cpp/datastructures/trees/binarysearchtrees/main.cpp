#include <vector>

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

  std::cout << std::endl;

  tree.remove(rands[0]);
  tree.print();

  std::cout << std::endl;

  std::vector<int> containers = my_utils::createRandVector(20, 1, 50);

  for (auto it = containers.begin(); it != containers.end(); ++it) {
    std::cout << "Contains " << *it << "?: " << (tree.contains(*it) ? "true" : "false") << std::endl;
  }
  
  std::cout << std::endl << std::endl << std::endl;
}
