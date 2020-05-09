package com.nishant.algorithms.DataStructures.MinPriorityQueue;

import com.nishant.algorithms.DataStructures.MinPriotiryQueue.MinHeap.MinHeap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinHeapTest {

    private MinHeap heap;

    @Before
    public void setup() {
        heap = new MinHeap();
    }

    @Test
    public void containsTest() {
        assertFalse(heap.contains(5));
        heap.add(5);
        assertTrue(heap.contains(5));
    }

    @Test
    public void isEmptyTest() {
        assertTrue(heap.isEmpty());
        heap.add(5);
        assertFalse(heap.isEmpty());
    }

    @Test
    public void extractMinTest() {
        heap.add(5);
        heap.add(4);
        heap.add(6);
        heap.add(1);
        heap.add(7);

        assertEquals(1, heap.extractMin());
    }

    @Test
    public void chainedExtractMinTest() {
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        heap.add(8);
        heap.add(9);
        heap.add(10);

        int count = 1;

        while(!heap.isEmpty()) {
            assertEquals(count ++, heap.extractMin());
        }
    }

    @Test
    public void decreaseKeyTest() {
        heap.add(5);
        heap.add(3);

        heap.decreaseValue(5, 2);

        assertEquals(2, heap.extractMin());
    }

}
