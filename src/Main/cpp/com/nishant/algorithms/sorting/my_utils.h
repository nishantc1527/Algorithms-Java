#pragma once

#include <iostream>
#include <ctime>

namespace my_utils {
  template<typename T, int len>
  void printArr(std::array<T, len> arr) {
    for (int i = 0; i < len - 1; i++) {
      std::cout << arr[i] << ", ";
    }
    std::cout << arr[len - 1] << std::endl;
  }

  template<typename T, int len>
    bool isSorted(std::array<T, len> arr) {
    if (len == 0) return true;
    for (int i = 1; i < len; i++) {
      if (arr[i] < arr[i - 1])
	return false;
    }

    return true;
  }

  template<int len>
  std::array<int, len> createRandArray(int min, int max) {
    srand((unsigned) time(0));

    std::array<int, len> arr;
    for (int i = 0; i < arr.size(); i++) {
      arr[i] = rand() % (max - min) + min;
    }

    return arr;
  }
}
