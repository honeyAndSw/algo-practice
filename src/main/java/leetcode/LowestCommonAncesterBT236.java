package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LowestCommonAncesterBT236 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// if (root == null) return null;
		// root == p || root == q
		// 		1) One of p and q is root and the other is in it's subtree.
		// 		2) p or q is a leaf.
		if (root == null || root == p || root == q) return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		// 1) left != null && right != null
		// 		p and q are distributed in root's left and right subtree, then root is LCA.
		// 2) left != null && right == null
		//    left == null && right != null
		// 		p and q are in left OR right subtree.
		// 3) left == null && right == null
		// 		Doesn't exist, unless p.val == q.val == root.val
		return left == null ? right : (right == null ? left : root);
	}

	public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> parents = getParents(root, p);
		return getClosestParent(root, q, parents);
	}

	public List<TreeNode> getParents(TreeNode root, TreeNode t) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		TreeNode child = null;
		List<TreeNode> parents = new LinkedList<>();
		boolean foundT = false;

		while (!stack.isEmpty()) {
			TreeNode top = stack.peek();

			if (top == t) {
				foundT = true;
			}
			else if (top == root && foundT) {
				parents.add(root);
				break;
			}

			if (isLeaf(top)) {
				TreeNode self = stack.pop();

				if (foundT) {
					child = stack.pop();
					parents.add(child);
				} else if (stack.peek().left.equals(self)) {
					stack.push(stack.peek().right);
				} else {
					child = stack.pop();
				}
			} else {
				if (foundT) {
					child = stack.pop();
					parents.add(child);
				} else if (top.left.equals(child)) {
					stack.push(top.right);
				} else if (top.right.equals(child)) {
					child = stack.pop();
				} else {
					stack.push(top.left);
				}
			}
		}

		return parents;
	}

	private boolean isLeaf(TreeNode t) {
		return t.left == null && t.right == null;
	}

	private TreeNode getClosestParent(TreeNode root, TreeNode t, List<TreeNode> between) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		TreeNode child = null;
		boolean foundT = false;

		while (!stack.isEmpty()) {
			TreeNode top = stack.peek();

			if (top == t) {
				foundT = true;
			}
			else if (top == root && foundT) {
				return root;
			}

			if (isLeaf(top)) {
				TreeNode self = stack.pop();

				if (foundT) {
					child = stack.pop();
					if (between.contains(child)) return child;
				} else if (stack.peek().left.equals(self)) {
					stack.push(stack.peek().right);
				} else {
					child = stack.pop();
				}
			} else {
				if (foundT) {
					child = stack.pop();
					if (between.contains(child)) return child;
				} else if (top.left.equals(child)) {
					stack.push(top.right);
				} else if (top.right.equals(child)) {
					child = stack.pop();
				} else {
					stack.push(top.left);
				}
			}
		}

		return root;
	}
}
