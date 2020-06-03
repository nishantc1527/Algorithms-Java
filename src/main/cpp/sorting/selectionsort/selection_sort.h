#pragma once

#include <algorithm>
#include <vector>
#include <iterator>
#include <limits>

void selection_sort(std::vector<int> &vector) {
    for (int start = 0; start < vector.size(); start++) {
        int min = std::numeric_limits<int>::max(), min_index = -1;

        for (int i = start; i < vector.size(); i++) {
            if (vector[i] < min) {
                min = vector[i];
                min_index = i;
            }
        }

        std::swap(vector[min_index], vector[start]);
    }
}
