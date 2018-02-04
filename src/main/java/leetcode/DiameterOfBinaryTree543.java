package leetcode;

public class DiameterOfBinaryTree543 {
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) return 0;
		return Math.max(diameterOfBinaryTree(root.left),
			Math.max(diameterOfBinaryTree(root.right),
				height(root.left) + height(root.right) + (root.left != null && root.right != null ? 2 : 1)
			));
	}

	private int height(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) return 0;
		else return Math.max(height(root.left), height(root.right)) + 1;
	}
}
