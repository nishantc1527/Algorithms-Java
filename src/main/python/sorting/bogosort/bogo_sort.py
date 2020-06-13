from random import randrange


def bogo_sort(to_sort):
    while not is_sorted(to_sort):
        shuffle(to_sort)


def shuffle(to_sort):
    for i in range(len(to_sort)):
        rand_index = randrange(0, len(to_sort))
        to_sort[i], to_sort[rand_index] = to_sort[rand_index], to_sort[i]


def is_sorted(to_sort):
    for i in range(1, len(to_sort)):
        if to_sort[i] < to_sort[i - 1]:
            return False

    return True
