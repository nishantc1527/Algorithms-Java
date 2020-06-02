//
// Created by nisha on 6/2/2020.
//

#include "gtest/gtest.h"
#include "../../../../main/cpp/sorting/quicksort/quick_sort.h"

TEST(Sorting, QuickSortTest) {
    for(int i = 0; i < 1000; i ++) {
        std::vector<int> arr;

        for(int j = 0; j < 500; j ++) {
            arr.push_back(rand() % 1000);
        }

        std::vector<int> temp = arr;
        std::sort(temp.begin(), temp.end());
        quickSort(arr.begin(), arr.end());
        ASSERT_EQ(temp, arr);
    }
}