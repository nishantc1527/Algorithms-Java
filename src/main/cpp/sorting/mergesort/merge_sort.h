#pragma once

#include <vector>
#include <algorithm>
#include <iostream>

void merge_sort(std::vector<int> &vector, int left, int right);

void merge(std::vector<int> &vector, const std::vector<int> &left, const std::vector<int> &right, int left_index);

void merge_sort(std::vector<int> &vector) {
  merge_sort(vector, 0, vector.size());
}

void merge_sort(std::vector<int> &vector, int left, int right) {
  if (left >= right - 1) {
    return;
  }

  int mid = left + (right - left) / 2;
  merge_sort(vector, left, mid);
  merge_sort(vector, mid, right);
  merge(vector, std::vector<int>(vector.begin() + left, vector.begin() + mid),
        std::vector<int>(vector.begin() + mid, vector.begin() + right), left);
}

void merge(std::vector<int> &vector, const std::vector<int> &left, const std::vector<int> &right, int left_index) {
  int i = 0, j = 0, k = left_index;

  while (i < left.size() || j < right.size()) {
    if (i >= left.size()) {
      vector[k++] = right[j++];
    } else if (j >= right.size()) {
      vector[k++] = left[i++];
    } else {
      if (left[i] < right[j]) {
        vector[k++] = left[i++];
      } else {
        vector[k++] = right[j++];
      }
    }
  }
}
