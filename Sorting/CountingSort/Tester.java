package Sorting.CountingSort;

import Algorithms.Sorting.Utility;

public class Tester {

    public static void main(String[] args) {
        int[] arr = Utility.createArray(10, 10);
        Utility.printArray(arr);
        Sorting.CountingSort.CountingSort.sort(arr);
        Utility.printArray(arr);
    }

}
