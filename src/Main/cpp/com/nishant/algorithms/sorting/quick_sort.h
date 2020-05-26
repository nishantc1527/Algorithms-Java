#pragma once

#include <iterator>
#include <algorithm>
#include <iostream>
#include <typeinfo>

#include "my_utils.h"

template<typename Iter>
Iter partition(const Iter& begin, const Iter& end) {
  Iter left = begin, right = end - 1;
  
  Iter partition = begin;
  int len = std::distance(begin, end);
  auto pivot = *right;

  for (Iter it = begin; it < end - 1; it++) {
    if (*it < pivot) {
      std::swap(*it, *partition);
      partition++;
    }
  }

  std::swap(*partition, *right);

  return partition;
}

template<typename Iter>
void quickSort(const Iter& begin, const Iter& end) {
  int len = std::distance(begin, end);
  if (len <= 1) return;

  const Iter partitionIter = partition(begin, end);
  
  quickSort(begin, partitionIter);
  quickSort(partitionIter + 1, end);
}
