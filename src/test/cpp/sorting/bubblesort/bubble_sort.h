#pragma once

#include <algorithm>
#include <array>
#include <iterator>

void bubble_sort(std::vector<int> &vector) {
  bool didFind = true;
  for (int i = vector.size(); i >= 0 && didFind; i--) {
    didFind = false;
    for (int j = 0; j < i - 1; j++) {
      if (vector[j] > vector[j + 1]) {
        didFind = true;
        std::swap(vector[j], vector[j + 1]);
      }
    }
  }
}
