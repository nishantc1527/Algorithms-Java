import random

from binarysearchtree import BinarySearchTree


def test_binary_search_tree():
    for i in range(1000):
        random_list = []
        t = BinarySearchTree()

        for j in range(100):
            random_number = random.randrange(-1000, 1000, 1)
            random_list.append(random_number)
            t.insert(random_number)

        for random_number in random_list:
            assert random_number in t

            next_random_number = random.randrange(-1000, 1000, 1)

            if next_random_number not in random_list:
                assert next_random_number not in t
