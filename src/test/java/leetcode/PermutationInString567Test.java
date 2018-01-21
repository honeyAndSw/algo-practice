package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2018. 1. 21.
 */
public class PermutationInString567Test {
    PermutationInString567 solution = new PermutationInString567();

    @Test
    public void test0() throws Exception {
        assertTrue(solution.checkInclusion("ab", "eidbaooo"));
        assertFalse(solution.checkInclusion("ab", "eidboaoo"));
    }

    @Test
    public void test1() throws Exception {
        assertTrue(solution.checkInclusion("adc", "dcda"));
    }
}