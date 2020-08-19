#include <iostream>
#include <vector>

#include "selection_sort.h"

int main() {
  std::vector<int> vector = {1, 2, 3, 6, 4, 5};
  std::vector<int> temp = vector;
  std::sort(temp.begin(), temp.end());
  selection_sort(vector);
  std::cout << std::boolalpha << (vector == temp);
}
