package Sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;
import sorting.selectionsort.SelectionSort;

public class SelectionSortTest {

  private int[] arr;

  @Before
  public void setup() {
    arr = new int[] {5, 3, 2, 1, 5};
  }

  @Test
  public void test() {
    SelectionSort.sort(arr);
    assertArrayEquals(new int[] {1, 2, 3, 5, 5}, arr);
  }
}
