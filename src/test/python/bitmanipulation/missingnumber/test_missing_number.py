import random
from src.main.python.bitmanipulation.missingnumber.missing_number import missing_number


def test_missing_number():
    for i in range(2, 10000, 1):
        rand = random.randrange(0, i + 1, 1)
        new_list = []

        for j in range(0, i + 1, 1):
            if rand == j:
                continue

            new_list.append(j)

        assert missing_number(new_list) == rand
