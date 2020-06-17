package DataStructures.MinPriorityQueue;

import datastructures.minpriorityqueue.FibonacciHeap.FibonacciHeap;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

@SuppressWarnings("unused")
public class FibonacciHeapTest {

  private FibonacciHeap heap;

  @Test
  public void isEmptyTest() {
    heap = new FibonacciHeap();
    assertTrue(heap.isEmpty());
    heap.insert(5);
    assertFalse(heap.isEmpty());
    heap.extractMin();
    assertTrue(heap.isEmpty());
  }

  @Test
  public void extractMinTest() {
    for (int i = 0; i < 10000; i++) {
      heap = new FibonacciHeap();
      int[] arr = new int[1000];

      for (int j = 0; j < arr.length; j++) {
        arr[j] = (int) (Math.random() * 1000);
      }

      int min = Integer.MAX_VALUE;

      for (int j : arr) {
        heap.insert(j);
        min = Math.min(min, j);
      }

      assertEquals(min, heap.extractMin());
    }
  }

  // TODO Fix The Fibonacci Heap Extract Min Method
  // @Test
  public void chainedExtractMinTest() {
    for (int i = 0; i < 10000; i++) {
      heap = new FibonacciHeap();
      int[] arr = new int[1000];

      for (int j = 0; j < arr.length; j++) {
        arr[j] = (int) (Math.random() * 1000);
      }

      int[] sorted = arr.clone();
      Arrays.sort(sorted);

      for (int j : arr) {
        heap.insert(j);
      }

      int k = 0;

      while (!heap.isEmpty()) {
        arr[k++] = heap.extractMin();
      }

      assertArrayEquals(sorted, arr);
    }
  }
}
