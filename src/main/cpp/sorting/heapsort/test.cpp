//
// Created by nisha on 6/3/2020.
//

#include <vector>
#include <algorithm>
#include <iostream>
#include "heap_sort.hpp"

int main() {
  std::vector<int> vector = {1, 2, 3, 6, 4, 5};
  std::vector<int> temp = vector;
  std::sort(temp.begin(), temp.end());
  heap_sort(vector);
  std::cout << std::boolalpha << (vector == temp);
}
