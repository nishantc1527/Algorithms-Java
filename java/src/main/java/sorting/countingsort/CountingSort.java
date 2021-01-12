package sorting.countingsort;

import java.util.Arrays;

public class CountingSort {

  public static void sort(int[] arr) {
    int[] minMax = minAndMax(arr);
    int[] count = new int[minMax[1] - minMax[0] + 1];

    for (int value : arr) {
      count[value - minMax[0]]++;
    }

    int k = 0;
    for (int i = 0; i < count.length; i++) {
      while (count[i] > 0) {
        arr[k++] = i + minMax[0];
        count[i]--;
      }
    }
  }

  private static int[] minAndMax(int[] arr) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    for (int value : arr) {
      if (value < min) {
        min = value;
      }

      if (value > max) {
        max = value;
      }
    }

    return new int[] {min, max};
  }

  public static void main(String[] args) {
    int[] arr = {1, 5, 3, 5, 3, 2, 4, 5, 2};
    System.out.println(Arrays.toString(arr));
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
