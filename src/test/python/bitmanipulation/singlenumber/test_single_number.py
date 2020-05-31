from random import randrange

from src.main.python.bitmanipulation.singlenumber.single_number import single_number


def test_single_number():
    for i in range(1, 5000, 1):
        random_number = randrange(0, i, 1)
        rand_list = []

        for j in range(i):
            if j == random_number:
                rand_list.append(j)
            else:
                rand_list.append(j)
                rand_list.append(j)

        assert random_number == single_number(rand_list)

