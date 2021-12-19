package bitmanipulation.problems.missingnumber;

public class MissingNumber {

  /**
   * Given an array nums containing n distinct numbers in the range [0, n], return the only number
   * in the range that is missing from the array.
   *
   * @param arr Array of numbers.
   * @return The single number that is missing from the array.
   */
  public static int missingNumber(int[] arr) {
    int xor = 0;

    for (int i = 0; i < arr.length; i++) {
      xor ^= i ^ arr[i];
    }

    return xor ^ arr.length;
  }

  public static void main(String[] args) {
    System.out.println(MissingNumber.missingNumber(new int[] {0, 5, 3, 2, 4}));
  }
}
