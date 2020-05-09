package com.nishant.algorithms.DataStructures.MinPriotiryQueue.MinHeap;

public class Tester {

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.add(7);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(1);

        heap.decreaseValue(7, 1);

        while(!heap.isEmpty()) {
            System.out.println(heap.extractMin());
        }
    }

}
