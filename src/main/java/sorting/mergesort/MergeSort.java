package sorting.mergesort;

import java.util.Arrays;

public class MergeSort {

  public static void sort(int[] arr) {
    sort(arr, 0, arr.length);
  }

  private static void sort(int[] arr, int left, int right) {
    if (left >= right - 1) {
      return;
    }

    int mid = (left + right) / 2;
    sort(arr, left, mid);
    sort(arr, mid, right);

    int[] leftSide = new int[mid - left];
    int[] rightSide = new int[right - mid];

    System.arraycopy(arr, left, leftSide, 0, leftSide.length);
    System.arraycopy(arr, mid, rightSide, 0, rightSide.length);

    merge(arr, leftSide, rightSide, left);
  }

  private static void merge(int[] arr, int[] left, int[] right, int startPos) {
    int k = startPos;

    for (int i = 0, j = 0; i < left.length || j < right.length; ) {
      if (i >= left.length) {
        arr[k++] = right[j++];
      } else if (j >= right.length) {
        arr[k++] = left[i++];
      } else {
        if (left[i] < right[j]) {
          arr[k++] = left[i++];
        } else {
          arr[k++] = right[j++];
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 5, 3, 5, 3, 2, 4, 5, 2};
    System.out.println(Arrays.toString(arr));
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
