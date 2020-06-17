package dynmanicprogramming.problems.uniquepaths;

public class UniquePaths {

  private static int[][] memo;

  public static int topDown(int m, int n) {
    memo = new int[m][n];
    return topDown(0, 0, m, n);
  }

  private static int topDown(int i, int j, int m, int n) {
    if (i >= m || j >= n) {
      return 0;
    }

    if (i == m - 1 && j == n - 1) {
      return 1;
    }

    if (memo[i][j] > 0) {
      return memo[i][j];
    }

    return memo[i][j] = topDown(i + 1, j, m, n) + topDown(i, j + 1, m, n);
  }

  public static int bottomUp(int m, int n) {
    int[][] dp = new int[m][n];
    dp[m - 1][n - 1] = 1;

    for (int i = dp.length - 1; i >= 0; i--) {
      for (int j = dp[0].length - 1; j >= 0; j--) {
        if (i == m - 1 && j == n - 1) ;
        else if (i == m - 1) {
          dp[i][j] = dp[i][j + 1];
        } else if (j == n - 1) {
          dp[i][j] = dp[i + 1][j];
        } else {
          dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
        }
      }
    }

    return dp[0][0];
  }

  public static void main(String[] args) {
    System.out.println(UniquePaths.topDown(7, 3));
    System.out.println(UniquePaths.bottomUp(7, 3));
  }
}
