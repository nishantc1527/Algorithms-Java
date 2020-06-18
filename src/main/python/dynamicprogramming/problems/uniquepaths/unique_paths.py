def brute_force(m, n):
    return brute_force_helper(0, 0, m, n)


def brute_force_helper(i, j, m, n):
    if i >= m or j >= n:
        return 0

    if i == m - 1 and j == n - 1:
        return 1

    return brute_force_helper(i + 1, j, m, n) + brute_force_helper(i, j + 1, m, n)


# -----------------------------------------------------------------------------------------------------------------------------------------------------


memo = []


def memoized(m, n):
    global memo
    memo = [[0 for _ in range(n)] for _ in range(m)]
    return memoized_helper(0, 0, m, n)


def memoized_helper(i, j, m, n):
    if i >= m or j >= n:
        return 0

    if i == m - 1 and j == n - 1:
        return 1

    if memo[i][j] > 0:
        return memo[i][j]

    ans = memoized_helper(i + 1, j, m, n) + memoized_helper(i, j + 1, m, n)
    memo[i][j] = ans
    return ans


if __name__ == "__main__":
    print(brute_force(7, 3))
    print(memoized(7, 3))
