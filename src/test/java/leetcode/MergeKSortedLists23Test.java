package leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import org.junit.Test;

/**
 * MergeKSortedLists23Test
 *
 * @author naheon
 * @since 2018. 01. 24.
 */
public class MergeKSortedLists23Test {
	MergeKSortedLists23 solution = new MergeKSortedLists23();

	@Test
	public void test0() throws Exception {
		ListNode[] lists = new ListNode[]{
			new ListNode(1)
		};

		int[] merged = solution.mergeKLists(lists).toArray();
		assertEquals(1, merged.length);
		assertArrayEquals(new int[]{1}, merged);
	}

	@Test
	public void test1() throws Exception {
		ListNode[] lists = new ListNode[]{
			new ListNode(2),
			new ListNode(1)
		};

		int[] merged = solution.mergeKLists(lists).toArray();
		assertEquals(2, merged.length);
		assertArrayEquals(new int[]{1,2}, merged);
	}

	@Test
	public void test2() throws Exception {
		ListNode[] lists = new ListNode[]{
			new ListNode(2, new ListNode(3)),
			new ListNode(1, new ListNode(2))
		};

		int[] merged = solution.mergeKLists(lists).toArray();
		assertArrayEquals(new int[]{1,2,2,3}, merged);
	}

	@Test
	public void test3() throws Exception {
		ListNode[] lists = new ListNode[]{
			new ListNode(Arrays.asList(2,3)),
			new ListNode(Arrays.asList(1,2,4))
		};

		int[] merged = solution.mergeKLists(lists).toArray();
		assertArrayEquals(new int[]{1,2,2,3,4}, merged);
	}

	@Test
	public void test4() throws Exception {
		assertNull(solution.mergeKLists(new ListNode[0]));
		assertNull(solution.mergeKLists(new ListNode[]{null}));
	}

	@Test
	public void test5() throws Exception {
		ListNode[] lists = new ListNode[]{
				new ListNode(Arrays.asList(1,2,2)),
				new ListNode(Arrays.asList(1,1,2))
		};

		int[] merged = solution.mergeKLists(lists).toArray();
		assertArrayEquals(new int[]{1,1,1,2,2,2}, merged);
	}
}
