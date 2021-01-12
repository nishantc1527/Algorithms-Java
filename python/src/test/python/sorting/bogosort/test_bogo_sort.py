from random import randrange

from python.src.main.python.sorting import bubble_sort


def test_bogo_sort():
    for i in range(500):
        array = []

        for j in range(i):
            array.append(randrange(-i, i, 1))

        temp = array.copy()
        temp.sort()
        bubble_sort(array)

        assert temp == array
