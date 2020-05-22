#include <iostream>

#include "bubblesort/bubble_sort.h"

int main()
{
  const int len = 5;
  int arr[len] = {-1, 3, 2, 5, -3};
  std::cout << "Unsorted Array: " << std::endl;
  for (int i = 0; i < len; i++) {
    std::cout << arr[i] << ' ';
  }
  std::cout << std::endl;

  BubbleSort(arr, len);
  
  std::cout << "Sorted Array: " << std::endl;
  for (int i = 0; i < len; i++) {
    std::cout << arr[i] << ' ';
  }
  std::cout << std::endl;

  return 0;
}
