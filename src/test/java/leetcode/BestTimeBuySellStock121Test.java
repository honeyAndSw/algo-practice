package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 11. 30.
 */
public class BestTimeBuySellStock121Test {

    BestTimeBuySellStock121 solution = new BestTimeBuySellStock121();

    @Test
    public void test1() throws Exception {
        assertEquals(5, solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(0, solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    @Test
    public void test2() throws Exception {
        assertEquals(0, solution.maxProfit(new int[]{1}));
        assertEquals(0, solution.maxProfit(new int[]{}));
    }

    @Test
    public void test3() throws Exception {
        int[] longInput = new int[30000];
        for (int i = 10000; i >= 0; i--) {
            longInput[10000 - i] = i;
        }
        assertEquals(0, solution.maxProfit(longInput));
    }
}