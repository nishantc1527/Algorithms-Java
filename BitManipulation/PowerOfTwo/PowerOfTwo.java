package BitManipulation.PowerOfTwo;

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

}
