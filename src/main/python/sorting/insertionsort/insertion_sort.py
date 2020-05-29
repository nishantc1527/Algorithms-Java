def insertion_sort(to_sort):
    for end in range(1, len(to_sort), 1):
        next_num = to_sort[end]
        i = end

        while i >= 1 and to_sort[i - 1] > next_num:
            to_sort[i] = to_sort[i - 1]
            i = i - 1

        to_sort[i] = next_num


if __name__ == "__main__":
    arr = [1, 2, 3, 6, 4, 5]
    print(str(arr))
    insertion_sort(arr)
    print(str(arr))
