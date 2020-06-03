//
// Created by nisha on 6/2/2020.
//

#include "gtest/gtest.h"
#include "../../../../main/cpp/sorting/selectionsort/selection_sort.h"

TEST(Sorting, SelectionSortTest) {
    for(int i = 0; i < 1000; i ++) {
        std::vector<int> arr;

        for(int j = 0; j < 500; j ++) {
            arr.push_back(rand() % 1000);
        }

        std::vector<int> temp = arr;
        std::sort(temp.begin(), temp.end());
        selection_sort(arr);
        ASSERT_EQ(temp, arr);
    }
}