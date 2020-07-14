#ifndef ARRAY_QUEUE
#define ARRAY_QUEUE

#include <vector>

template <typename T>
class array_queue {
private:
  std::vector<T> array;

public:
  array_queue()
    : array(std::vector<T>()) {}

  array_queue(std::size_t initial_capacity)
    : array(std::vector<T>()) {
    array.reserve(initial_capacity);
  }

  void push(const T &value) {
    array.push_back(value);
  }

  const T& pop() {
    auto &value = array.front();
    array.erase(array.begin());
    return value;
  }

  const T& front() {
    return array.front();
  }

  const T& back() {
    return array.back();
  }

  
};

#endif
