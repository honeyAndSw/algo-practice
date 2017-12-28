package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 12. 28.
 */
public class LongestCommonPrefix14Test {
    LongestCommonPrefix14 solution = new LongestCommonPrefix14();

    @Test
    public void test0() throws Exception {
        assertEquals("", solution.longestCommonPrefix(new String[]{""}));
        assertEquals("", solution.longestCommonPrefix(new String[]{"", "a"}));
        assertEquals("a", solution.longestCommonPrefix(new String[]{"a"}));
        assertEquals("abc", solution.longestCommonPrefix(new String[]{"abc"}));
    }

    @Test
    public void test1() throws Exception {
        assertEquals("", solution.longestCommonPrefix(new String[]{"b", "a"}));
    }
}