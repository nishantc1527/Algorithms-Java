A regular binary search tree. It can support these operations:

Insert (O(lg N)): Just like you are searching for a node, move in the direction of the node you are inserting. Once you find a leaf, insert the node to the left or
right, depending on the value.

Delete (O(lg N)): First search for the value in the tree. There can be one of three cases: the node is a leaf, it only has 1 child, and it has 2 children. If it is
a leaf, you make the parents child point to null instead of that child. If it has 1 child, you make the parent point to the left or right subtree of that node,
depending if it's child is on it's left or right. If it has 2 children, you search for the largest value in the left subtree, and replace the value of the current
node to that node. Then, since it has only 1 child, you can easily delete that child.