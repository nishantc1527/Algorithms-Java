package dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dynmanicprogramming.problems.uniquepaths.UniquePaths;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UniquePathsTest {

  private int m, n;

  @BeforeEach
  public void setup() {
    m = 7;
    n = 3;
  }

  @Test
  public void topDownTest() {
    assertEquals(28, UniquePaths.topDown(m, n));
  }

  @Test
  public void bottomUpTest() {
    assertEquals(28, UniquePaths.bottomUp(m, n));
  }
}
