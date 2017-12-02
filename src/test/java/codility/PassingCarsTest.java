package codility;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 12. 2.
 */
public class PassingCarsTest {
    PassingCars solution = new PassingCars();

    @Test
    public void test0() throws Exception {
        assertEquals(5, solution.solution(new int[]{0,1,0,1,1}));
    }

    @Test
    public void test1() throws Exception {
        assertEquals(0, solution.solution(new int[]{0}));
        assertEquals(0, solution.solution(new int[]{1}));
        assertEquals(0, solution.solution(new int[]{0,0}));
        assertEquals(0, solution.solution(new int[]{1,1}));
    }

    @Test
    public void test2() throws Exception {
        assertEquals(0, solution.solution(new int[]{}));
    }
}