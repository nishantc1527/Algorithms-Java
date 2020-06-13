import random

from python.sorting.mergesort.merge_sort import merge_sort


def test_merge_sort():
    for i in range(500):
        array = []

        for j in range(i):
            array.append(random.randrange(-i, i, 1))

        temp = array.copy()
        temp.sort()
        merge_sort(array)

        assert temp == array
