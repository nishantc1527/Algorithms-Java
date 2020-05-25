#include <iostream>
#include <random>
#include <ctime>
#include <vector>

#include "insertion_sort.h"
#include "my_utils.h"

void test() {
  std::vector<int> arr = my_utils::createRandArray(10, 1, 20);
  auto it1 = arr.begin();
  auto it2 = it1;
  int i = 0;
  for (; it1 != arr.end(); ++it1, ++i) {
    std::cout << *it1 << ", ";
    if (i > arr.size() / 2)
      *it1 = arr.size() - i;
  }

  std::cout << std::endl;

  std::cout << *it2 << std::endl;
  for (; it2 != arr.end(); ++it2) {
    std::cout << *it2 << ", ";
  }
  
}

int main()
{
  const int len = 5;
  std::vector<int> arr = my_utils::createRandArray(len, 1, 1000);
  std::cout << "\n\nUnsorted Array: " << std::endl;
  my_utils::printArr(arr);

  insertionSort(arr.begin(), arr.end());
  
  std::cout << "\nSorted Array: " << std::endl;
  my_utils::printArr(arr);

  bool sorted = my_utils::isSorted(arr);
  if (!sorted) {
    std::cout << "\nThe array is not sorted!!\n\n" << std::endl;
  }
  else {
    std::cout << "\nThe array is sorted!!\n\n" << std::endl;
  }

  return 0;
}
