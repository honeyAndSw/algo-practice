package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 12. 16.
 */
public class LIS300Test {
    LIS300 solution = new LIS300();

    @Test
    public void test0() throws Exception {
        assertEquals(0, solution.lengthOfLIS(new int[0]));
        assertEquals(1, solution.lengthOfLIS(new int[]{1}));
    }

    @Test
    public void test1() throws Exception {
        assertEquals(4, solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(3, solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4}));
    }

    @Test
    public void test2() throws Exception {
        assertEquals(1, solution.lengthOfLIS(new int[]{10, 9, 8, 7, 6}));
        assertEquals(5, solution.lengthOfLIS(new int[]{6, 7, 8, 9, 10}));
        assertEquals(4, solution.lengthOfLIS(new int[]{6, 6, 8, 9, 10}));
        assertEquals(4, solution.lengthOfLIS(new int[]{6, 7, 6, 9, 10}));
        assertEquals(4, solution.lengthOfLIS(new int[]{6, 7, 8, 9, 6}));
    }
}