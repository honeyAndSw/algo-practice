package leetcode;

/**
 * LowestCommonAncesterBST235
 */
public class LowestCommonAncesterBST235 {
	/* recursive */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
		else if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
		else return root;
	}

	/* iterative */
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		while ((root.val - p.val) * (root.val - q.val) > 0) {
			// If p and q in the same subtree of root
			root = root.val > p.val ? root.left : root.right;
		}
		return root;
	}
}
