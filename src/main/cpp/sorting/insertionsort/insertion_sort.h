#pragma once

#include <algorithm>
#include <array>
#include <iterator>

void insertionSort(std::vector<int> &vector) {
    for (int toInsert = 0; toInsert < vector.size(); toInsert++) {
        int curr = vector[toInsert], i;

        for (i = toInsert; i >= 1 && vector[i - 1] > curr; i--) {
            vector[i] = vector[i - 1];
        }

        vector[i] = curr;
    }
}
