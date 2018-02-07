package leetcode;

public class InorderSuccessorInBST285 {
	public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
		return inorderSuccessor1(root, p, null);
	}

	private TreeNode inorderSuccessor1(TreeNode root, TreeNode target, TreeNode parent) {
		if (root.val == target.val) return target.right == null ? parent : leftMost(target.right);
		else if (root.val > target.val) return inorderSuccessor1(root.left, target, root);
		else return inorderSuccessor1(root.right, target, parent);
	}

	private TreeNode leftMost(TreeNode root) {
		TreeNode p = root;
		while (p.left != null) p = p.left;
		return p;
	}
}
