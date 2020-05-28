import random
import string

from src.main.python.datastructures.trees.trie.trie import Trie


def generate_random_string():
    return ''.join([random.choice(string.ascii_lowercase) for _ in range(32)])


def test_trie():
    for i in range(1000):
        random_string_list = []
        t = Trie()

        for j in range(100):
            random_string = generate_random_string()
            random_string_list.append(random_string)
            t += random_string

        for random_string in random_string_list:
            assert random_string in t

            next_random_string = generate_random_string()

            if next_random_string not in random_string_list:
                assert next_random_string not in t
