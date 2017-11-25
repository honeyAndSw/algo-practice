package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 11. 23.
 */
public class SingleNumber136Test {
    SingleNumber136 solution = new SingleNumber136();

    @Test
    public void singleNumber() throws Exception {
        assertEquals(5, solution.singleNumber(new int[]{-5, -5, 5}));
        assertEquals(3, solution.singleNumber(new int[]{3, 4, 5, 4, 5}));
    }

    @Test
    public void singleNumber_2() throws Exception {
        assertEquals(1, solution.singleNumber(new int[]{1}));
        assertEquals(-1, solution.singleNumber(new int[]{-1}));
    }

    @Test
    public void singleNumber2() throws Exception {
        assertEquals(5, solution.singleNumber2(new int[]{-5, -5, 5}));
        assertEquals(3, solution.singleNumber2(new int[]{3, 4, 5, 4, 5}));
        assertEquals(1, solution.singleNumber2(new int[]{1}));
        assertEquals(-1, solution.singleNumber2(new int[]{-1}));
    }
}