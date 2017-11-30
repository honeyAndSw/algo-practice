package codility;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 11. 30.
 */
public class MaxCounterTest {

    MaxCounter solution = new MaxCounter();

    private int[] solve(int N, int[] A) {
        return solution.solution2(N, A);
    }

    @Test
    public void test1() throws Exception {
        assertArrayEquals(
            new int[]{3, 2, 2, 4, 2},
            solve(5, new int[]{3, 4, 4, 6, 1, 4, 4})
        );

        assertArrayEquals(
            new int[]{4, 4, 4, 4, 4},
            solve(5, new int[]{3, 4, 4, 6, 1, 4, 4, 6})
        );
    }

    @Test
    public void test2() throws Exception {
        assertArrayEquals(new int[]{0, 0, 3}, solve(3, new int[]{3, 3, 3}));
        assertArrayEquals(new int[]{1, 1, 1}, solve(3, new int[]{3, 2, 1}));
        assertArrayEquals(new int[]{0, 0, 0}, solve(3, new int[]{4, 4, 4}));
        assertArrayEquals(new int[]{1, 1, 1}, solve(3, new int[]{3, 4, 4}));
    }

    @Test
    public void test3() throws Exception {
        assertArrayEquals(new int[]{1}, solve(1, new int[]{1}));
    }

    @Test
    public void test4() throws Exception {
        int max = 100000;
        int[] A = new int[max];
        Arrays.fill(A, max + 1);
        solve(max, A);
    }
}