package com.nishant.algorithms.Sorting.InsertionSort;

import com.nishant.algorithms.Sorting.Utility;

public class Tester {

    public static void main(String[] args) {
        int[] arr = Utility.createArray(10, 10);
        Utility.printArray(arr);
        InsertionSort.sort(arr);
        Utility.printArray(arr);
    }

}
