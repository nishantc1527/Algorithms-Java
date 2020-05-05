package Algorithms.DataStructures.MinPriotiryQueue.FibonacciHeap;

public class Tester {

    public static void main(String[] args) {
        FibonacciHeap h = new FibonacciHeap();

        for(int i = 0; i < 10; i ++) {
            h.insert(i);
        }

        h.delete(5);

        while(!h.isEmpty()) {
            System.out.println(h.extractMin());
        }

        System.out.println(h);
    }

}
