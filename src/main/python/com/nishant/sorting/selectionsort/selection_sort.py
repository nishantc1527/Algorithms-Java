import math

def selection_sort(arr):
    for start in range(len(arr)):
        min_num = math.inf
        min_index = -1

        for j in range(start, len(arr), 1):
            if arr[j] < min_num:
                min_num = arr[j]
                min_index = j

        arr[start], arr[min_index] = arr[min_index], arr[start]

if __name__ == "__main__":
    arr = [1, 2, 6, 4, 5]
    print(str(arr))
    selection_sort(arr)
    print(str(arr))
