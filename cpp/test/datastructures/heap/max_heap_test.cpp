#include <gtest/gtest.h>

//#include "main/cpp/datastructures/heap/max_heap.h"
//
//TEST(HeapTest, MaxHeap) {
//  std::vector<int> data = {5, 3, 6, 4, 5, 10, 15, 14};
//
//  max_heap<int> heap;
//  heap.build_max_heap(data);
//
//  ASSERT_EQ(heap.size(), data.size());
//
//  int prev = heap.extract_max(), current, prevSize = heap.size();
//  while (heap.size() > 0) {
//    current = heap.maximum();
//    ASSERT_TRUE(current <= prev);
//    ASSERT_EQ(heap.size(), prevSize);
//
//    current = heap.extract_max();
//    ASSERT_TRUE(current <= prev);
//    ASSERT_EQ(heap.size(), prevSize-1);
//
//    prevSize = heap.size();
//  }
//}
