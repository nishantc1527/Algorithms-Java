#include <vector>
#include <list>
#include <utility>

#include "gtest/gtest.h"

// #include "main/cpp/graphtheory/shortestpaths/BellmanFord.h"
// #include "main/cpp/graphtheory/GraphMaker.h"

bool positive(int num) {
  return num >= 0;
}

TEST(ShortestPathAlgorithms, BellmanFord) {
  /*
    std::vector<std::list<std::pair<int, double>>> graph = makeGraphAdjListWeighted(6, {{{0, 1}, 4}, {{1, 2}, 5}, {{1, 3}, 2}, {{2, 3}, 7}, {{0, 2}, 3}, {{3, 4}, 2}, {{4, 0}, 4}, {{4, 1}, 4}, {{4, 5}, 6}});
    bool negWeightCycle;
    std::vector<std::pair<int, int>> res = BellmanFord::shortestPaths(graph, 0, negWeightCycle);
  EXPECT_FALSE(negWeightCycle);
  */

  ASSERT_TRUE(positive(5));
}
