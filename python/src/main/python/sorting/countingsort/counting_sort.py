from math import inf


def counting_sort(to_sort):
    if len(to_sort) == 0:
        return

    min_num, max_num = inf, -inf

    for i in range(len(to_sort)):
        min_num = min(to_sort[i], min_num)
        max_num = max(to_sort[i], max_num)

    count = [0] * (max_num - min_num + 1)

    for i in range(len(to_sort)):
        count[to_sort[i] - min_num] += 1

    k = 0

    for i in range(len(count)):
        while count[i] > 0:
            to_sort[k] = i + min_num
            k += 1
            count[i] -= 1


if __name__ == "__main__":
    arr = [1, 2, 3, 6, 4, 5]
    print(str(arr))
    counting_sort(arr)
    print(str(arr))
