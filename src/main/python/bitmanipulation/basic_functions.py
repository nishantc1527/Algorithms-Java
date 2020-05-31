def get_bit(num, index):
    return (num >> index) & 1


def set_bit(number, index):
    return number | (1 << index)


def clear_bit(number, index):
    return number & ~(1 << index)


def print_bits(number):
    for i in range(32):
        print(get_bit(number, 31 - i), end='')


if __name__ == "__main__":
    num = 0b0101010
    num = set_bit(num, 0)
    num = clear_bit(num, 1)
    print_bits(num)
