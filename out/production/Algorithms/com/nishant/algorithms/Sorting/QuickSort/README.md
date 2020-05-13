Quick Sort can sort an array in O(N lg N) on average. I say on average because the worst case running time of quick sort i O(N ^ 2). However, it's extremely unlikely
that it gets a running time of O(N ^ 2). It usually always gets, or close to gets, O(N lg N). That, and the fact that it doesn't have to create whole new arrays like
merge sort, makes it one of the more used sorting algorithms when sorting any type, including objects (if you only want to sort numbers, there are much better ways).
For example, Java's Arrays.sort() uses quick sort. Quick sort works on the fact that if you have a single element somewhere in the array, and everything to the left
of it is smaller than it and everything to the right of it is larger than it, all you need to do is sort the two sides and you get a sorted array. There is, in fact,
an algorithm that can get this structure in the array, called the partitioning algorithm. It chooses a pivot, and can move everything smaller than it to the left of
it and everything larger than it to the right of it in O(N). The partitioning algorithm works as follows: it chooses a pivot (I'll explain the choosing of the pivot
later) and keeps track of two pointers, I'll call i and j. It traverses the array using i, and when it finds an element smaller than the pivot, it swaps the elements
at i and j, incrementing j. Once you are done traversing the array, just swap the pivot with the location of j, and you are done. Once it's done partitioning the
array, it sorts the left and right side recursively using quick sort.

If at every time the sorting method is called (which is called multiple times per sort because it uses recursion) you choose the pivot as the largest element, then
the partitioning algorithm will move it to the end and you only sorted one element. Since the partitioning algorithm takes O(N) and you remove only one element every
time resulting in N calls, this will get you a running time of O(N ^ 2). However, it is very unlikely that you choose the largest element every single time. If you
choose the median every time, the amount of calls you make is lg N, resulting in a running time of O(N lg N). Choosing the exact median every time is unlikely too.
So, the running time averages out at just over O(N lg N). To choose the pivot, we can choose a random element, since it doesn't matter what pivot you choose. I just
chose the last element in the array.