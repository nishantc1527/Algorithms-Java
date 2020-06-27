#include <gtest/gtest.h>
#include <cmath>
#include <vector>
#include <unordered_set>

#include "main/cpp/datastructures/trees/binarysearchtrees/binarysearchtree/BinarySearchTree.h"

#include "main/cpp/my_utils.h"

TEST(BinarySearchTreeTest, NoNodesDeletionTest) {
  BinarySearchTree<int> tree;
  ASSERT_FALSE(tree.remove(1));
}

TEST(BinarySearchTreeTest, Duplicates) {
  BinarySearchTree<int> tree;
  tree.insert(1);
  tree.insert(2);
  tree.insert(1);
  tree.insert(2);

  ASSERT_EQ(tree.numNodes(), 2);
}

TEST(BinarySearchTreeTest, DuplicatesDeletion) {
  BinarySearchTree<int> tree;
  tree.insert(1);
  tree.insert(2);
  tree.insert(1);
  ASSERT_TRUE(tree.remove(1));
  ASSERT_FALSE(tree.remove(1));
  ASSERT_FALSE(tree.remove(1));
  ASSERT_TRUE(tree.remove(2));

  ASSERT_EQ(tree.numNodes(), 0);
}

int main(int argc, char **argv) {
  testing::InitGoogleTest(&argc, argv);
  
  return RUN_ALL_TESTS();
}
