package sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sorting.mergesort.MergeSort;

public class MergeSortTest {

  private int[] arr;

  @BeforeEach
  public void setup() {
    arr = new int[] {5, 3, 2, 1, 5};
  }

  @Test
  public void test() {
    MergeSort.sort(arr);
    assertArrayEquals(new int[] {1, 2, 3, 5, 5}, arr);
  }
}