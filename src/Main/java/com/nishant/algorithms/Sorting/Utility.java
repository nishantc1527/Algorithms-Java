package com.nishant.algorithms.Sorting;

public class Utility {

    public static void printArray(int[] arr) {
        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

    public static int[] createArray(int size, int max) {
        int[] arr = new int[size];

        for(int i = 0; i < size; i ++) {
            arr[i] = Math.random() < 0.5 ? (int) (Math.random() * max) : -(int) (Math.random() * max);
        }

        return arr;
    }

}
