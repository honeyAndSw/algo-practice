package leetcode;

import leetcode.utils.Arrays;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by honey.and.sw on 2018. 2. 3.
 */
public class MaximalRectangle85Test {
    MaximalRectangle85 solution = new MaximalRectangle85();

    @Test
    public void test0() throws Exception {
        assertEquals(0, solution.maximalRectangle(Arrays.toCharArray(new int[][]{
            new int[]{0}
        })));

        assertEquals(1, solution.maximalRectangle(Arrays.toCharArray(new int[][]{
                new int[]{1}
        })));

        assertEquals(3, solution.maximalRectangle(Arrays.toCharArray(new int[][]{
                new int[]{0,1,0,1,1,1}
        })));

        assertEquals(3, solution.maximalRectangle(Arrays.toCharArray(new int[][]{
                new int[]{0,1,0,1,1,1,0,1}
        })));
    }

    @Test
    public void test1() throws Exception {
        assertEquals(4, solution.maximalRectangle(Arrays.toCharArray(new int[][]{
                new int[]{0,1,0,1,1,1},
                new int[]{0,1,0,1,1,0}
        })));

        assertEquals(4, solution.maximalRectangle(Arrays.toCharArray(new int[][]{
                new int[]{0,1,0,1,1,1},
                new int[]{0,1,0,1,1,0},
                new int[]{0,1,0,1,0,0}
        })));
    }

    @Test
    public void test2() throws Exception {
        assertEquals(6, solution.maximalRectangle(Arrays.toCharArray(new int[][]{
                new int[]{1,0,1,0,0},
                new int[]{1,0,1,1,1},
                new int[]{1,1,1,1,1},
                new int[]{1,0,0,1,0}
        })));
    }

    @Test
    public void test3() throws Exception {
        assertEquals(12, solution.maximalRectangle(Arrays.toCharArray(new int[][]{
                new int[]{1,1,1,1},
                new int[]{1,1,1,1},
                new int[]{1,1,1,1},
                new int[]{1,1,0,0},
                new int[]{1,1,0,0}
        })));
    }

    @Test
    public void test4() throws Exception {
        assertEquals(21, solution.maximalRectangle(Arrays.toCharArray(new int[][]{
                new int[]{1,1,1,1,1,1,1,1},
                new int[]{1,1,1,1,1,1,1,0},
                new int[]{1,1,1,1,1,1,1,0},
                new int[]{1,1,1,1,1,0,0,0},
                new int[]{0,1,1,1,1,0,0,0}
        })));
    }
}