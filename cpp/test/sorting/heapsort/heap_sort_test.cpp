//
// Created by nisha on 6/2/2020.
//

#include <gtest/gtest.h>

#include "../../../main/sorting/heapsort/heap_sort.hpp"
#include "../../../main/my_utils.h"

TEST(Sorting, HeapSortTest) {
  std::vector<int> arr = my_utils::createRandVector(10000, 1, 1000000);
  std::vector<int> copy = arr;
  
  std::sort(copy.begin(), copy.end());
  heap_sort(arr);
  ASSERT_EQ(copy, arr);
}
