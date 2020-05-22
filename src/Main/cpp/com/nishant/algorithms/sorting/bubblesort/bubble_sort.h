#pragma once

#include <algorithm>
#include <iostream>

template <typename T>
void BubbleSort(T* items, int count)
{
  for (int i = count - 1; i >= 0; i--) {
    for (int j = 0; j < i; j++) {
      if (items[j] > items[j + 1]) {
	std::swap(items[j], items[j + 1]);
      }
    }
  }

  std::cout << "inside header" << std::endl;
};
