package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 11. 25.
 */
public class SearchRange34Test {
    SearchRange34 solution = new SearchRange34();

    @Test
    public void test1() throws Exception {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(nums, -1));
        assertArrayEquals(new int[]{0, 0}, solution.searchRange(nums, 5));
        assertArrayEquals(new int[]{3, 4}, solution.searchRange(nums, 8));
        assertArrayEquals(new int[]{5, 5}, solution.searchRange(nums, 10));
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(nums, 11));
    }

    @Test
    public void test2() throws Exception {
        int[] nums = new int[]{};
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(nums, 1));
    }
}