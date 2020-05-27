def merge_sort(arr):
    merge_sort_helper(arr, 0, len(arr))

def merge_sort_helper(arr, left, right):
    if left >= right - 1:
        return

    mid = int((left + right) / 2)
    merge_sort_helper(arr, left, mid)
    merge_sort_helper(arr, mid, right)
    merge(arr, arr[left : mid], arr[mid : right], left)


def merge(arr, left, right, start_pos):
   i = 0
   j = 0
   k = start_pos

   while i < len(left) or j < len(right):
       if i >= len(left):
           arr[k] = right[j]
           j += 1
           k += 1
       elif j >= len(right):
           arr[k] = left[i]
           i += 1
           k += 1
       else:
           if left[i] < right[j]:
               arr[k] = left[i]
               i += 1
               k += 1
           else:
               arr[k] = right[j]
               j += 1
               k += 1

if __name__ == "__main__":
    arr = [1, 2, 6, 4, 5]
    print(str(arr))
    merge_sort(arr)
    print(str(arr))
