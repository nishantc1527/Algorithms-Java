package Algorithms.BitManipulation.SingleNumber;

public class SingleNumber {

    public static int singleNumber(int[] arr) {
        int xor = 0;

        for(int i = 0; i < arr.length; i ++) {
            xor ^= arr[i];
        }

        return xor;
    }

}
