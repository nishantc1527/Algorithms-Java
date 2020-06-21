package datastructures.minpriorityqueue.MinHeap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unused")
public class MinHeap<E> {

  public final List<E> heap;
  private final Comparator<E> comparator;

  public MinHeap(Comparator<E> comparator) {
    heap = new ArrayList<>();
    this.comparator = comparator;
  }

  private static int getLeft(int i) {
    return (i << 1) + 1;
  }

  private static int getRight(int i) {
    return (i << 1) + 2;
  }

  private static int getParent(int i) {
    return i % 2 == 0 ? (i >> 1) - 1 : (i >> 1);
  }

  public static void main(String[] args) {
    MinHeap<Integer> heap = new MinHeap<>(Integer::compare);
    heap.add(7);
    heap.add(4);
    heap.add(3);
    heap.add(2);
    heap.add(1);

    while (!heap.isEmpty()) {
      System.out.println(heap.extractMin());
    }
  }

  public void add(E val) {
    heap.add(val);
    bubbleUp(heap.size() - 1);
  }

  @SuppressWarnings("unused")
  public E getMin() {
    return heap.get(0);
  }

  public E extractMin() {
    E toReturn = heap.get(0);
    swap(0, heap.size() - 1);
    heap.remove(heap.size() - 1);
    bubbleDown(0);
    return toReturn;
  }

  public void decreaseValue(E val) {
    bubbleUp(heap.indexOf(val));
  }

  public boolean isEmpty() {
    return heap.size() == 0;
  }

  public boolean contains(int i) {
    return heap.contains(i);
  }

  private void bubbleUp(int i) {
    if (i > 0) {
      int parent = getParent(i);
      if (comparator.compare(heap.get(parent), heap.get(i)) > 0) {
        swap(parent, i);
        bubbleUp(parent);
      }
    }
  }

  private void bubbleDown(int i) {
    int left = getLeft(i), right = getRight(i), largest = i;

    if (left < heap.size() && comparator.compare(heap.get(left), heap.get(largest)) < 0) {
      largest = left;
    }

    if (right < heap.size() && comparator.compare(heap.get(right), heap.get(largest)) < 0) {
      largest = right;
    }

    if (largest != i) {
      swap(i, largest);
      bubbleDown(largest);
    }
  }

  private void swap(int i, int j) {
    E temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
  }
}
