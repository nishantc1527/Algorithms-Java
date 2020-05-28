import random

from src.main.python.sorting.selectionsort.selection_sort import selection_sort


def test_selection_sort():
    for i in range(500):
        array = []

        for j in range(i):
            array.append(random.randrange(-i, i, 1))

        temp = array.copy()
        temp.sort()
        selection_sort(array)

        assert temp == array
