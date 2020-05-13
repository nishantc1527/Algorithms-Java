package com.nishant.algorithms.Sorting.HeapSort;

import java.util.Arrays;

public class HeapSort {

  private static int heapSize;

  public static void sort(int[] arr) {
    buildHeap(arr);
    while (heapSize > 0) {
      arr[heapSize - 1] = popMax(arr);
    }
  }

  private static void buildHeap(int[] arr) {
    heapSize = arr.length;

    for (int i = (arr.length >> 1) - 1; i >= 0; i--) {
      heapify(arr, i);
    }
  }

  private static void heapify(int[] arr, int i) {
    int left = getLeft(i), right = getRight(i), largest = i;

    if (left < heapSize && arr[left] > arr[largest]) {
      largest = left;
    }

    if (right < heapSize && arr[right] > arr[largest]) {
      largest = right;
    }

    if (i != largest) {
      swap(arr, i, largest);
      heapify(arr, largest);
    }
  }

  private static int popMax(int[] heap) {
    int toReturn = heap[0];
    swap(heap, 0, heapSize - 1);
    heapSize--;
    heapify(heap, 0);
    return toReturn;
  }

  private static int getLeft(int i) {
    return (i << 1) + 1;
  }

  private static int getRight(int i) {
    return (i << 1) + 2;
  }

  private static void swap(int[] arr, int pos1, int pos2) {
    int temp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = temp;
  }

  public static void main(String[] args) {
    int[] arr = {1, 5, 3, 5, 3, 2, 4, 5, 2};
    System.out.println(Arrays.toString(arr));
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
