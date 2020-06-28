#include <gtest/gtest.h>
#include <cmath>
#include <vector>
#include <unordered_set>

#include "main/cpp/datastructures/trees/binarysearchtrees/binarysearchtree/BinarySearchTree.h"

#include "main/cpp/my_utils.h"

TEST(BinarySearchTreesTest, NoNodesDeletionTest) {
  BinarySearchTree<int> tree;
  ASSERT_FALSE(tree.remove(1));
}

TEST(BinarySearchTreesTest, Duplicates) {
  BinarySearchTree<int> tree;
  tree.insert(1);
  tree.insert(2);
  tree.insert(1);
  tree.insert(2);

  ASSERT_EQ(tree.numNodes(), 2);
}

TEST(BinarySearchTreesTest, DuplicatesDeletion) {
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
