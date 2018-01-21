package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2018. 1. 21.
 */
public class ValidParentheses20Test {
    ValidParentheses20 solution = new ValidParentheses20();

    @Test
    public void test0() throws Exception {
        assertTrue(solution.isValid("()"));
        assertFalse(solution.isValid(")("));

        assertTrue(solution.isValid("([])"));
        assertTrue(solution.isValid("()[]{}"));
        assertTrue(solution.isValid("([{}])"));
        assertTrue(solution.isValid("([]{})"));
    }

    @Test
    public void test1() throws Exception {
        assertFalse(solution.isValid("(]"));
        assertFalse(solution.isValid("([)]"));
        assertFalse(solution.isValid("]"));
        assertFalse(solution.isValid("("));
    }
}