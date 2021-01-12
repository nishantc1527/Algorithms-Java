from random import randrange

from python.dynamicprogramming.houserobber.house_robber import brute_force, memoized, bottom_up


def rob(nums):  # This function correctly works
    last, now = 0, 0
    for i in nums:
        last, now = now, max(last + i, now)
    return now


def test_brute_force():
    for i in range(100):
        rand_list = [randrange(0, 1000, 1) for _ in range(25)]  # test size has to be small since brute
        # force is extremely slow
        assert rob(rand_list) == brute_force(rand_list)


def test_memoized():
    for i in range(100):
        rand_list = [randrange(0, 1000, 1) for _ in range(25)]
        assert rob(rand_list) == memoized(rand_list)


def test_bottom_up():
    for i in range(100):
        rand_list = [randrange(0, 1000, 1) for _ in range(25)]
        assert rob(rand_list) == bottom_up(rand_list)
