package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2018. 1. 7.
 */
public class BinaryTreeRightSideView199Test {
    BinaryTreeRightSideView199 solution = new BinaryTreeRightSideView199();

    private Object[] solve(TreeNode node) {
        return solution.rightSideView(node).toArray();
    }

    @Test
    public void test0() throws Exception {
        assertArrayEquals(new Integer[]{}, solution.rightSideView(null).toArray());
    }

    @Test
    public void test1() throws Exception {
        assertArrayEquals(new Integer[]{1}, solution.rightSideView(new TreeNode(1)).toArray());

        TreeNode root1 = new TreeNode(1, null, new TreeNode(2));
        assertArrayEquals(new Integer[]{1, 2}, solve(root1));

        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        assertArrayEquals(new Integer[]{1, 2}, solve(root2));

        TreeNode root3 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertArrayEquals(new Integer[]{1, 3}, solve(root3));
    }

    @Test
    public void test2() throws Exception {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(5,
                                new TreeNode(8,
                                        new TreeNode(10),
                                        new TreeNode(9)),
                                null),
                        new TreeNode(6,
                                null,
                                new TreeNode(7))),
                new TreeNode(3,
                        null,
                        new TreeNode(4)));

        assertArrayEquals(new Integer[]{1, 3, 4, 7, 9}, solve(root));
    }
}