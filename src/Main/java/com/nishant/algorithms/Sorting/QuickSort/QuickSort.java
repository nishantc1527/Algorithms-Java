package com.nishant.algorithms.Sorting.QuickSort;

public class QuickSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    private static void sort(int[] arr, int left, int right) {
        if(left >= right - 1) {
            return;
        }

        int pivotIndex = partition(arr, left, right);
        sort(arr, left, pivotIndex);
        sort(arr, pivotIndex + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotIndex = right - 1, partitionIndex = left;

        for(int i = left; i < right - 1; i ++) {
            if(arr[i] < arr[pivotIndex]) {
                if(partitionIndex == pivotIndex) {
                    pivotIndex = i;
                }

                swap(arr, i, partitionIndex ++);
            }
        }

        swap(arr, pivotIndex, partitionIndex);
        return partitionIndex;
    }

    private static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

}
