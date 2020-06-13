package sorting.bogosort;

public class BogoSort {

    public static void sort(int[] arr) {
        while (!isSorted(arr)) {
            shuffle(arr);
        }
    }

    private static void shuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            swap(arr, i, (int) (Math.random() * arr.length));
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean isSorted(int[] arr) {
        int i = arr.length;

        while (i-- > 1) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
