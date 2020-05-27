def merge_sort(arr):
    merge_sort_helper(arr, 0, len(arr))

def merge_sort_helper(arr, left, right):
    if left >= right - 1:
        return

    mid = int((left + right) / 2) 
    merge_sort_helper(arr, left, mid)
    merge_sort_helper(arr, mid, right)

    left_side = arr[left : mid].copy() 
    right_side = arr[mid : right].copy()

    i = 0
    j = 0
    k = left 

    while i < len(left_side) or j < len(right_side):
        if i >= len(left_side):
            arr[k] = right_side[j]
            j += 1
            k += 1
        elif j >= len(right_side):
            arr[k] = left_side[i]
            i += 1
            k += 1
        else:
            if arr[i] < arr[j]:
                arr[k] = left_side[i]
                i += 1
                k += 1
            else:
                arr[k] = right_side[j]
                j += 1
                k += 1
    


if __name__ == "__main__":
   arr = [1, 2, 6, 4, 5]
   print(str(arr))
   merge_sort(arr)
   print(str(arr))
