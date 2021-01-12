#pragma once

#include <iterator>
#include <algorithm>
#include <iostream>
#include <typeinfo>

void quick_sort(std::vector<int> &vector, int left, int right);

int partition(std::vector<int> &vector, int left, int right);

void quick_sort(std::vector<int> &vector) {
  quick_sort(vector, 0, vector.size());
}

void quick_sort(std::vector<int> &vector, int left, int right) {
  if (left >= right - 1) {
    return;
  }

  int pivot_index = partition(vector, left, right);
  quick_sort(vector, left, pivot_index);
  quick_sort(vector, pivot_index + 1, right);
}

int partition(std::vector<int> &vector, int left, int right) {
  int pivot_index = right - 1;
  int partition_index = left;

  for (int i = left; i < right - 1; i++) {
    if (vector[i] < vector[pivot_index]) {
      std::swap(vector[partition_index++], vector[i]);
    }
  }

  std::swap(vector[partition_index], vector[pivot_index]);
  return partition_index;
}
