package interviewcake;

import leetcode.TreeNode;

public class BstLargest {
	TreeNode largest(TreeNode root) {
		TreeNode p = root;
		while (p != null && p.right != null) p = p.right;
		return p;
	}
}
