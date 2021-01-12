package BitManipulation;

import static org.junit.Assert.assertEquals;

import bitmanipulation.problems.missingnumber.MissingNumber;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class MissingNumberTest {

  @Test
  public void testMissingNumber() {
    for (int i = 0; i < 100; i++) {
      int randomNumber = (int) (Math.random() * 100);
      ArrayList<Integer> arr = new ArrayList<>();

      for (int j = 0; j < 100; j++) {
        if (j != randomNumber) {
          arr.add((int) (Math.random() * arr.size()), j);
        }
      }
      assertEquals(
          randomNumber,
          MissingNumber.missingNumber(
              Arrays.stream(arr.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray()));
    }
  }
}
