import random

from quick_sort import quick_sort


def test_quick_sort():
    for i in range(500):
        array = []

        for j in range(i):
            array.append(random.randrange(-i, i, 1))

        temp = array.copy()
        temp.sort()
        quick_sort(array)

        assert temp == array
