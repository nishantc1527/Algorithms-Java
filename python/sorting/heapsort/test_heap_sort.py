import random

from heap_sort import heap_sort


def test_heap_sort():
    for i in range(500):
        array = []

        for j in range(i):
            array.append(random.randrange(-i, i, 1))

        temp = array.copy()
        temp.sort()
        heap_sort(array)

        assert array == temp
