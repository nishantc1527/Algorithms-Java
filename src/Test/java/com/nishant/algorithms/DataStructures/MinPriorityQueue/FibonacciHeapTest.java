package com.nishant.algorithms.DataStructures.MinPriorityQueue;

import com.nishant.algorithms.DataStructures.MinPriotiryQueue.FibonacciHeap.FibonacciHeap;
import com.nishant.algorithms.DataStructures.Trie.Trie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciHeapTest {

    private FibonacciHeap heap;

    @Before
    public void setup() {
        heap = new FibonacciHeap();
    }

    @Test
    public void isEmptyTest() {
        assertTrue(heap.isEmpty());
        heap.insert(5);
        assertFalse(heap.isEmpty());
    }

    @Test
    public void extractMinTest() {
        heap.insert(5);
        heap.insert(3);
        heap.insert(2);
        heap.insert(4);
        heap.insert(1);
        heap.insert(7);

        assertEquals(1, heap.extractMin());
    }

    @Test
    public void chainedExtractMinTest() {
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.insert(9);
        heap.insert(10);

        int count = 1;

        while(!heap.isEmpty()) {
            assertEquals(count ++, heap.extractMin());
        }
    }

}
