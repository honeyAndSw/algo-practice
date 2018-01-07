package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2018. 1. 7.
 */
public class NextPermutation31Test {
    NextPermutation31 solution = new NextPermutation31();

    @Test
    public void test0() throws Exception {
        int[] nums1 = new int[]{};
        solution.nextPermutation(nums1);

        int[] nums2 = new int[]{1};
        solution.nextPermutation(nums2);
    }

    @Test
    public void test1() throws Exception {
        int[] nums1 = new int[]{1,1,1};
        solution.nextPermutation(nums1);
        assertArrayEquals(new int[]{1,1,1}, nums1);
    }

    @Test
    public void test2() throws Exception {
        int[] nums1 = new int[]{1,2};
        solution.nextPermutation(nums1);
        assertArrayEquals(new int[]{2,1}, nums1);

        int[] nums2 = new int[]{2,1};
        solution.nextPermutation(nums2);
        assertArrayEquals(new int[]{1,2}, nums2);
    }

    @Test
    public void test3() throws Exception {
        int[] nums1 = new int[]{1,2,3};

        solution.nextPermutation(nums1); // 1,2,3 -> 1,3,2
        assertArrayEquals(new int[]{1,3,2}, nums1);

        solution.nextPermutation(nums1); // 1,3,2 -> 2,1,3
        assertArrayEquals(new int[]{2,1,3}, nums1);

        solution.nextPermutation(nums1); // 2,1,3 -> 2,3,1
        assertArrayEquals(new int[]{2,3,1}, nums1);

        solution.nextPermutation(nums1); // 2,3,1 -> 3,1,2
        assertArrayEquals(new int[]{3,1,2}, nums1);

        solution.nextPermutation(nums1); // 3,1,2 -> 3,2,1
        assertArrayEquals(new int[]{3,2,1}, nums1);

        solution.nextPermutation(nums1); // 3,2,1 -> 1,2,3
        assertArrayEquals(new int[]{1,2,3}, nums1);
    }

    @Test
    public void test4() throws Exception {
        int[] nums1 = new int[]{1,1,5};

        solution.nextPermutation(nums1); // 1,1,5 -> 1,5,1
        assertArrayEquals(new int[]{1,5,1}, nums1);

        solution.nextPermutation(nums1); // 1,5,1 -> 5,1,1
        assertArrayEquals(new int[]{5,1,1}, nums1);

        solution.nextPermutation(nums1); // 5,1,1 -> 1,1,5
        assertArrayEquals(new int[]{1,1,5}, nums1);
    }
}