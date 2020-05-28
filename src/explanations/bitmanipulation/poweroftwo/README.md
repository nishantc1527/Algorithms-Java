Problem: Write a program to check if a number is a power of two. Use bit manipulation, and in O(1).

Example:

Input(2)
Output(true)

Input(5)
Output(false)

Solution: You use powers of two a lot of times when talking about binary. So there must be a pattern.

2 ^ 0 = 1
2 ^ 1 = 10
2 ^ 2 = 100
2 ^ 3 = 1000

Hopefully you recognized the pattern. All powers of two only has exactly one set bit. So, we can just count the number of bits, and if it is equal to one, we return
true. Since it is guaranteed to have 32 bits, it is technically O(1). And it works out nicely with the set bit, because negative numbers aren't a power of two, and
it counts the set bit as one bit. However, we can get faster, without having to loop over all elements. This solution is less obvious, but faster. Lets look at the
pattern when you subtract one from a power of 2.

(2 ^ 0) - 1 = 0
(2 ^ 1) - 1 = 1
(2 ^ 2) - 1 = 11
(2 ^ 3) - 1 = 111

Every number (except 2 ^ 0) has one less bit than its power of two counterpart, and contains only 1 bits. So we can make a property that is only true for powers of
two: a power of two and that power of two minus one will equal 0. That is, for any number n, n & (n - 1) = 0. This is true because in the orignal power of two, we
see that the end consists of only 0's. The power of two minus one consists of only 1's. So, since 0 and 1 becomes 0, that part stays 0. The very last bit, the only 1
in the binary form of the power of two, gets (anded?) with the empty spot in the minus one counterpart, which is 0. 1 and 0 equals 0. So, the entire thing becomes 0.
There is only one extra step, this fails for negative numbers and 0 because the signed bit makes it pretty complicated.
