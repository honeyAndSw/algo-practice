package leetcode;

/**
 * Created by honey.and.sw on 2017. 11. 30.
 */
public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if ((left == null || right == null) || (left.val != right.val)) {
            return false;
        } else {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }
}
