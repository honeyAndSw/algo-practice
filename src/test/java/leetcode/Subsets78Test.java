package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2018. 1. 30.
 */
public class Subsets78Test {
    Subsets78 solution = new Subsets78();

    @Test
    public void test0() throws Exception {
        List<List<Integer>> result = solution.subsets(new int[]{1});
        assertEquals(2, result.size());
        assertArrayEquals(new int[]{1}, result.get(0).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[0], result.get(1).stream().mapToInt(i -> i).toArray());

        assertEquals(1, solution.subsets(new int[0]).size());
    }
}