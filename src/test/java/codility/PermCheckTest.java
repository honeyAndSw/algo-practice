package codility;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 11. 30.
 */
public class PermCheckTest {
    PermCheck solution = new PermCheck();

    @Test
    public void test0() throws Exception {
        assertEquals(0, solution.solution(new int[]{}));
        assertEquals(1, solution.solution(new int[]{1}));
        assertEquals(1, solution.solution(new int[]{1,2,3}));
        assertEquals(1, solution.solution(new int[]{3,2,1}));
    }

    @Test
    public void test1() throws Exception {
        assertEquals(0, solution.solution(new int[]{1,2,2}));
        assertEquals(0, solution.solution(new int[]{3,2,3}));
    }

    @Test
    public void test2() throws Exception {
        assertEquals(0, solution.solution(new int[]{0}));
        assertEquals(0, solution.solution(new int[]{1000000000}));
    }
}