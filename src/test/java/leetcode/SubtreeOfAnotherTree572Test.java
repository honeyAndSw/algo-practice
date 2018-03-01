package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubtreeOfAnotherTree572Test {
	SubtreeOfAnotherTree572 solution = new SubtreeOfAnotherTree572();

	@Test
	public void test0() throws Exception {
		assertTrue(solution.isSubtree(
			new TreeNode(3,
				new TreeNode(4, new TreeNode(1), new TreeNode(2)),
				new TreeNode(5)
			),
			new TreeNode(4, new TreeNode(1), new TreeNode(2))
		));

		assertFalse(solution.isSubtree(
			new TreeNode(3,
				new TreeNode(4, new TreeNode(1, new TreeNode(0), null), new TreeNode(2)),
				new TreeNode(5)
			),
			new TreeNode(4, new TreeNode(1), new TreeNode(2))
		));
	}
}