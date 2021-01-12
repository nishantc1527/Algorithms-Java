def bubble_sort(to_sort):
    did_find = True
    end = len(to_sort)

    while end >= 0:
        if not did_find:
            break

        did_find = False

        for i in range(end - 1):
            if to_sort[i] > to_sort[i + 1]:
                to_sort[i], to_sort[i + 1] = to_sort[i + 1], to_sort[i]
                did_find = True

        end = end - 1


if __name__ == "__main__":
    arr = [1, 2, 6, 4, 5]
    print(str(arr))
    bubble_sort(arr)
    print(str(arr))
