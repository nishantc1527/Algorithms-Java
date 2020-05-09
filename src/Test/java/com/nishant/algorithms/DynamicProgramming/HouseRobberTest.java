package com.nishant.algorithms.DynamicProgramming;

import com.nishant.algorithms.DynamicProgramming.HouseRobber.HouseRobber;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseRobberTest {

    private int[] arr;

    @Before
    public void setup() {
        arr = new int[]{1, 2, 3, 1, 4, 1, 3, 4, 3, 2, 1, 3, 4, 3, 2, 1};
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
