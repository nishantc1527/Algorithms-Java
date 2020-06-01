package BitManipulation;

import bitmanipulation.singlenumber.SingleNumber;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SingleNumberTest {

  private int[] arr;

  @Test
  public void resultTest() {
    for (int i = 0; i < 10000; i++) {
      ArrayList<Integer> arr = new ArrayList<>();
      int randomNumber = (int) (Math.random() * 1000);
      
      for(int j = 0; j < 2000; j ++) {
        if(j == randomNumber) {
          arr.add((int) (Math.random() * arr.size()), j);
        } else {
          arr.add((int) (Math.random() * arr.size()), j);
          arr.add((int) (Math.random() * arr.size()), j);
        }
      }
      
      assertEquals(randomNumber, SingleNumber.singleNumber(Arrays.stream(arr.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray()));
    }
  }
}
