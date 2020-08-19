def brute_force(values):
    return brute_force_helper(values, 0)


def brute_force_helper(values, i):
    return 0 if i >= len(values) else max(values[i] + brute_force_helper(values, i + 2),
                                          brute_force_helper(values, i + 1))


# ---------------------------------------------------------------------------------------------------------------------------------------------


memo = []


def memoized(values):
    global memo
    memo = [-1] * len(values)
    return memoized_helper(values, 0)


def memoized_helper(values, i):
    if i >= len(values):
        return 0

    if memo[i] >= 0:
        return memo[i]

    ans = max(values[i] + memoized_helper(values, i + 2), memoized_helper(values, i + 1))
    memo[i] = ans
    return ans


# -----------------------------------------------------------------------------------------------------------------------------------------------

def bottom_up(values):
    if len(values) == 0:
        return 0
    elif len(values) == 1:
        return values[0]
    elif len(values) == 2:
        return max(values[0], values[1])

    dp = [0] * len(values)
    dp[0] = values[0]
    dp[1] = max(values[0], values[1])

    for i in range(2, len(dp), 1):
        dp[i] = max(dp[i - 2] + values[i], dp[i - 1])

    return dp[-1]


if __name__ == "__main__":
    houses = [1, 2, 3, 1]
    print(houses)
    print(brute_force(houses))

    houses = [1, 2, 3, 1]
    print(houses)
    print(memoized(houses))

    houses = [1, 2, 3, 1]
    print(houses)
    print(bottom_up(houses))
