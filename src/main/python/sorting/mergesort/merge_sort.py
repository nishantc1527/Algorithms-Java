def merge_sort(to_sort):
    merge_sort_helper(to_sort, 0, len(to_sort))


def merge_sort_helper(to_sort, left, right):
    if left >= right - 1:
        return

    mid = int((left + right) / 2)
    merge_sort_helper(to_sort, left, mid)
    merge_sort_helper(to_sort, mid, right)
    merge(to_sort, to_sort[left: mid], to_sort[mid: right], left)


def merge(to_sort, left, right, start_pos):
    i = 0
    j = 0
    k = start_pos

    while i < len(left) or j < len(right):
        if i >= len(left):
            to_sort[k] = right[j]
            j += 1
            k += 1
        elif j >= len(right):
            to_sort[k] = left[i]
            i += 1
            k += 1
        else:
            if left[i] < right[j]:
                to_sort[k] = left[i]
                i += 1
                k += 1
            else:
                to_sort[k] = right[j]
                j += 1
                k += 1


if __name__ == "__main__":
    arr = [1, 2, 6, 4, 5]
    print(str(arr))
    merge_sort(arr)
    print(str(arr))
