package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2018. 1. 31.
 */
public class SearchRotatedSortedArray33Test {
    SearchRotatedSortedArray33 solution = new SearchRotatedSortedArray33();

    @Test
    public void test0() throws Exception {
        assertEquals(1, solution.search(new int[]{1,3}, 3));
        assertEquals(0, solution.search(new int[]{3,1}, 3));
        assertEquals(-1, solution.search(new int[]{3,1}, 2));
    }

    @Test
    public void test1() throws Exception {
        assertEquals(0, solution.search(new int[]{3,5,1}, 3));
        assertEquals(2, solution.search(new int[]{5,1,3}, 3));
        assertEquals(1, solution.search(new int[]{5,1,3}, 1));
    }
}