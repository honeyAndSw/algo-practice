package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * LongestPalindrome05Test
 *
 * @author naheon
 * @since 2017. 12. 01.
 */
public class LongestPalindrome05Test {
	LongestPalindrome05 solution = new LongestPalindrome05();

	@Test
	public void test0() throws Exception {
		assertEquals("", solution.longestPalindrome(""));
		assertEquals("", solution.longestPalindrome(null));
	}

	@Test
	public void test1() throws Exception {
		assertEquals("bab", solution.longestPalindrome("babad"));
		assertEquals("bb", solution.longestPalindrome("cbbd"));
		assertEquals("a", solution.longestPalindrome("a"));
	}

	@Test
	public void test2() throws Exception {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 1000; i++) {
			sb.append("a");
		}
		assertEquals(sb.toString(), solution.longestPalindrome(sb.toString()));
		solution.longestPalindrome
			("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
	}

	@Test
	public void test3() throws Exception {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 1000; i++) {
			sb.append(i);
		}
		solution.longestPalindrome(sb.toString());
	}

	@Test
	public void test4() throws Exception {
		assertEquals("bab", solution.longestPalindrome("babb"));
		assertEquals("aaabaaa", solution.longestPalindrome("aaabaaaa"));
	}
}