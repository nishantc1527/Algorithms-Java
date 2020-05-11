Insertion Sort is a quadratic sorting algorithm, meaning it sorts in O(N ^ 2). The algorithm works as follows: It iterates through the loop normally, and for each number, it
inserts it into the correct location based on what it has so far. You can think of it as an increasing window; the window only contains the first element, then the first two
while inserting the second element in the correct position, then the first three while inserting the third in it's correct position, etc. The slowness of this algorithm comes
the inserting process. Since there is no good way to insert an element into a position in an array, you need to shift the elements in the array to the right leaving an open spot
for inserting the element.