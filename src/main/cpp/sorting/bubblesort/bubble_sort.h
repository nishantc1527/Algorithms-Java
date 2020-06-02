#pragma once

#include <algorithm>
#include <array>
#include <iterator>

template<typename Iter>
void bubbleSort(const Iter &start, const Iter &end) {
    const int count = std::distance(start, end);
    const Iter startTemp = start;
    Iter it1, it2;

    for (int i = count - 1; i >= 0; i--) {
        it1 = it2 = start;
        it2++;
        for (int j = 0; j < i; j++) {
            if (*it1 > *it2) {
                std::swap(*it1, *it2);
            }

            ++it1;
            ++it2;
        }
    }
};

