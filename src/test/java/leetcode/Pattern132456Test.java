package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 12. 17.
 */
public class Pattern132456Test {
    Pattern132456 solution = new Pattern132456();

    @Test
    public void test0() throws Exception {
        assertFalse(solution.find132pattern(new int[]{1, 2, 3, 4}));
        assertFalse(solution.find132pattern(new int[]{4, 3, 2, 1}));
        assertFalse(solution.find132pattern(new int[]{1, 1, 1, 1}));
        assertTrue(solution.find132pattern(new int[]{3, 1, 4, 2}));
        assertTrue(solution.find132pattern(new int[]{-1, 3, 2, 0}));
    }

    @Test
    public void test1() throws Exception {
        assertFalse(solution.find132pattern(new int[]{3, 1, 4, 4}));
        assertTrue(solution.find132pattern(new int[]{1, 4, 2}));
        assertFalse(solution.find132pattern(new int[]{3, 1, 4}));
    }

    @Test
    public void test2() throws Exception {
        assertFalse(solution.find132pattern(new int[]{}));
        assertFalse(solution.find132pattern(new int[]{1}));
        assertFalse(solution.find132pattern(new int[]{1, 2}));
    }

    @Test
    public void test3() throws Exception {
        assertTrue(solution.find132pattern(new int[]{3, 5, 0, 3, 4}));
    }

    @Test
    public void test4() throws Exception {
        assertFalse(solution.find132pattern(new int[]{1, 0, 1, -4, -3}));
    }
}