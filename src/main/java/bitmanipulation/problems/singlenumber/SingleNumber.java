package bitmanipulation.problems.singlenumber;

public class SingleNumber {

  /**
   * Given a non-empty array of integers nums, every element appears twice except for one. Find that
   * single one. You must implement a solution in linear runtime complexity and use only constant
   * extra space.
   *
   * @param arr Array of integers.
   * @return The element that only appears once.
   */
  public static int singleNumber(int[] arr) {
    int xor = 0;

    for (int value : arr) {
      xor ^= value;
    }

    return xor;
  }

  public static void main(String[] args) {
    System.out.println(SingleNumber.singleNumber(new int[] {1, 2, 2, 1, 5}));
  }
}
