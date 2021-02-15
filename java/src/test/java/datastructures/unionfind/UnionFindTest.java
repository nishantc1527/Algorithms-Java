package datastructures.unionfind;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnionFindTest {

  private UnionFind unionFind;

  @BeforeEach
  public void setUp() {
    unionFind = new UnionFind(5);
  }

  @Test
  public void testUnionAndFind() {
    assertEquals(0, unionFind.find(0));
    assertEquals(1, unionFind.find(1));
    assertEquals(2, unionFind.find(2));
    assertEquals(3, unionFind.find(3));
    assertEquals(4, unionFind.find(4));

    unionFind.union(0, 1);

    assertEquals(0, unionFind.find(0));
    assertEquals(0, unionFind.find(1));

    unionFind.union(2, 1);

    assertEquals(2, unionFind.find(0));
    assertEquals(2, unionFind.find(1));
    assertEquals(2, unionFind.find(2));
  }

  @Test
  public void testSameGroup() {
    assertFalse(unionFind.sameGroup(0, 1));

    unionFind.union(0, 1);

    assertTrue(unionFind.sameGroup(0, 1));
  }

  @Test
  void testIsPathCompressed() {
    assertTrue(unionFind.isPathCompressed());

    unionFind.union(0, 1);

    assertTrue(unionFind.isPathCompressed());

    unionFind.union(3, 2);
    unionFind.union(1, 2);

    assertFalse(unionFind.isPathCompressed());

    unionFind.find(2);

    assertTrue(unionFind.isPathCompressed());
  }
}
