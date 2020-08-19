#ifndef MY_UTILS
#define MY_UTILS

#include <iostream>
#include <unordered_map>
#include <random>

namespace my_utils {
  template<typename T>
  void printArr(std::vector<T>& arr) {
    int len = arr.size();
    std::cout << "[";
    for (auto it = arr.begin(); it != (arr.end() - 1); it++) {
      std::cout << *it << ", ";
    }
    std::cout << arr[len - 1] << "]" << std::endl;
  }
  
  template<typename Iter>
  void printArr(Iter start, Iter end) {
    while (start != end - 1) {
      std::cout << *start << ", ";
      start++;
    }
    std::cout << *start << std::endl;
  }
  
  template<typename T>
  bool isSorted(std::vector<T>& arr) {
    int len = arr.size();
    if (len == 0) return true;
    for (int i = 1; i < len; i++) {
      if (arr[i] < arr[i - 1])
	return false;
    }
    return true;
  }
  
  template<typename T>
  bool sameElements(std::vector<T> arr1, std::vector<T> arr2) {
    std::unordered_map<T, int> map1, map2;
    for (auto it = arr1.begin(); it != arr1.end(); it++) {
      map1[*it]++;
    }
    for (auto it = arr2.begin(); it != arr2.end(); it++) {
      map2[*it]++;
    }
    return map1 == map2;
  }
  
  std::vector<int> createRandVector(int len, int min, int max) {
    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<> dis(min, max);
    std::vector<int> newArr;
 
    for (int n=0; n<len; ++n)
      newArr.push_back(dis(gen));
    return newArr;
  }
  
}

#endif
