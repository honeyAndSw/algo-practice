package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidPalindromeII680Test {
	ValidPalindromeII680 solution = new ValidPalindromeII680();

	@Test
	public void test0() throws Exception {
		assertTrue(solution.validPalindrome("abccba"));
		assertTrue(solution.validPalindrome("a"));
	}

	@Test
	public void test1() throws Exception {
		assertTrue(solution.validPalindrome("caba"));
		assertTrue(solution.validPalindrome("acba"));
		assertTrue(solution.validPalindrome("abca"));
		assertTrue(solution.validPalindrome("abac"));
	}

	@Test
	public void test2() throws Exception {
		assertTrue(solution.validPalindrome("acba"));
		assertFalse(solution.validPalindrome("acbda"));
	}
}