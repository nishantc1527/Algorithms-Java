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
    for (int i = 0; i < 100; i++) {
      HashSet<Integer> set = new HashSet<>();
      MinHeap<Integer> heap = new MinHeap<>(Integer::compare);

      for (int j = 0; j < 100; j++) {
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
      MinHeap<Integer> heap = new MinHeap<>(Integer::compare);
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
    for (int i = 0; i < 100; i++) {
      PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
      MinHeap<Integer> heap = new MinHeap<>(Integer::compare);

      for (int j = 0; j < 100; j++) {
        if (Math.random() >= 0.5) {
          priorityQueue.add(j);
          heap.add(j);
        }
      }

      assertEquals(priorityQueue.poll(), heap.extractMin());
    }
  }

  @Test
  public void chainedExtractMinTest() {
    for (int i = 0; i < 100; i++) {
      int[] toAdd = new int[100];
      MinHeap<Integer> heap = new MinHeap<>(Integer::compare);

      for (int j = 0; j < toAdd.length; j++) {
        toAdd[j] = (int) (Math.random() * 1000);
        heap.add(toAdd[j]);
      }

      int[] sorted = toAdd.clone();
      Arrays.sort(sorted);
      int[] heapValues = new int[100];

      for (int j = 0; j < heapValues.length; j++) {
        heapValues[j] = heap.extractMin();
      }

      assertArrayEquals(sorted, heapValues);
    }
  }

  @Test
  public void decreaseKeyTest() {
    for (int i = 0; i < 100; i++) {
      PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compare);
      MinHeap<Integer> heap = new MinHeap<>(Integer::compare);

      for (int j = 0; j < 100; j++) {
        heap.add(j);
      }

      for (Integer j : heap) {
        heap.decreaseValue(j, j / 2);
      }

      for (Integer j : heap) {
        queue.add(j);
      }

      while (!heap.isEmpty()) {
        assertEquals(queue.poll(), heap.extractMin());
      }
    }
  }
}
