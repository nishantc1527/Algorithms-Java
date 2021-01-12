#include <vector>
#include <list>
#include <utility>

#include <gtest/gtest.h>

#include "../../../main/graphtheory/shortestpaths/BellmanFord.h"
#include "../../../main/graphtheory/GraphMaker.h"

TEST(ShortestPaths, BellmanFord) {
  std::vector<std::list<std::pair<int, double>>> graph = makeGraphAdjListWeighted(6, {{{0, 1}, 4}, {{1, 2}, 5}, {{1, 3}, 2}, {{2, 3}, 7}, {{0, 2}, 3}, {{3, 4}, 2}, {{4, 0}, 4}, {{4, 1}, 4}, {{4, 5}, 6}});
  bool negWeightCycle;
  std::vector<std::pair<int, double>> res = BellmanFord::shortestPaths(graph, 0, negWeightCycle);
  ASSERT_FALSE(negWeightCycle);
  ASSERT_LT(res[0].first, 0);
  ASSERT_EQ(res[0].second, 0);
  for (int i = 1; i < res.size(); i++) {
    
  }
}
