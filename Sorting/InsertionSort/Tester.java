package Algorithms.Sorting.InsertionSort;

import Algorithms.Sorting.SelectionSort.SelectionSort;
import Algorithms.Sorting.Utility;

public class Tester {

    public static void main(String[] args) {
        int[] arr = Utility.createArray(10, 10);
        Utility.printArray(arr);
        InsertionSort.sort(arr);
        Utility.printArray(arr);
    }

}
