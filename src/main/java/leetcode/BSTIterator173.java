package leetcode;

import java.util.Stack;

public class BSTIterator173 {
	// Optimization: `next` isn't required.
	// TreeNode next;
	Stack<TreeNode> stack;

	public BSTIterator173(TreeNode root) {
		stack = new Stack<>();
		pushAllLefts(root);
		// setNext();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		// return next != null;
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		// int val = next.val;
		// setNext();
		// return val;
		TreeNode top = stack.pop();
		pushAllLefts(top.right);
		return top.val;
	}

	private void pushAllLefts(TreeNode root) {
		TreeNode p = root;
		while (p != null) {
			stack.push(p);
			p = p.left;
		}
	}

	private void setNext() {
		// if (stack.isEmpty()) {
		// 	next = null;
		// } else {
		// 	next = stack.pop();
		// 	if (next.right != null) {
		// 		pushAllLefts(next.right);
		// 	}
		// }
	}
}
