package DynamicProgramming;

import static org.junit.Assert.assertEquals;

import dynmanicprogramming.problems.uniquepaths.UniquePaths;
import org.junit.Before;
import org.junit.Test;

public class UniquePathsTest {

  private int m, n;

  @Before
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
