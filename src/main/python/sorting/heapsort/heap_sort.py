heap_size = 0


def heap_sort(to_sort):
    build_heap(to_sort)
    while heap_size > 0:
        pop_max(to_sort)


def build_heap(to_sort):
    global heap_size
    heap_size = len(to_sort)

    for i in range((heap_size >> 1) - 1, -1, -1):
        heapify(to_sort, i)


def pop_max(to_sort):
    global heap_size
    heap_size -= 1
    to_sort[0], to_sort[heap_size] = to_sort[heap_size], to_sort[0]
    heapify(to_sort, 0)


def heapify(to_sort, i):
    left, right, max_num = get_left(i), get_right(i), i

    if left < heap_size and to_sort[left] > to_sort[max_num]:
        max_num = left

    if right < heap_size and to_sort[right] > to_sort[max_num]:
        max_num = right

    if max_num != i:
        to_sort[i], to_sort[max_num] = to_sort[max_num], to_sort[i]
        heapify(to_sort, max_num)


def get_left(i):
    return (i << 1) + 1


def get_right(i):
    return (i << 1) + 2


def get_parent(i):
    return (i >> 1) if i % 2 == 1 else (i >> 1) - 2


if __name__ == "__main__":
    arr = [1, 2, 3, 6, 4, 5]
    print(str(arr))
    heap_sort(arr)
    print(str(arr))
