package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * RegularExpressionMatching10Test
 */
public class RegularExpressionMatching10Test {
	RegularExpressionMatching10 solution = new RegularExpressionMatching10();

	@Test
	public void test0() throws Exception {
		assertFalse(solution.isMatch("aa", "a"));
		assertFalse(solution.isMatch("aaa", "aa"));
		assertFalse(solution.isMatch("aaa", "aaaa"));

		assertTrue(solution.isMatch("aa", "aa"));
		assertTrue(solution.isMatch("aa", "a*"));
		assertTrue(solution.isMatch("aa", ".*"));
		assertTrue(solution.isMatch("ab", ".*"));
		assertTrue(solution.isMatch("aab", "c*a*b"));
	}

	@Test
	public void test1() throws Exception {
		assertTrue(solution.isMatch("aa", "a*"));
		assertFalse(solution.isMatch("ab", "cab"));
		assertFalse(solution.isMatch("ab", "abc"));
	}

	@Test
	public void test2() throws Exception {
		assertTrue(solution.isMatch("", ".*"));
		assertFalse(solution.isMatch("a", ""));
	}

	@Test
	public void test3() throws Exception {
		assertFalse(solution.isMatch("abcd", "d*"));
		assertTrue(solution.isMatch("ddd", "d*"));
		assertFalse(solution.isMatch("ab", "c.*"));
	}

	@Test
	public void test4() throws Exception {
		assertFalse(solution.isMatch("ab", ".*c"));
		assertTrue(solution.isMatch("ab", ".*c*"));
		assertTrue(solution.isMatch("ab", ".*c*a*"));
	}
}