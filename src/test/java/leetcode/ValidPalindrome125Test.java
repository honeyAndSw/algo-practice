package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * ValidPalindrome125Test
 *
 * @author naheon
 * @since 2018. 01. 27.
 */
public class ValidPalindrome125Test {
	ValidPalindrome125 solution = new ValidPalindrome125();

	@Test
	public void test0() throws Exception {
		assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));

		assertTrue(solution.isPalindrome("A man, nama"));

		assertFalse(solution.isPalindrome("ea"));
		assertFalse(solution.isPalindrome("e a"));
		assertFalse(solution.isPalindrome("race a car"));
	}

	@Test
	public void test1() throws Exception {
		assertTrue(solution.isPalindrome("123321"));
		assertFalse(solution.isPalindrome("123421"));
	}

	@Test
	public void test2() throws Exception {
		assertTrue(solution.isPalindrome(""));
		assertTrue(solution.isPalindrome("A"));
	}

	@Test
	public void test() throws Exception {
		assertFalse(solution.isAlphaNumeric(' '));

	}
}