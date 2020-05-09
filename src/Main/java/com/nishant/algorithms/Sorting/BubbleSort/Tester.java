package com.nishant.algorithms.Sorting.BubbleSort;

import com.nishant.algorithms.Sorting.Utility;

public class Tester {

    public static void main(String[] args) {
        int[] arr = Utility.createArray(10, 10);
        Utility.printArray(arr);
        BubbleSort.sort(arr);
        Utility.printArray(arr);
    }

}
