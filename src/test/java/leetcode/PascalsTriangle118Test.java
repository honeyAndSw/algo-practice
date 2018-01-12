package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2018. 1. 12.
 */
public class PascalsTriangle118Test {
    PascalsTriangle118 solution = new PascalsTriangle118();

    @Test
    public void test0() throws Exception {
        assertEquals(0, solution.generate(0).size());

        List<List<Integer>> result1 = solution.generate(1);
        assertEquals(1, result1.size());
        assertArrayEquals(new Integer[]{1}, result1.get(0).toArray(new Integer[1]));

        List<List<Integer>> result2 = solution.generate(2);
        assertEquals(2, result2.size());
        assertArrayEquals(new Integer[]{1}, result2.get(0).toArray(new Integer[1]));
        assertArrayEquals(new Integer[]{1,1}, result2.get(1).toArray(new Integer[2]));
    }

    @Test
    public void test1() throws Exception {
        List<List<Integer>> result3 = solution.generate(3);
        assertEquals(3, result3.size());
        assertArrayEquals(new Integer[]{1,2,1}, result3.get(2).toArray(new Integer[3]));
    }
}
