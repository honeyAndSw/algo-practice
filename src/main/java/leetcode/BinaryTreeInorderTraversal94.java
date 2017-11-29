package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by honey.and.sw on 2017. 11. 29.
 */
public class BinaryTreeInorderTraversal94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        if (root == null) return result;

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.getFirst();
            if (top.left == null && top.right == null) {
                result.add(top.val);
                stack.pop();
            } else if (top.left != null) {
                stack.push(top.left);
                top.left = null;
            } else {
                result.add(top.val);
                stack.pop();
                stack.push(top.right);
                top.right = null;
            }
        }

        return result;
    }
}
