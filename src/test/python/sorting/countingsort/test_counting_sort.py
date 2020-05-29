import random

from src.main.python.sorting.countingsort.counting_sort import counting_sort


def test_counting_sort():
    for i in range(500):
        array = []

        for j in range(i):
            array.append(random.randrange(-i, i, 1))

        temp = array.copy()
        temp.sort()
        counting_sort(array)

        assert array == temp
