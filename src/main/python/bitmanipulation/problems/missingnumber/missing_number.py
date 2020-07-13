def missing_number(arr):
    xor = 0

    for i, index in enumerate(arr):
        xor ^= index ^ i

    return len(arr) ^ xor


if __name__ == "__main__":
    print(missing_number([0, 5, 3, 2, 4]))
