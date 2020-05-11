Fibonacci Heaps are a min priority queue that supports these operations in these times:

Insert: O(1)
Get Min: O(1)
Extract Min: O(lg n)
Delete: O(lg n)

It seems really good, however there are a lot of hidden constants. It's still a fun data structure, though.

A fibonacci heap is a doubly-linked circular linked list, where each node is a min-heap. Every node has a pointer to it's left and right child, as well
as one of it's children. You can access the children by calling child.left and child.right. Here is an example of a fibonacci heap:

       4  -------  6
       |           |
   9 - 5 - 7   8 - 7 - 9
   |
   10

As you can see, every node has a pointer to one of it's children, who has access to it's siblings and it's child if it has one. Also, every node is
larger than it's parent. The linked list at the top that contains all the smallest numbers is called the root list. The fibonacci heap only contains one
pointer: a pointer to the smallest node.

Inserting is really easy: just add the element to the root list (which is O(1)), and update the minimum if necessary.

Get Min just returns the value of the smallest node.

If you just call both of these operations, the heap just stays a linked list. However, it turns into a structured fibonacci heap when extract min is
called.

With extract min, you first save the value of the minimum node to return, and delete it from the root list (it's important to remember to not remove
it's children in the process) and save a temporary minimum as the node next to it. Then you consolidate the root list by making sure every node has a
different degree (the number of children). This is done by keeping an array of nodes, and every node you come across in the root list you save to the
array using direct addressing to the array. If you do this, you can check for duplicate degrees in O(1) time. Then every time you see a duplicate
degree, you make the larger one a child of the child of the smaller one. This process also gives you the next minimum as you check every node in the
root list, so you can update the minimum at the same time. After consolidation is done, you have a new heap with the correct minimum and every height is
log base phi of n, where phi is the golden ratio 1.61... (it's complicated).

Deleting is really simple. You just change the value of the node to -infinity (which is the smallest value), and then simply call extract min (which
deletes that value).