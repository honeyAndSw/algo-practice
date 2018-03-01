package leetcode;

import java.util.Stack;

public class SubtreeOfAnotherTree572 {

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null) return false;
		return (s.val == t.val && isSameTree(s, t)) || isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private boolean isSameTree(TreeNode s, TreeNode t) {
		if (s == null && t == null) return true;
		else if (s == null || t == null) return false;
		return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
	}

	// 1st submission --------------------------------

	/* 0.22% of java submissions runtime */
	public boolean isSubtree0(TreeNode s, TreeNode t) {
		if (s == null) return false;

		if (s.val == t.val && toPreorder(s).equals(toPreorder(t))) return true;
		return isSubtree0(s.left, t) || isSubtree0(s.right, t);
	}

	private String toPreorder(TreeNode t) {
		StringBuilder result = new StringBuilder();

		Stack<TreeNode> stack = new Stack<>();
		if (t != null) stack.push(t);

		while (!stack.isEmpty()) {
			TreeNode peak = stack.pop();
			result.append(peak.val);
			if (peak.left != null) stack.push(peak.left);
			if (peak.right != null) stack.push(peak.right);
		}

		return result.toString();
	}
}
