#include <iostream>
#include <random>
#include <ctime>
#include <vector>
#include <chrono>

#include "quick_sort.h"
#include "merge_sort.h"
#include "bubble_sort.h"
#include "my_utils.h"

int main()
{
  const int len = 200;
  std::vector<int> arr = my_utils::createRandArray(len, 1, 2000);
  std::vector<int> saved = arr;
  std::cout << "\n\nUnsorted Array: " << std::endl;
  my_utils::printArr(arr);
  std::chrono::steady_clock::time_point begin = std::chrono::steady_clock::now();
  
  mergeSort(arr.begin(), arr.end());

  std::chrono::steady_clock::time_point end = std::chrono::steady_clock::now();
  auto duration = std::chrono::duration_cast<std::chrono::microseconds>(end - begin).count();
  
  std::cout << "\nSorted Array: " << std::endl;
  my_utils::printArr(arr);

  std::cout << std::endl;
  
  bool sorted = my_utils::isSorted(arr);
  bool same = my_utils::sameElements(saved, arr);
  if (same && sorted) {
    std::cout << "The sorting is correct" << std::endl;
  }
  else {
    if (!sorted) {
      std::cout << "The sorting is incorrect" << std::endl;
    }
    else {
      std::cout << "The elements are not the same" << std::endl;
    }
  }

  std::cout << "Time taken: " << duration << " millis" << std::endl;

  std::cout << std::endl << std::endl;
  
  return 0;
}
