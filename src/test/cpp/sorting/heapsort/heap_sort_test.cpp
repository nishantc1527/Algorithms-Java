//
// Created by nisha on 6/2/2020.
//

#include <algorithm>
#include <gtest/gtest.h>

#include "../../../../main/cpp/sorting/heapsort/heap_sort.hpp"
#include "../../../../main/cpp/my_utils.h"

TEST(Sorting, HeapSortTest) {
  for(int i = 0; i < 1000; i ++) {
    std::vector<int> arr = my_utils::createRandVector(5000, 0, 1000);

    std::vector<int> temp = arr;
    std::sort(temp.begin(), temp.end());
    heap_sort(arr);
    ASSERT_EQ(temp, arr);
  }
}
