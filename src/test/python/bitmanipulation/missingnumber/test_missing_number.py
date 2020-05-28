from src.main.python.bitmanipulation.missingnumber.missing_number import missing_number


def test_missing_number():
    assert missing_number([0, 5, 3, 2, 4]) == 1
