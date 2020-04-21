package Sorting.QuickSort;

import Sorting.Utility;

public class Tester {

    public static void main(String[] args) {
        int[] arr = Utility.createArray(10, 10);
        Utility.printArray(arr);
        QuickSort.sort(arr);
        Utility.printArray(arr);
    }

}
