#ifndef MIN_HEAP
#define MIN_HEAP

#include <vector>
#include <algorithm>
#include <exception>

template <typename T>
class min_heap {
private:
  std::vector<T> heap;
  std::size_t max_heap_size;

  inline int parent(int i) {
    return (i - 1) / 2;
  }
  inline int left(int i) {
    return 2 * i + 1;
  }
  inline int right(int i) {
    return 2 * i + 2;
  }

public:
  min_heap(int initial_capacity)
    : heap(std::vector<T>()), max_heap_size(initial_capacity) {
    heap.reserve(max_heap_size);
  }

  min_heap()
    : heap(std::vector<T>()), max_heap_size(0) {}

  void build_min_heap(const std::vector<T> &array) {
    max_heap_size = array.size();
    heap = std::vector<T>(array);
    for (int i = (heap.size() - 1) / 2; i >= 0; i--) {
      min_heapify(i);
    }
  }

  void min_heapify(int i) {
    int l = left(i);
    int r = right(i);
    int smallest = i;
    
    if (l < max_heap_size && heap[l] < heap[smallest])
      smallest = l;
    if (r < max_heap_size && heap[r] < heap[smallest])
      smallest = r;
    
    if (smallest != i) {
      std::swap(heap[i], heap[smallest]);
      min_heapify(smallest);
    }
  }

  T minimum() {
    return heap[0];
  }

  std::size_t size() {
    return max_heap_size;
  }

  class heap_underflow_execption : public std::exception {
    virtual const char* what() const throw() {
      return "Heap underflow";
    }
  } heap_underflow_execption;

  T extract_min() {
    if (max_heap_size < 1)
      throw heap_underflow_execption;

    T max = minimum();
    
    heap[0] = heap[max_heap_size - 1];
    max_heap_size--;
    min_heapify(0);

    return max;
  }

  void decrease_key(T key, T decrease_to) {
    std::size_t index = -1;
    for (int i = 0; i < max_heap_size; i++) {
      if (heap[i] == key) {
	index = i;
	break;
      }
    }

    if (index < 0) return;
    else decrease_key(index, decrease_to);
  }

  void insert(T key) {
    max_heap_size++;
    heap[max_heap_size - 1] = key;
    increase_key(max_heap_size - 1, key);
  }

private:
  void decrease_key(std::size_t i, T key) {
    if (key < heap[i])
      return;

    heap[i] = key;
    while (i > 0 && heap[parent(i)] > heap[i]) {
      std::swap(heap[i], heap[parent(i)]);
      i = parent(i);
    }
  }

  
};
#endif
