from random import randrange

from min_heap import MinHeap


def test_make_heap():
    for _ in range(100):
        assert MinHeap([randrange(0, 1000) for _ in range(1000)]).is_valid()


def test_add():
    for _ in range(100):
        heap = MinHeap()
        check = set()

        for _ in range(100):
            rand = randrange(0, 1000)
            heap.add(rand)
            check.add(rand)

        for num in check:
            assert heap.contains(num)
            rand = randrange(0, 1000)

            if rand not in check:
                assert not heap.contains(rand)


def test_random_additions():
    for i in range(100):
        heap = MinHeap()

        for j in range(100):
            heap.add(j)
            assert heap.is_valid()


def test_extract_min():
    for _ in range(100):
        heap = MinHeap()
        values = [randrange(0, 1000) for _ in range(100)]
        heap.add_all(values)
        values.sort()
        k = 0

        for val in values:
            assert values[k] == val
            k += 1


def test_is_empty():
    heap = MinHeap()
    assert heap.is_empty()
    heap.add_all([randrange(0, 1000) for _ in range(0, randrange(1, 100))])
