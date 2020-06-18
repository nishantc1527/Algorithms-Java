def power_of_two(num):
    return num > 0 and (num - 1) & num == 0


if __name__ == "__main__":
    print(power_of_two(2))
    print(power_of_two(5))
