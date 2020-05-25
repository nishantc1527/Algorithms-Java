#pragma once

#include <algorithm>
#include <vector>
#include <iterator>

template <typename Iter>
void selectionSort(const Iter& start, const Iter& end)
{
  int len = std::distance(start, end);
  Iter min, iti = start, itj;
  for (int i = 0; i < len - 1; i++, iti++) {
    itj = iti;
    min = end;
    for (int j = i; j < len; j++, itj++) {
      if (min == end || *itj < *min)
	min = itj;
    }
    
    std::swap(*min, *iti);
    
  }
}
