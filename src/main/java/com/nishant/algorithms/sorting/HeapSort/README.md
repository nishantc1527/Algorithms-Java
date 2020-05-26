Heap Sort can sort an array in O(N lg N). It is, however, slower than sorting algorithms like quick sort, but still used to some extent. The sorting algorithms uses
a data structure called a binary heap, either min heap or max heap. A binary heap is structured with a root node pointing to two nodes, and those two nodes each
point to two nodes of their own, until the data runs out and nodes only point to only one node and eventually 0 nodes. In a min heap, all roots are smaller than ALL
of it's children, including children's children and their children and so on. A max heap is the opposite, the root is larger than all it's children. Even though
heap sort uses another kind of data structure, it can be done in place (I'll talk about that afterwards). Heap sort uses 2 main algorithms: build heap and heapify.
Build heap transforms the given array into a heap, and heapify takes an index too and knowing that the left and right sub-heap is valid, it makes sure the node at
that index is valid too. You can either use max or min heap, but max heap is easier to implement. First of all, heapify does something called sift down, where it
compares the left and right sub-heap, and if one of it's children is larger than it, we swap them, making that part valid. However, that swapped node might not be
valid, so we recursively called heapify on that. What build heap does is just call heapify on all nodes, and the entire heap becomes valid. The main heap sort
method just calls build heap, then one by one extracts the maximum, put's it at the end, then swaps that node with a random node in the heap with 0 children, then
calls heapify on that. After the heap is empty, the array is sorted.

To sort in place without creating a heap object, we can store the heap in the array. In array form, the first element is the root, and it's two children are the
next two. The left child's two children are the next two, and so on. For example, [1, 5, 2, 3, 5, 3, 6] (it's not a valid heap, just an example).

                                     1
                             /             \
                  5                                2
            /         \                        /       \
       3                   5              3                 6

We can just convert the given array to a heap. Given a node, we can easily get the left, right and parent. Getting the left node would be i * 2, getting the right
would be (i * 2) + 1. Getting the parent would be i / 2. Using bit manipulation, we can multiply numbers really fast by using shift left and right operators.