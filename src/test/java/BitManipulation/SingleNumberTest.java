package BitManipulation;

import static org.junit.Assert.assertEquals;

import bitmanipulation.problems.singlenumber.SingleNumber;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class SingleNumberTest {

  @Test
  public void testSingleNumber() {
    for (int i = 0; i < 100; i++) {
      ArrayList<Integer> arr = new ArrayList<>();
      int randomNumber = (int) (Math.random() * 100);

      for (int j = 0; j < 100; j++) {
        arr.add((int) (Math.random() * arr.size()), j);
        if (j != randomNumber) {
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
