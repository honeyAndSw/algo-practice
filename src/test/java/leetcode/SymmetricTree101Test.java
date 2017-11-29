package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 11. 30.
 */
public class SymmetricTree101Test {
    SymmetricTree101 solution = new SymmetricTree101();

    @Test
    public void test0() throws Exception {
        assertTrue(solution.isSymmetric(null));
        assertTrue(solution.isSymmetric(new TreeNode(1)));
    }

    @Test
    public void test1() throws Exception {
        // Same left&right node, not symmetric ones.
        assertFalse(solution.isSymmetric(
            new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)))
        ));

        assertTrue(solution.isSymmetric(
            new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, new TreeNode(3), null))
        ));
    }
}