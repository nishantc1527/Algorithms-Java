import random

from insertion_sort import insertion_sort


def test_insertion_sort():
    for i in range(500):
        array = []

        for j in range(i):
            array.append(random.randrange(-i, i, 1))

        temp = array.copy()
        temp.sort()
        insertion_sort(array)

        assert array == temp
