package com.nishant.algorithms.Sorting.BubbleSort;

public class BubbleSort {

    public static void sort(int[] arr) {
        boolean didFind = true;

        for(int end = arr.length; end > 0 && didFind; end --) {
            didFind = false;

            for(int i = 0; i < end - 1; i ++) {
                if(arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    didFind = true;
                }
            }
        }
    }

    private static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

}
