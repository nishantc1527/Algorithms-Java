package Sorting.InsertionSort;

import Sorting.Utility;

public class Tester {

    public static void main(String[] args) {
        int[] arr = Utility.createArray(10, 10);
        Utility.printArray(arr);
        Sorting.InsertionSort.InsertionSort.sort(arr);
        Utility.printArray(arr);
    }

}
