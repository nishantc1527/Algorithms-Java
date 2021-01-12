//
// Created by nisha on 6/2/2020.
//

#include <gtest/gtest.h>

#include "../../../main/sorting/mergesort/merge_sort.h"
#include "../../../main/my_utils.h"

TEST(Sorting, MergeSortTest) {
  std::vector<int> arr = my_utils::createRandVector(10000, 1, 1000000);
  std::vector<int> copy = arr;
  
  std::sort(copy.begin(), copy.end());
  merge_sort(arr);
  ASSERT_EQ(copy, arr);
}
