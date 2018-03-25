package interviewcake;

import static org.junit.Assert.*;

import leetcode.TreeNode;
import org.junit.Test;

public class BstSecondLargestTest {
	BstSecondLargest solution = new BstSecondLargest();

	@Test
	public void test0() throws Exception {
		assertNull(solution.secondLargest(new TreeNode(10)));

		assertEquals(10, solution.secondLargest(
			new TreeNode(10, new TreeNode(5), new TreeNode(15))
		).intValue());

		assertEquals(10, solution.secondLargest(
			new TreeNode(10, null, new TreeNode(15))
		).intValue());

		assertEquals(5, solution.secondLargest(
			new TreeNode(10, new TreeNode(5), null)
		).intValue());
	}

	@Test
	public void test1() throws Exception {
		assertEquals(15, solution.secondLargest(
			new TreeNode(10,
				null,
				new TreeNode(15, new TreeNode(13), new TreeNode(20)))
		).intValue());

		assertEquals(20, solution.secondLargest(
			new TreeNode(10,
				null,
				new TreeNode(15,
					new TreeNode(13),
					new TreeNode(20, null, new TreeNode(23))))
		).intValue());

		assertEquals(7, solution.secondLargest(
			new TreeNode(10,
				new TreeNode(5, new TreeNode(3), new TreeNode(7)),
				null)
		).intValue());

		assertEquals(8, solution.secondLargest(
			new TreeNode(10,
				new TreeNode(5,
					new TreeNode(3),
					new TreeNode(7, new TreeNode(6), new TreeNode(8))),
				null)
		).intValue());

		assertEquals(9, solution.secondLargest(
			new TreeNode(10,
				new TreeNode(9, new TreeNode(8, new TreeNode(7), null), null),
				null)
		).intValue());
	}
}
