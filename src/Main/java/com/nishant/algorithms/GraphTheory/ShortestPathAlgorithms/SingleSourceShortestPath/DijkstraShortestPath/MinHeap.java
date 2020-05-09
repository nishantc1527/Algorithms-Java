package com.nishant.algorithms.GraphTheory.ShortestPathAlgorithms.SingleSourceShortestPath.DijkstraShortestPath;

import com.nishant.algorithms.GraphTheory.Implementations.Vertex;

import java.util.HashMap;

public class MinHeap<E> {

    private HashMap<Vertex<E>, Integer> indices, keyToValue;
    private Vertex<E>[] heap;
    private int heapSize;

    public MinHeap(int maxSize) {
        heap = new Vertex[maxSize];
        indices = new HashMap<>();
        keyToValue = new HashMap<>();
    }

    public void add(Vertex<E> key, int value) {
        heap[heapSize] = key;
        keyToValue.put(key, value);
        bubbleUp(heapSize, value);
        heapSize ++;
    }

    public Vertex<E> extractMin() {
        Vertex<E> toReturn = heap[0];
        swap(0, --heapSize);
        heapify(0);
        return toReturn;
    }

    public void decreaseKey(Vertex<E> key, int newValue) {
        keyToValue.put(key, newValue);
        bubbleUp(indices.get(key), newValue);
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    private void heapify(int i) {
        int left = getLeft(i), right = getRight(i), smallest = i;

        if(left < heapSize && keyToValue.get(heap[left]) < keyToValue.get(heap[smallest])) {
            smallest = left;
        }

        if(right < heapSize && keyToValue.get(heap[right]) < keyToValue.get(heap[smallest])) {
            smallest = right;
        }

        if(i != smallest) {
            swap(i, smallest);
            heapify(smallest);
        } else {
            indices.put(heap[i], i);
        }
    }

    private void bubbleUp(int i, int value) {
        int parent = getParent(i);
        while(parent >= 0 && i > 0 && keyToValue.get(heap[parent]) > value) {
            swap(i, parent);
            indices.put(heap[i], i);
            i = parent;
            parent = getParent(i);
        }
        indices.put(heap[i], i);
    }

    private void swap(int i, int j) {
        Vertex<E> temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int getLeft(int i) {
        return (i << 1) + 1;
    }

    private int getRight(int i) {
        return (i << 1) + 2;
    }

    private int getParent(int i) {
        return i % 2 == 0 ? (i >> 1) - 1 : (i >> 1);
    }

}
