#pragma once

#include <algorithm>
#include <array>

template <typename T, std::size_t len>
void bubbleSort(std::array<T, len>& items)
{
  const int count = items.size();
  for (int i = count - 1; i >= 0; i--) {
    for (int j = 0; j < i; j++) {
      if (items[j] > items[j + 1]) {
	std::swap(items[j], items[j + 1]);
      }
    }
  }
};

