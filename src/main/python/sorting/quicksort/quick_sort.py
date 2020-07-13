def quick_sort(to_sort):
    quick_sort_helper(to_sort, 0, len(to_sort))


def quick_sort_helper(to_sort, left, right):
    if left >= right - 1:
        return

    partition_index = partition(to_sort, left, right)
    quick_sort_helper(to_sort, left, partition_index)
    quick_sort_helper(to_sort, partition_index + 1, right)


def partition(to_sort, left, right):
    pivot = to_sort[right - 1]
    partition_index = left

    for i in range(left, right - 1, 1):
        if to_sort[i] < pivot:
            to_sort[partition_index], to_sort[i] = to_sort[i], to_sort[partition_index]
            partition_index += 1

    to_sort[right - 1], to_sort[partition_index] = to_sort[partition_index], to_sort[right - 1]
    return partition_index


if __name__ == "__main__":
    arr = [-2, -1, 0, 0]
    print(str(arr))
    quick_sort(arr)
    print(str(arr))
