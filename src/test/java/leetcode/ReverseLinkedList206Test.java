package leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class ReverseLinkedList206Test {
	ReverseLinkedList206 solution = new ReverseLinkedList206();

	@Test
	public void test0() throws Exception {
		assertArrayEquals(
			new int[]{5,4,3,2,1},
			solution.reverseList(new ListNode(Arrays.asList(1,2,3,4,5))).toArray());

		assertArrayEquals(
			new int[]{1},
			solution.reverseList(new ListNode(1)).toArray());
	}
}