package Algorithms.DataStructures.MinPriotiryQueue.MinHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MinHeap<E extends Comparable<E>> {

    private List<E> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public void add(E val) {
        heap.add(val);
        bubbleUp(heap.size() - 1);
    }

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

    public void decreaseValue(E val, E newVal) {
         int i = heap.indexOf(val);
         heap.set(i, newVal);
         bubbleUp(i);
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public Object[] getHeap() {
        return heap.toArray();
    }

    private void bubbleUp(int i) {
        if(i > 0) {
            int parent = getParent(i);
            if(heap.get(parent).compareTo(heap.get(i)) > 0) {
                swap(parent, i);
                bubbleUp(parent);
            }
        }
    }

    private void bubbleDown(int i) {
        int left = getLeft(i), right = getRight(i), largest = i;

        if(left < heap.size() && heap.get(left).compareTo(heap.get(largest)) < 0) {
            largest = left;
        }

        if(right < heap.size() && heap.get(right).compareTo(heap.get(largest)) < 0) {
            largest = right;
        }

        if(largest != i) {
            swap(i, largest);
            bubbleDown(largest);
        }
    }

    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
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

}
