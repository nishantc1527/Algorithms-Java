//
// Created by nisha on 6/3/2020.
//

#ifndef HEAP_SORT
#define HEAP_SORT

#include <vector>

inline int get_left(int i) {
  return (i << 1) + 1;
}

inline int get_right(int i) {
  return (i << 1) + 2;
}

inline int get_parent(int i) {
  return (i-1) >> 1;
}

template <typename T>
void heapify(std::vector<T>& vector, int i, std::size_t &heap_size);
template <typename T>
void make_heap(std::vector<T>& vector, std::size_t &heap_size);
template <typename T>
void pop_max(std::vector<T>& vector, std::size_t &heap_size);

template <typename T>
void heap_sort(std::vector<T>& vector) {
  std::size_t heap_size = vector.size();
  make_heap(vector, heap_size);

  while(heap_size > 0) {
    pop_max(vector, heap_size);
  }
}

template <typename T>
void heapify(std::vector<T>& vector, int i, std::size_t &heap_size) {
  int left = get_left(i), right = get_right(i), max = i;

  if(left < heap_size && vector[left] > vector[max]) {
    max = left;
  }

  if(right < heap_size && vector[right] > vector[max]) {
    max = right;
  }

  if(max != i) {
    std::swap(vector[i], vector[max]);
    heapify(vector, max, heap_size);
  }
}

template <typename T>
void make_heap(std::vector<T>& vector, std::size_t &heap_size) {
  heap_size = vector.size();

  for(int i = (heap_size >> 1) - 1; i >= 0; i --) {
    heapify(vector, i, heap_size);
  }
}

template <typename T>
void pop_max(std::vector<T>& vector, std::size_t &heap_size) {
  std::swap(vector[--heap_size], vector[0]);
  heapify(vector, 0, heap_size);
}

#endif
