#include <gtest/gtest.h>
#include <cmath>
#include <vector>
#include <set>

#include "main/cpp/datastructures/trees/binarysearchtrees/redblacktree/RedBlackTree.h"

#include "main/cpp/my_utils.h"

TEST(RedBlackTreeTest, RBTreeTest) {
  std::vector<int> values = my_utils::createRandVector(50, 0, 200);
  std::set<int> valueSet;
  for (int i = 0; i < values.size(); i++)
    valueSet.insert(values[i]);
  
  RedBlackTree<int> tree;
  for (int i = 0; i < values.size(); i++) {
    tree.insert(values[i]);
    ASSERT_TRUE(tree.isValid());
    ASSERT_LE(tree.getHeight(), 2*std::log2(tree.numNodes()+1));
  }
  ASSERT_EQ(tree.numNodes(), 50);
  for (int i = 0; i < values.size(); i++) {
    ASSERT_TRUE(tree.contains(values[i]));
  }
  for (int i = 0; i <= 200; i++) {
    ASSERT_EQ(tree.contains(i), valueSet.count(i));
  }
  for (int i = 0; i < values.size(); i++) {
    ASSERT_TRUE(tree.remove(values[i]));
    ASSERT_TRUE(tree.isValid());
  }
  ASSERT_EQ(tree.numNodes(), 0);
}

int main(int argc, char **argv) {
  ::testing::InitGoogleTest(&argc, argv);
  
  return RUN_ALL_TESTS();
}
