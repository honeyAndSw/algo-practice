package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2018. 4. 2.
 */
public class TopKFrequentElem347Test {
    TopKFrequentElem347 solution = new TopKFrequentElem347();

    @Test
    public void test0() throws Exception {
        assertArrayEquals(new int[]{1,2},
                solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2).stream().mapToInt(i -> i).toArray());
    }
}