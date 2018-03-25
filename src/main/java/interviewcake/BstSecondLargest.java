package interviewcake;

import leetcode.TreeNode;

/**
 * Write a method to find the 2nd largest element in a binary search tree.
 * https://www.interviewcake.com/question/java/second-largest-item-in-bst
 */
public class BstSecondLargest {
	public Integer secondLargest(TreeNode root) {
		// TreeNode answer = recursive(root, null);
		TreeNode answer = iterative(root);
		return answer == null ? null : answer.val;
	}

	TreeNode recursive(TreeNode root, TreeNode largest) {
		if (root == null) {
			return null;
		} else if (root.left == null && root.right == null) {
			return (largest != null && largest.val > root.val) ? root : largest;
		}

		if (root.right != null) {
			// Can find larger ones.
			return recursive(root.right, (largest != null && largest.val > root.val) ? largest : root);
		} else {
			return largest == null ? recursive(root.left, root) : root;
		}
	}

	TreeNode iterative(TreeNode root) {
		if (root == null) return null;

		TreeNode largest = null;
		while (root.left != null || root.right != null) {
			if (root.right != null) {
				largest = (largest != null && largest.val > root.val) ? largest : root;
				root = root.right;
			} else if (largest == null) {
				largest = root;
				root = root.left;
			} else {
				return root;
			}
		}

		return (largest != null && largest.val > root.val) ? root : largest;
	}

}
