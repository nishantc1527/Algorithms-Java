#pragma once

#include <algorithm>
#include <array>

template<typename T, std::size_t len>
  void insertionSort(std::array<T, len>& arr) {
  int current, j;
  for (int i = 0; i < len; i++) {
    current = arr[i];
    for (j = i; j >= 1 && current < arr[j - 1]; j--) {
      arr[j] = arr[j - 1];
    }

    arr[j] = current;
  }
}
