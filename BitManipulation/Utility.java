package BitManipulation;

import java.util.LinkedList;

public class Utility {

    /**
     * Gets the bit of an integer at a certain index
     *
     * @param num The number holding the bits
     * @param index The index of the bit you want (0-indexed).
     * @return True if the bit is 1, false if bit is 0.
     */

    public static boolean getBit(int num, int index) {
        return ((num >> index) & 1) == 1;
    }

    /**
     * Sets the bit at specific index to 1.
     *
     * @param num The number whose bit you want to set.
     * @param index The index where you want to set it (0-indexed).
     * @return The resulting number after setting the bit.
     */

    public static int setBit(int num, int index) {
        return num | (1 << index);
    }

    /**
     * Resets the bit at an index to 0.
     *
     * @param num The number whose bit you want cleared.
     * @param index The index of the bit you want cleared.
     * @return The new number after clearing the bit.
     */

    public static int clearBit(int num, int index) {
        return num & ~(1 << index);
    }

    /**
     * Prints the bits of a number starting from
     * the most significant bit.
     *
     * @param num The number whose bits you want printed.
     */

    public static void printBits(int num) {
        for(int i = 0; i < 32; i ++) {
            System.out.print((num >> (31 - i)) & 1);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(~5);
    }

}
