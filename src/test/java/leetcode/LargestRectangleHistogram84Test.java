package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestRectangleHistogram84Test {
    LargestRectangleHistogram84 solution = new LargestRectangleHistogram84();

    @Test
    public void test0() throws Exception {
        assertEquals(1, solution.largestRectangleArea(new int[]{1}));
    }

    @Test
    public void test1() throws Exception {
        assertEquals(10, solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}