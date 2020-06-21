package DataStructures.MinPriorityQueue;

import static org.junit.Assert.*;

import datastructures.minpriorityqueue.MinHeap.MinHeap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import org.junit.Test;

public class MinHeapTest {

  @Test
  public void containsTest() {
    for (int i = 0; i < 10000; i++) {
      HashSet<Integer> set = new HashSet<>();
      MinHeap heap = new MinHeap();

      for (int j = 0; j < 1000; j++) {
        if (Math.random() >= 0.5) {
          set.add(j);
          heap.add(j);
        }
      }

      for (Integer integer : set) {
        assertTrue(heap.contains(integer));
      }
    }
  }

  @Test
  public void isEmptyTest() {
    for (int i = 0; i < 100; i++) {
      MinHeap heap = new MinHeap();
      assertTrue(heap.isEmpty());
      int randomAmount = 1 + (int) (Math.random() * 1000);
      for (int j = 0; j < randomAmount; j++) {
        heap.add((int) (Math.random() * 1000));
      }
      assertFalse(heap.isEmpty());
    }
  }

  @Test
  public void extractMinTest() {
    for (int i = 0; i < 1000; i++) {
      PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
      MinHeap heap = new MinHeap();

      for (int j = 0; j < 1000; j++) {
        if (Math.random() >= 0.5) {
          priorityQueue.add(j);
          heap.add(j);
        }
      }

      //noinspection ConstantConditions
      assertEquals((int) priorityQueue.poll(), heap.extractMin());
    }
  }

  @Test
  public void chainedExtractMinTest() {
    for (int i = 0; i < 1000; i++) {
      int[] toAdd = new int[1000];
      MinHeap heap = new MinHeap();

      for (int j = 0; j < toAdd.length; j++) {
        toAdd[j] = (int) (Math.random() * 1000);
        heap.add(toAdd[j]);
      }

      int[] sorted = toAdd.clone();
      Arrays.sort(sorted);
      int[] heapValues = new int[1000];

      for (int j = 0; j < heapValues.length; j++) {
        heapValues[j] = heap.extractMin();
      }

      assertArrayEquals(sorted, heapValues);
    }
  }

  /*
  @Test
  public void decreaseKeyTest() {
    heap.add(5);
    heap.add(3);

    heap.decreaseValue(5, 2);

    assertEquals(2, heap.extractMin());
  }
   */
}
