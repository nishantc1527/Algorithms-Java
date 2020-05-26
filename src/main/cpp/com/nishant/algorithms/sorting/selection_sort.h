#pragma once

#include <algorithm>
#include <array>

template <typename T, std::size_t len>
void selectionSort(std::array<T, len>& items)
{
  int minIndex;
  for (int i = 0; i < len - 1; i++) {
    minIndex = i;
    for (int j = i + 1; j < len; j++) {
      if (items[j] < items[minIndex])
	minIndex = j;
    }
    
    std::swap(items[minIndex], items[i]);
  }
}
