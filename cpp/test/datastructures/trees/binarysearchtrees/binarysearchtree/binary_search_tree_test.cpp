#include <gtest/gtest.h>

#include <cmath>
#include <vector>
#include <set>
#include <unordered_set>

#include "../../../../main/datastructures/trees/binarysearchtrees/binary_search_tree.hpp"

#include "../../../../main/my_utils.h"

TEST(BinarySearchTreesTest, BinarySearchTreeTest) {
  std::vector<int> values = my_utils::createRandVector(50, 0, 200);
  std::set<int> valueSet;
  for (int i = 0; i < values.size(); i++)
    valueSet.insert(values[i]);

  BinarySearchTree<int> tree;
  for (int i = 0; i < values.size(); i++) {
    tree.insert(values[i]);
    ASSERT_TRUE(tree.isValid());
  }
  ASSERT_EQ(tree.numNodes(), valueSet.size());
  for (int i = 0; i < values.size(); i++) {
    ASSERT_TRUE(tree.contains(values[i]));
  }
  for (int i = 0; i <= 200; i++) {
    ASSERT_EQ(tree.contains(i), valueSet.count(i));
  }
  for (int i = 0; i < values.size(); i++) {
    tree.remove(values[i]);
    ASSERT_TRUE(tree.isValid());
  }
  ASSERT_EQ(tree.numNodes(), 0);
}
