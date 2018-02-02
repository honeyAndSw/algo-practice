package leetcode;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class BSTIterator173Test {

	@Test
	public void test0() throws Exception {
		equals(
			new TreeNode(10, new TreeNode(5), new TreeNode(15)),
			new int[]{5,10,15}
		);

		equals(new TreeNode(10), new int[]{10});
		equals(null, new int[0]);
	}

	@Test
	public void test1() throws Exception {
		equals(
			new TreeNode(10,
				new TreeNode(5, new TreeNode(4), new TreeNode(8)),
				new TreeNode(15, new TreeNode(11), new TreeNode(19))),
			new int[]{4,5,8,10,11,15,19}
		);

		equals(
			new TreeNode(10,
				new TreeNode(5),
				new TreeNode(15, new TreeNode(11), new TreeNode(19))),
			new int[]{5,10,11,15,19}
		);

		equals(
			new TreeNode(10,
				new TreeNode(5, new TreeNode(4), new TreeNode(8)),
				new TreeNode(15)),
			new int[]{4,5,8,10,15}
		);
	}

	@Test
	public void test2() throws Exception {
		equals(
			new TreeNode(10,
				null,
				new TreeNode(15,
					null,
					new TreeNode(20,
						null,
						new TreeNode(25)))),
			new int[]{10,15,20,25}
		);

		equals(
			new TreeNode(25,
				new TreeNode(20,
					new TreeNode(15,
						new TreeNode(10),
						null),
					null),
				null),
			new int[]{10,15,20,25}
		);
	}

	private void equals(TreeNode root, int[] expected) {
		BSTIterator173 iterator = new BSTIterator173(root);
		List<Integer> values = new LinkedList<>();
		while (iterator.hasNext()) {
			values.add(iterator.next());
		}

		assertArrayEquals(expected, values.stream().mapToInt(i -> i).toArray());
	}
}