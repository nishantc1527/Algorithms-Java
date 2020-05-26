#pragma once

#include <vector>
#include <algorithm>
#include <iostream>
#include "my_utils.h"

template <typename Iter>
void mergeArr(const Iter& start, const Iter& mid, const Iter& end) {
  Iter first = start, second = mid;
  
  std::vector<typename std::iterator_traits<Iter>::value_type> newVec;
  while (first != mid && second != end) {
    if (*first < *second) {
      newVec.push_back(*first);
      ++first;
    }
    else {
      newVec.push_back(*second);
      ++second;
    }
  }
  
  while (first != mid) {
    newVec.push_back(*first);
    first++;
  }

  while (second != end) {
    newVec.push_back(*second);
    second++;
  }
  
  Iter i = start;
  for (auto it = newVec.begin(); it != newVec.end(); it++, i++) {
    *i = *it;
  }
}

template <typename Iter>
void mergeSort(const Iter& start, const Iter& end) {
  int len = std::distance(start, end);
  
  if (len <= 1) return;

  mergeSort(start, start + len / 2);
  mergeSort(start + len / 2, end);

  mergeArr(start, start + len / 2, end);
}
