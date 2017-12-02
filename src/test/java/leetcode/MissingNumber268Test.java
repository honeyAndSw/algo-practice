package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by honey.and.sw on 2017. 12. 2.
 */
public class MissingNumber268Test {
    MissingNumber268 solution = new MissingNumber268();

    @Test
    public void test0() throws Exception {
        assertEquals(2, solution.missingNumber(new int[]{3,0,1}));
        assertEquals(2, solution.missingNumber(new int[]{0,1,3}));
        assertEquals(2, solution.missingNumber(new int[]{1,0,3}));
    }

    @Test
    public void test1() throws Exception {
        assertEquals(0, solution.missingNumber(new int[]{3,2,1}));
        assertEquals(1, solution.missingNumber(new int[]{2,0,3}));
        assertEquals(3, solution.missingNumber(new int[]{2,0,1}));
    }

    @Test
    public void test2() throws Exception {
        assertEquals(0, solution.missingNumber(new int[]{1}));
        assertEquals(1, solution.missingNumber(new int[]{0}));
    }

    @Test
    public void test3() throws Exception {
        int[] input = new int[100];
        for (int i = 0; i <= 100; i++) {
            if (i < 90) input[i] = i;
            else if (i > 90) input[i-1] = i;
        }
        assertEquals(90, solution.missingNumber(input));
    }

    @Test
    public void test4() throws Exception {
        int[] input = new int[]{45,35,38,13,12,23,48,15,44,21,43,26,6,37,1,19,22,3,11,32,4,16,28,49,29,36,33,8,9,39,46,17,41,7,2,5,27,20,40,34,30,25,47,0,31,42,24,10,14};
        assertEquals(18, solution.missingNumber(input));
    }
}