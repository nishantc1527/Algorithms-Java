from math import factorial

from python.dynamicprogramming.uniquepaths.unique_paths import brute_force, memoized


def math_sol(m, n):  # the math solution; it is guaranteed to work
    return factorial((m - 1) + (n - 1)) / (factorial(m - 1) * factorial(n - 1))


def test_brute_force():
    for i in range(1, 15, 1):
        for j in range(1, 10, 1):
            assert math_sol(i, j) == brute_force(i, j)


def test_memoized():
    for i in range(1, 20, 1):
        for j in range(1, 20, 1):
            assert math_sol(i, j) == memoized(i, j)
