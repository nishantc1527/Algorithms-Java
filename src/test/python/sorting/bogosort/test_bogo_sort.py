from random import randrange

from src.main.python.sorting.bubblesort.bubble_sort import bubble_sort


def test_bogo_sort():
    for i in range(500):
        array = []

        for j in range(i):
            array.append(randrange(-i, i, 1))

        temp = array.copy()
        temp.sort()
        bubble_sort(array)

        assert temp == array
