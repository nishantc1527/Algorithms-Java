def single_number(array):
    xor = 0

    for i in array:
        xor ^= i

    return xor


if __name__ == "__main__":
    print(single_number([1, 1, 2, 6, 4, 2, 5, 6, 4]))
