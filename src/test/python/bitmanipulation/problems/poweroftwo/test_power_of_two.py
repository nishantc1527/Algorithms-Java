import math

from python.bitmanipulation.poweroftwo.power_of_two import power_of_two


def test_power_of_two():
    for i in range(-100000000, 10000000, 1):
        is_power_of_two = i > 0 and (math.floor(math.log2(i)) == math.ceil(math.log2(i)))

        assert power_of_two(i) == is_power_of_two, "i was " + str(i)
