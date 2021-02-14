package bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import bitmanipulation.problems.poweroftwo.PowerOfTwo;
import org.junit.jupiter.api.Test;

public class PowerOfTwoTest {

  @Test
  public void testPowerOfTwo() {
    int num = 1;
    for (int i = 1; i < 31; i++) {
      assertTrue(PowerOfTwo.isPowerOfTwo(num));
      num <<= 1;
    }
  }

  @Test
  public void testNonPowerOfTwo() {
    int num = 1;
    for (int i = 1; i < 31; i++) {
      num = BasicOperators.clearBit(num, (int) (Math.random() * i));
      assertFalse(PowerOfTwo.isPowerOfTwo(num));
      num <<= 1;
    }
  }

  @Test
  public void testNegative() {
    for (int i = -Integer.MAX_VALUE; i < 0; i++) {
      assertFalse(PowerOfTwo.isPowerOfTwo(i));
    }
  }

  @Test
  public void testZero() {
    assertFalse(PowerOfTwo.isPowerOfTwo(0));
  }

  @Test
  public void testOne() {
    assertTrue(PowerOfTwo.isPowerOfTwo(1));
  }
}
