package dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dynmanicprogramming.problems.houserobber.HouseRobber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HouseRobberTest {

  private int[] arr;

  @BeforeEach
  public void setup() {
    arr = new int[] {1, 2, 3, 1, 4, 1, 3, 4, 3, 2, 1, 3, 4, 3, 2, 1};
  }

  @Test
  public void bruteForceTest() {
    assertEquals(21, HouseRobber.bruteForce(arr));
  }

  @Test
  public void memoizedTest() {
    assertEquals(21, HouseRobber.memoized(arr));
  }

  @Test
  public void bottomUpTest() {
    assertEquals(21, HouseRobber.bottomUp(arr));
  }
}
