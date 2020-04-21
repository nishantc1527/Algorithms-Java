package Sorting.InsertionSort;

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

}
