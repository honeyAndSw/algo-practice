package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static leetcode.MergeIntervals56.Interval;
import static org.junit.Assert.assertEquals;

/**
 * Created by honey.and.sw on 2017. 12. 17.
 */
public class MergeIntervals56Test {
    MergeIntervals56 solution = new MergeIntervals56();

    @Test
    public void test0() throws Exception {
        assertEquals(2,
            solution.merge(Arrays.asList( // [2,6],[8,10]
                new Interval(2,6), new Interval(8,10))
            ).size());

        assertEquals(1,
            solution.merge(Arrays.asList( // [2,6],[2,6]
                new Interval(2,6), new Interval(2,6))
            ).size());

        assertEquals(1,
            solution.merge(Arrays.asList( // [2,6],[1,10]
                    new Interval(2,6), new Interval(1,10))
            ).size());
    }

    @Test
    public void test1() throws Exception {
        assertEquals(3,
            solution.merge(Arrays.asList( // [1,3],[2,6],[8,10],[15,18]
                new Interval(1,3), new Interval(2,6), new Interval(8,10), new Interval(15,18))
            ).size());

        assertEquals(2, // [1,3],[2,6],[2,10],[15,18]
            solution.merge(Arrays.asList(
                new Interval(1,3), new Interval(2,6), new Interval(2,10), new Interval(15,18))
            ).size());
    }

    @Test
    public void test2() throws Exception {
        assertEquals(1, // [2,3],[4,5],[1,6]
            solution.merge(Arrays.asList(
                    new Interval(2,3), new Interval(4,5), new Interval(1, 6))
            ).size());
    }
}