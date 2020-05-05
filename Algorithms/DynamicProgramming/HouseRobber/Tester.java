package Algorithms.DynamicProgramming.HouseRobber;

public class Tester {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 4, 1, 3, 4, 3, 2, 1, 3, 4, 3, 2, 1}; // The answer is 21
        System.out.println(HouseRobber.memoized(arr));
    }

}
