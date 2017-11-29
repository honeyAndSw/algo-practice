package leetcode;

import org.junit.Test;

import static leetcode.BinaryTreeInorderTraversal94.*;
import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 11. 29.
 */
public class BinaryTreeInorderTraversal94Test {

    BinaryTreeInorderTraversal94 solution = new BinaryTreeInorderTraversal94();

    @Test
    public void test0() throws Exception {
        TreeNode node = new TreeNode(1);
        assertArrayEquals(new Integer[]{1}, solution.inorderTraversal(node).toArray());
    }

    @Test
    public void test1() throws Exception {
        TreeNode node = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        assertArrayEquals(new Integer[]{1, 3, 2}, solution.inorderTraversal(node).toArray());
    }

    @Test
    public void test3() throws Exception {
        TreeNode node = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5));
        assertArrayEquals(new Integer[]{3, 2, 4, 1, 5}, solution.inorderTraversal(node).toArray());
    }
}