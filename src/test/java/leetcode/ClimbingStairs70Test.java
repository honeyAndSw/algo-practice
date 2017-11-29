package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 11. 26.
 */
public class ClimbingStairs70Test {
    ClimbingStairs70 solution = new ClimbingStairs70();

    @Test
    public void test1() throws Exception {
        assertEquals(1, solution.climbStairs(1));
        assertEquals(2, solution.climbStairs(2));
        assertEquals(3, solution.climbStairs(3));
        assertEquals(1134903170, solution.climbStairs(44));
    }
}