package bitmanipulation.problems.poweroftwo;

public class PowerOfTwo {

  /**
   * Returns whether a number is a power of two.
   *
   * @param n The number you are checking.
   * @return True if it is a power of two.
   */
  public static boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }

  public static void main(String[] args) {
    System.out.println(PowerOfTwo.isPowerOfTwo(2));
    System.out.println(PowerOfTwo.isPowerOfTwo(5));
  }
}
