import random

from bubble_sort import bubble_sort


def test_bubble_sort():
    for i in range(500):
        array = []

        for j in range(i):
            array.append(random.randrange(-i, i, 1))

        temp = array.copy()
        temp.sort()
        bubble_sort(array)

        assert temp == array
