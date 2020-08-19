//
// Created by nisha on 6/3/2020.
//

#pragma once

#include <vector>

static int heap_size;

int get_left(int i);
int get_right(int i);
void heapify(std::vector<int>& vector, int i);
void make_heap(std::vector<int>& vector);
void pop_max(std::vector<int>& vector);

void heap_sort(std::vector<int>& vector) {
  make_heap(vector);

  while(heap_size > 0) {
    pop_max(vector);
  }
}

int get_left(int i) {
  return (i << 1) + 1;
}

int get_right(int i) {
  return (i << 1) + 2;
}

int get_parent(int i) {
  return i % 2 == 0 ? (i >> 1) - 1 : (i >> 1);
}

void heapify(std::vector<int>& vector, int i) {
  int left = get_left(i), right = get_right(i), max = i;

  if(left < heap_size && vector[left] > vector[max]) {
    max = left;
  }

  if(right < heap_size && vector[right] > vector[max]) {
    max = right;
  }

  if(max != i) {
    std::swap(vector[i], vector[max]);
    heapify(vector, max);
  }
}

void make_heap(std::vector<int>& vector) {
  heap_size = vector.size();

  for(int i = (heap_size >> 1) - 1; i >= 0; i --) {
    heapify(vector, i);
  }
}

void pop_max(std::vector<int>& vector) {
  std::swap(vector[--heap_size], vector[0]);
  heapify(vector, 0);
}
