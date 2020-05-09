package com.nishant.algorithms.Sorting.SelectionSort;

public class SelectionSort {

    public static void sort(int[] arr) {
        for(int start = 0; start < arr.length - 1; start ++) {
            int min = Integer.MAX_VALUE, minIndex = -1;

            for(int i = start; i < arr.length; i ++) {
                if(arr[i] < min) {
                    min = arr[i];
                    minIndex = i;
                }
            }

            swap(arr, start, minIndex);
        }
    }

    private static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

}
