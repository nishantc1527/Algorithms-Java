package com.nishant.algorithms.Sorting.InsertionSort;

import java.util.Arrays;

public class InsertionSort {

    public static void sort(int[] arr) {
        for(int toInsert = 0; toInsert < arr.length; toInsert ++) {
            int curr = arr[toInsert], i;

            for(i = toInsert; i >= 1 && arr[i - 1] > curr; i --) {
                arr[i] = arr[i - 1];
            }

            arr[i] = curr;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 5, 3, 2, 4, 5, 2};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
