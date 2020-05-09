package com.nishant.algorithms.Sorting.SelectionSort;

import com.nishant.algorithms.Sorting.Utility;

public class Tester {

    public static void main(String[] args) {
        int[] arr = Utility.createArray(10, 10);
        Utility.printArray(arr);
        SelectionSort.sort(arr);
        Utility.printArray(arr);
    }

}
