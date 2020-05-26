Merge Sort sorts an array in a time of(N log N), making it one of the better and more used sorting algorithms. There is one downside though, which I will explain
later. Merge Sort works on an algorithms called the "merging algorithm." The algorithm is: given two sorted arrays, the first sized n and the second sized m, you
can merge the two into one sorted array in O(N + M) time. That can be done like this: keep one pointer at the start of the first array, and another at the start of
the other. Also, keep a resulting array, and keep a pointer at the start of this array. I will call the pointer for the first array i, the pointer for the second
array j, and the pointer for the resulting array k. Initially, i, j, and k is 0. Start by comparing the elements at i and j. If i is smaller, replace the element
at k with the element at i, while incrementing i and k. If j was smaller, replace the element at k with j, incrementing j and k. You repeat this until either i or
j is out of bounds, which is when you just add all the remaining elements from the other array. What merge sort does is sorts the left half and the right half of the
array, then merges them together to get a sorted array. The sorting algorithm that it so happens to choose: merge sort.

The problem with merge sort has to do with the merging algorithm. The thing is, we have to create two whole new arrays and copy over the elements from the original
array into these array to merge. This takes lots of more memory, and more importantly, takes lots more time. Still, it is a widely used sorting algorithm.