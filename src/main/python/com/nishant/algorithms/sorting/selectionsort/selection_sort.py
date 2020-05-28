import math


def selection_sort(to_sort):
    for start in range(len(to_sort)):
        min_num = math.inf
        min_index = -1

        for j in range(start, len(to_sort), 1):
            if to_sort[j] < min_num:
                min_num = to_sort[j]
                min_index = j

        to_sort[start], to_sort[min_index] = to_sort[min_index], to_sort[start]


if __name__ == "__main__":
    arr = [1, 2, 6, 4, 5]
    print(str(arr))
    selection_sort(arr)
    print(str(arr))
