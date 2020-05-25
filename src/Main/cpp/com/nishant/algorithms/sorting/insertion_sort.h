#pragma once

#include <algorithm>
#include <array>
#include <iterator>

template<typename Iter>
void insertionSort(const Iter& start, const Iter& end) {
  int len = std::distance(start, end);
  Iter iti = start, itj1, itj2;
  iti++;
  typename std::iterator_traits<Iter>::value_type current;
  for (int i = 1; i < len; i++, iti++) {
    current = *iti;
    itj1 = iti;
    itj2 = iti;
    itj2--;
    for (int j = i; j >= 1 && *itj2 > current; j--, itj1--, itj2--) {
      *itj1 = *itj2;
    }

    *itj1 = current;
  }
}
