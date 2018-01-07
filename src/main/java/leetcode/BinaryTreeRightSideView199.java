package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by honey.and.sw on 2018. 1. 7.
 */
public class BinaryTreeRightSideView199 {
    public List<Integer> rightSideView(TreeNode root) {
        return rightSideView(root, 0);
    }

    private List<Integer> rightSideView(TreeNode root, int skip) {
        if (root == null) {
            return Collections.emptyList();
        } else if (root.left == null && root.right == null) {
            // leaf
            return (skip <= 0) ? Arrays.asList(root.val) : Collections.emptyList();
        }

        List<Integer> right = rightSideView(root.right, skip - 1);
        List<Integer> left = rightSideView(root.left, Math.max(0, skip - 1) + right.size());

        List<Integer> result = new LinkedList<>();
        if (skip <= 0) {
            result.add(root.val);
        }
        result.addAll(right);
        result.addAll(left);

        return result;
    }
}
