package com.nishant.algorithms.Sorting.HeapSort;

import com.nishant.algorithms.Sorting.Utility;

public class Tester {

    public static void main(String[] args) {
        int[] arr = {-6, 4, -7, 1, 9, 0, 0, -7, 3, 3};
        Utility.printArray(arr);
        HeapSort.sort(arr);
        Utility.printArray(arr);
    }

}
