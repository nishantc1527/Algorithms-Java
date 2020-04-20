package Algorithms.Sorting.CountingSort;

import Algorithms.Sorting.InsertionSort.InsertionSort;
import Algorithms.Sorting.Utility;

public class Tester {

    public static void main(String[] args) {
        int[] arr = Utility.createArrayWithNegative(10, 10);
        Utility.printArray(arr);
        CountingSort.sort(arr);
        Utility.printArray(arr);
    }

}
