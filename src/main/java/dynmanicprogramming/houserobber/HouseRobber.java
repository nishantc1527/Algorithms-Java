package dynmanicprogramming.houserobber;

import java.util.Arrays;

public class HouseRobber {

  private static int[] memo;

  public static int bruteForce(int[] arr) {
    return bruteForce(arr, 0);
  }

  private static int bruteForce(int[] arr, int i) {
    if (i >= arr.length) {
      return 0;
    }

    return Math.max(arr[i] + bruteForce(arr, i + 2), bruteForce(arr, i + 1));
  }

  public static int memoized(int[] arr) {
    memo = new int[arr.length];
    Arrays.fill(memo, -1);
    return memoized(arr, 0);
  }

  public static int memoized(int[] arr, int i) {
    if (i >= arr.length) {
      return 0;
    }

    if (memo[i] >= 0) {
      return memo[i];
    }

    return memo[i] = Math.max(arr[i] + bruteForce(arr, i + 2), bruteForce(arr, i + 1));
  }

  public static int bottomUp(int[] arr) {
    if (arr.length == 0) {
      return 0;
    } else if (arr.length == 1) {
      return arr[0];
    } else if (arr.length == 2) {
      return Math.max(arr[0], arr[1]);
    }

    int[] dp = new int[arr.length];
    dp[0] = arr[0];
    dp[1] = Math.max(arr[0], arr[1]);

    for (int i = 2; i < dp.length; i++) {
      dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
    }

    return dp[dp.length - 1];
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 3, 1, 4, 1, 3, 4, 3, 2, 1, 3, 4, 3, 2, 1}; // The answer is 21
    System.out.println(HouseRobber.memoized(arr));
  }
}
