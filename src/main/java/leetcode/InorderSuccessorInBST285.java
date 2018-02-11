package leetcode;

public class InorderSuccessorInBST285 {
	public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
		if (root == null) return null;
		else if (root.val <= p.val) return inorderSuccessor2(root.right, p);
		else {
			TreeNode left = inorderSuccessor2(root.left, p);
			return left == null ? root : left;
		}
	}

	// Do we really need `parent`?
	// `parent` is to remember parent node when going left subtree,
	// because it's one of successor candidates.
	// Then we just could left-side recursion first, then see current node is the answer or not.
	//     5 <---- current
	//   3   7
	// 1  4
	public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
		return inorderSuccessor1(root, p, null);
	}

	private TreeNode inorderSuccessor1(TreeNode root, TreeNode target, TreeNode parent) {
		// if (root.val == target.val) return target.right == null ? parent : leftMost(target.right);
		// else if (root.val > target.val) return inorderSuccessor1(root.left, target, root);
		// else return inorderSuccessor1(root.right, target, parent);

		if (root == null) return parent;
		else if (root.val > target.val) return inorderSuccessor1(root.left, target, root);
		// Special care of `root.val == target.val` is not needed.
		// Just do `leftMost` recursively.
		else return inorderSuccessor1(root.right, target, parent);
	}

	private TreeNode leftMost(TreeNode root) {
		TreeNode p = root;
		while (p.left != null) p = p.left;
		return p;
	}
}
