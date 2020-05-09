package com.nishant.algorithms.BitManipulation.MissingNumber;

public class MissingNumber {

    public static int missingNumber(int[] arr) {
        int XOR = 0;

        for(int i = 0; i < arr.length; i ++) {
            XOR ^= i ^ arr[i];
        }

        return XOR ^ arr.length;
    }

}
