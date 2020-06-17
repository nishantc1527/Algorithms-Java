package BitManipulation;

import static org.junit.Assert.assertEquals;

import bitmanipulation.singlenumber.SingleNumber;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class SingleNumberTest {

  @Test
  public void testSingleNumber() {
    for (int i = 0; i < 10000; i++) {
      ArrayList<Integer> arr = new ArrayList<>();
      int randomNumber = (int) (Math.random() * 1000);

      for (int j = 0; j < 2000; j++) {
        if (j == randomNumber) {
          arr.add((int) (Math.random() * arr.size()), j);
        } else {
          arr.add((int) (Math.random() * arr.size()), j);
          arr.add((int) (Math.random() * arr.size()), j);
        }
      }

      assertEquals(
          randomNumber,
          SingleNumber.singleNumber(
              Arrays.stream(arr.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray()));
    }
  }
}
