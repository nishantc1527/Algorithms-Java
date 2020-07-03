#include <gtest/gtest.h>

#include "main/cpp/datastructures/heap/min_heap.h"

TEST(HeapTest, MinHeapTest) {
  std::vector<int> data = {5, 3, 6, 4, 5, 10, 15, 14};

  min_heap<int> heap;
  heap.build_min_heap(data);

  ASSERT_EQ(heap.size(), data.size());

  int prev = heap.extract_min(), current, prevSize = heap.size();
  while (heap.size() > 0) {
    current = heap.minimum();
    ASSERT_TRUE(current >= prev);
    ASSERT_EQ(heap.size(), prevSize);
    
    current = heap.extract_min();
    ASSERT_TRUE(current >= prev);
    ASSERT_EQ(heap.size(), prevSize-1);
    
    prevSize = heap.size();
  }
}
