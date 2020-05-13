package com.nishant.algorithms.sorting;

import com.nishant.algorithms.sorting.selectionsort.SelectionSort;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SelectionSortTest {

  private int[] arr;

  @Before
  public void setup() {
    arr = new int[]{5, 3, 2, 1, 5};
  }

  @Test
  public void test() {
    SelectionSort.sort(arr);
    assertArrayEquals(new int[]{1, 2, 3, 5, 5}, arr);
  }
}
