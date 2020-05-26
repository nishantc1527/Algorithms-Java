#include <iostream>
#include <random>
#include <ctime>
#include <array>

#include "bubble_sort.h"
#include "selection_sort.h"
#include "my_utils.h"

int main()
{
  const int len = 100;
  std::array<int, len> arr = my_utils::createRandArray<len>(1, 1000);
  std::cout << "\n\nUnsorted Array: " << std::endl;
  my_utils::printArr<int, len>(arr);

  // bubbleSort(arr);
  selectionSort(arr);
  
  std::cout << "Sorted Array: " << std::endl;
  my_utils::printArr<int, len>(arr);

  bool sorted = my_utils::isSorted<int, len>(arr);
  if (!sorted) {
    std::cout << "The array is not sorted!!\n\n" << std::endl;
  }
  else {
    std::cout << "The array is sorted!!\n\n" << std::endl;
  }

  return 0;
}
