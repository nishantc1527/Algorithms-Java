def bubble_sort(arr):
    did_find = True
    end = len(arr)

    while end >= 0:
        if did_find == False:
            break

        did_find = False

        for i in range(end - 1):
            if arr[i] > arr[i + 1]:
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
                did_find = True

        end = end - 1

if __name__ == "__main__":
    arr = [1, 2, 6, 4, 5]
    print(str(arr))
    bubble_sort(arr)
    print(str(arr))
