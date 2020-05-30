package Sorting;

import org.junit.Before;
import org.junit.Test;
import sorting.countingsort.CountingSort;

import static org.junit.Assert.assertArrayEquals;

public class CountingSortTest {

  private int[] arr;

  @Before
  public void setup() {
    arr = new int[] {5, 3, 2, 1, 5};
  }

  @Test
  public void test() {
    CountingSort.sort(arr);
    assertArrayEquals(new int[] {1, 2, 3, 5, 5}, arr);
  }
}
