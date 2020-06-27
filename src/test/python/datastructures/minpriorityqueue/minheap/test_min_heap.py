from random import randrange

from src.main.python.datastructures.minpriorityqueue.minheap.min_heap import MinHeap


def test_add():
    for i in range(1000):
        values = [randrange(0, 1000) for _ in range(1000)]
        heap = MinHeap()
        heap.add_all(values)
        values.sort()
        k = 0

        for val in heap:
            assert values[k] == val


def test_contains():
    assert True


def test_extract_min():
    assert True


def test_delete():
    assert True


def test_delete_index():
    assert True


def test_is_empty():
    assert True
