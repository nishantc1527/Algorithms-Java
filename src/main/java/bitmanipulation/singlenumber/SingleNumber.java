package bitmanipulation.singlenumber;

public class SingleNumber {

  public static int singleNumber(int[] arr) {
    int xor = 0;

    for (int i = 0; i < arr.length; i++) {
      xor ^= arr[i];
    }

    return xor;
  }

  public static void main(String[] args) {
    System.out.println(SingleNumber.singleNumber(new int[] {1, 2, 2, 1, 5}));
  }
}
