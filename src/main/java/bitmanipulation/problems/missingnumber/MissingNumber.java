package bitmanipulation.problems.missingnumber;

public class MissingNumber {

  public static int missingNumber(int[] arr) {
    int XOR = 0;

    for (int i = 0; i < arr.length; i++) {
      XOR ^= i ^ arr[i];
    }

    return XOR ^ arr.length;
  }

  public static void main(String[] args) {
    System.out.println(MissingNumber.missingNumber(new int[] {0, 5, 3, 2, 4}));
  }
}
