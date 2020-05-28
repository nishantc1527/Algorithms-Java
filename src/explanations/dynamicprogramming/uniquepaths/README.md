Detailed Video Explanation: https://www.youtube.com/watch?v=uVlT49GXDGo

Problem: Given an m by n grid, you start at the top left and you want to reach the bottom right in as many ways as possible by moving either down
or right.

Example:

Input(3, 3)
Output(6)

Reason: You can reach the bottom right in 6 ways:

Right, Right, Down, Down
Right, Down, Right, Down
Right, Down, Down, Right
Down, Right, Right, Down
Down, Right, Down, Right
Down, Down, Right, Right

Solution: The top down approach is where we can keep track of the index, as in the house robber problem. We start at (0, 0) and end at
(m - 1, n - 1). If we go out of bounds, we return 0, and if we reach the end, we return 1. If both of those aren't true, then we return the number
of paths to the right + the number of paths going down, using recursion. However, this causes a lot of repeating cases. For example, going right
and down and going down and right will get you to the same place, doing almost the entire problem again. So, we add memoization, where we store the
answer we got in memo[i][j] (where i and j are the indices in the method parameters). Then we can check if we got the answer before using that memo
array.

To figure out the bottom up approach, we need to know the smallest sub problem. If we start at the bottom right, where we are supposed to end, then
the number of paths would just be one. Then we can go backwards through the grid, where each square is the sum of the right square and down square.
Finally, at the end, we return the answer we got at square (0, 0), since that is where we started.