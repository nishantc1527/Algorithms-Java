The standard min priority queue, a Min Heap. Min heap's are the go to priority queue because of it's overall time of O(lg n). Inserting takes O(lg n), extract
min takes O(lg n), and decrease value takes O(lg n), and of course getting the minimum takes O(1). A min heap takes the form of a binary tree, where each node
is smaller than both it's children. That way, getting the minimum is just returning the root node. Even though it is structured as a binary tree, it is
resembled as an array. The root is the first index, it's two children are the next two, the next two children are the next two, and so on. For example, this
array: [1, 2, 3, 4, 5, 6, 7] will be this heap:

         1
        / \
       2   3
      / \ / \
     4  5 6  7

If the array indices are 0-indexed (which they are), given an index i, the left child is (i * 2) + 1, the right child is (i * 2) + 2, and the parent is
(i / 2) - 1 if i is even, else (i / 2).

The inserting procedure is this: add the element to the end of the array, and while the value of it is greater than the parent (which is an invalid min heap),
swap it with is parent. Then continue with the parent as it's new index. This is called bubbling up.

The extract min procedure is this: swap the first element (the root, and the smallest element) with the last element, and delete the last element (deleting
the minimum). Then while the value is larger than either of it's children (an invalid min heap), swap it with the larger child and continue the procedure with
that child. This is called bubbling down.

The decrease value procedure is this: changed the value of the element, then bubble up with that element.