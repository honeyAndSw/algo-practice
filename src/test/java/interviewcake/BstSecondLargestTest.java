package interviewcake;

import static org.junit.Assert.*;

import leetcode.TreeNode;
import org.junit.Test;

public class BstSecondLargestTest {
	BstSecondLargest solution = new BstSecondLargest();

	private TreeNode secondLargest(TreeNode root) {
		return solution.iterativeSoltuion(root);
	}

	@Test
	public void test0() throws Exception {
		assertNull(secondLargest(new TreeNode(10)));

		assertEquals(10, secondLargest(
			new TreeNode(10, new TreeNode(5), new TreeNode(15))
		).val);

		assertEquals(10, secondLargest(
			new TreeNode(10, null, new TreeNode(15))
		).val);

		assertEquals(5, secondLargest(
			new TreeNode(10, new TreeNode(5), null)
		).val);
	}

	@Test
	public void test1() throws Exception {
		assertEquals(15, secondLargest(
			new TreeNode(10,
				null,
				new TreeNode(15, new TreeNode(13), new TreeNode(20)))
		).val);

		assertEquals(20, secondLargest(
			new TreeNode(10,
				null,
				new TreeNode(15,
					new TreeNode(13),
					new TreeNode(20, null, new TreeNode(23))))
		).val);

		assertEquals(7, secondLargest(
			new TreeNode(10,
				new TreeNode(5, new TreeNode(3), new TreeNode(7)),
				null)
		).val);

		assertEquals(8, secondLargest(
			new TreeNode(10,
				new TreeNode(5,
					new TreeNode(3),
					new TreeNode(7, new TreeNode(6), new TreeNode(8))),
				null)
		).val);

		assertEquals(9, secondLargest(
			new TreeNode(10,
				new TreeNode(9, new TreeNode(8, new TreeNode(7), null), null),
				null)
		).val);
	}

	@Test
	public void test2() throws Exception {
		assertEquals(8, secondLargest(
			new TreeNode(5,
				new TreeNode(3, new TreeNode(1), new TreeNode(4)),
				new TreeNode(8, new TreeNode(7), new TreeNode(9))
			)
		).val);
	}
}
