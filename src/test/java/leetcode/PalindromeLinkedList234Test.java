package leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class PalindromeLinkedList234Test {
	PalindromeLinkedList234 solution = new PalindromeLinkedList234();

	@Test
	public void test0() throws Exception {
		assertTrue(solution.isPalindrome(
			new ListNode(Arrays.asList(1)))
		);

		assertTrue(solution.isPalindrome(null));

		assertFalse(solution.isPalindrome(
			new ListNode(Arrays.asList(1,2)))
		);

		assertTrue(solution.isPalindrome(
			new ListNode(Arrays.asList(1,2,1)))
		);

		assertTrue(solution.isPalindrome(
			new ListNode(Arrays.asList(1,2,2,1)))
		);
	}
}