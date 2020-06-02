#include <iostream>
#include <vector>

#include "merge_sort.h"

int main() {
    std::vector<int> vector = {1, 2, 3, 6, 4, 5};
    std::vector<int> temp = vector;
    std::sort(temp.begin(), temp.end());
    mergeSort(vector.begin(), vector.end());
    std::cout << std::boolalpha << (vector == temp);
}
